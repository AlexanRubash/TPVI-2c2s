package connector;

import org.apache.log4j.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

interface MsDAO{
    void printResult();
}
final public  class Mssql extends DAO implements MsDAO {

    private final  Connection con=getConnection();
    private static final Logger log = Logger.getLogger(Mssql.class);
    @Override
    public void printResult() {
        int quntity=0;
        String sql="SELECT PLANETS.NAMES,PLANEtS.RADIUS,PLANETS.TEMPERATURE, PLANETS.HAVE_LIFE,PLANETS.HAVE_ATMOSPHERE,SATELLITES.NAMES FROM dbo.PLANETS INNER JOIN dbo.SATELLITES \n" +
                "\t\tON PLANETS.NAMES = SATELLITES.PLANET;";
        String sql1="SELECT o.NAMES,[Минимальный радиус],isnull([Количество спутников],0) [Количество спутников] FROM (SELECT TOP 1 NAMES, RADIUS [Минимальный радиус] FROM PLANETS rt  order by RADIUS asc) o left outer join (SELECT SATELLITES.PLANET, count(*) [Количество спутников] from SATELLITES\n" +
                "group by SATELLITES.PLANET) s\n" +
                "\t\tON o.NAMES = s.PLANET;";
        String sql2="SELECT TOP 1 rt1.NAMES,[Сумма радиусов] from (SELECT PLANETS.NAMES, sum(SATELLITES.RADIUS)[Сумма радиусов] FROM PLANETS inner JOIN SATELLITES on PLANETS.NAMES = SATELLITES.PLANET GROUP BY PLANETS.NAMES) rt1 order by [Сумма радиусов] desc;";
        try (con){
            System.out.println("Запрос 1");
            try(Statement state=con.createStatement()){
                log.info("Источник запроса: " + sql);
                Scanner scanner=new Scanner(System.in);
                System.out.println("1- без жизни, 2-с жизнью");
                int choose=scanner.nextInt();
                if(choose!=1&&choose!=2){throw new RuntimeException("Не коректный запрос");}
                ResultSet resultSet=  state.executeQuery(sql);
                while (resultSet.next()) {
                    String planetName = resultSet.getString("NAMES");
                    int planetRadius = resultSet.getInt("RADIUS");
                    int planetTemperature = resultSet.getInt("TEMPERATURE");
                    boolean planetHasLife = resultSet.getBoolean("HAVE_LIFE");
                    boolean planetHasAtmosphere = resultSet.getBoolean("HAVE_ATMOSPHERE");
                    if (planetHasAtmosphere == false && choose == 1) {
                        System.out.println("--------------------------------------------");
                        String satelliteName = resultSet.getString("NAMES");
                        System.out.println("Planet: " + planetName);
                        System.out.println("Planet radius: " + planetRadius);
                        System.out.println("Planet temperature: " + planetTemperature);
                        System.out.println("Has life: " + planetHasLife);
                        System.out.println("Has atmosphere: " + planetHasAtmosphere);
                        System.out.println("Satellite name: " + satelliteName);
                    }  if (planetHasAtmosphere==true&&choose==2) {

                        System.out.println("--------------------------------------------");
                        String satelliteName = resultSet.getString("NAMES");
                        System.out.println("Planet: " + planetName);
                        System.out.println("Planet radius: " + planetRadius);
                        System.out.println("Planet temperature: " + planetTemperature);
                        System.out.println("Has life: " + planetHasLife);
                        System.out.println("Has atmosphere: " + planetHasAtmosphere);
                        System.out.println("Satellite name: " + satelliteName);
                    }
                    quntity++;

                }
            }
            try(Statement state=con.createStatement()){
                System.out.println("--------------------------------------------");
                System.out.println("Запрос 2");
                log.info("Источник запроса: " + sql1);

                ResultSet resultSet=  state.executeQuery(sql1);{
                while (resultSet.next()){
                    String planetName = resultSet.getString("NAMES");
                    double minRadius = resultSet.getDouble("Минимальный радиус");
                    int satCount = resultSet.getInt("Количество спутников");

                    System.out.println("Планета: " + planetName);
                    System.out.println("Минимальный радиус: " + minRadius);
                    System.out.println("Количество спутников: " + satCount);
                    quntity++;
                    }
                }
            }
            try(Statement state=con.createStatement()){
                System.out.println("--------------------------------------------");
                System.out.println("Запрос 3");
                log.info("Источник запроса: " + sql2);

                ResultSet resultSet=  state.executeQuery(sql2);{
                while (resultSet.next()){
                    String name = resultSet.getString("NAMES");
                    int sumRadius = resultSet.getInt("Сумма радиусов");
                    System.out.println("Planet: " + name + ", Total radius: " + sumRadius);
                    quntity++;
                    }

                }
            }
            log.info("Количество записей результирующего набора данного запроса: " + quntity);
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }

