package tests.planets;

import junitparams.Parameters;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import planets.Planets;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Tag;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlanetsTest {

    Planets planets1 = new Planets("Pluto",1000,150,true,true);;
    int timeOut;

    @BeforeAll
    public  static void beforeSuite(){
        System.out.println("BeforeSuite запустится до запуска всех тестов");
    }
    @AfterAll
    public void afterSuite(){
        System.out.println("AfterSuite запустится после запуска всех тестов");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Аннотированный метод будет запущен только один раз, прежде чем будет вызван первый тестовый метод в текущем классе.");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Аннотированный метод будет запущен только один раз после запуска всех тестовых методов в текущем классе.");
    }

    @BeforeAll
    public void beforeTest(){
        System.out.println("Аннотированный метод будет запущен только один раз после запуска всех тестовых методов в текущем классе.");
    }

    @AfterAll
    public void afterTest(){
        System.out.println("Аннотированный метод будет запущен после запуска всех тестовых методов, принадлежащих классам внутри тега <test>");
    }

    @BeforeEach
    public void beforeMethod(){
        System.out.println("Аннотированный метод будет запускаться перед каждым тестовым методом.");
    }

    @AfterEach
    public void afterMethod(){
        System.out.println("Аннотированный метод будет запускаться после каждого метода тестирования.");
    }

    @Test
    @Timeout(100)
    @Tag("functest")
    @Tag("checkintest")
    public void testGetName() {
        // act
        String res = planets1.getName();

        // assert
        assertEquals("Pluto", res);
    }


    @Test
    public void testGetRadius() {
        // act
        int res = planets1.getRadius();

        // assert
        Assert.assertEquals(1000, res);
    }

    @Test
    @Timeout(100)
    @Tags(@Tag("functest"))
    public void testGetAvgTemperature() {
        // act
        int res = planets1.getAvgTemperature();

        // assert
        Assert.assertEquals(150, res);
    }

    @Test
    @Timeout(100)
    @Tag("functest")
    @Tag("checkintest")
    public void testIsHaveAtmosphere() {
        // act
        boolean res = planets1.isHaveAtmosphere();

        // assert
        Assert.assertEquals(true, res);
    }

    @Test
    @Timeout(100)
    @Tag("functest")
    @Tag("checkintest")
    public void testIsHaveLife( ) {
        // act
        boolean res = planets1.isHaveAtmosphere();

        // assert
        Assert.assertEquals(true, res);
    }

    @Parameters
    @DisplayName("test1")
    public static Object[] primeNumbers() {
        return new  Object[]{"Pluto","Mars"};
    }

    @Test
    @Timeout(100)
    @Tag ("functest")
    public void testSetAvgTemperature() {
    }

    @Test
    @Timeout(100)
    @Tag ("functest")
    public void testSetHaveAtmosphere() {
    }

    @Test
    @Timeout(100)
    @Tag ("functest")
    public void testSetHaveLife() {
    }

    @Test
    @Tag ("functest" )
    public void initEnvironmentTest() {
        System.out.println("This is initEnvironmentTest");
    }
}