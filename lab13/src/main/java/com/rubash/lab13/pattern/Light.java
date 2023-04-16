// Receiver - класс, который выполняет действия, связанные с выполнением команд
class Light {
    public void turnOn() {
        System.out.println("The light is on");
    }
    public void turnOff() {
        System.out.println("The light is off");
    }
}

// Command - абстрактный класс или интерфейс, который определяет метод execute()
interface Command {
    void execute();
}

// ConcreteCommand - классы, которые реализуют интерфейс Command и представляют конкретные команды
class TurnOnLightCommand implements Command {
    private Light light;
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command {
    private Light light;
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}

// Invoker - класс, который вызывает метод execute() для выполнения определенной команды
class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
}

// Client - класс, который создает объекты команд и настраивает их параметры
class Client {
    public static void main(String[] args) {
        // Создаем Receiver
        Light light = new Light();
        // Создаем команды и передаем им Receiver
        Command turnOnLightCommand = new TurnOnLightCommand(light);
        Command turnOffLightCommand = new TurnOffLightCommand(light);
        // Создаем Invoker
        RemoteControl remoteControl = new RemoteControl();
        // Настраиваем Invoker, передавая ему команду
        remoteControl.setCommand(turnOnLightCommand);
        // Вызываем Invoker, который вызовет команду
        remoteControl.pressButton();
        // Меняем команду у Invoker
        remoteControl.setCommand(turnOffLightCommand);
        // Вызываем Invoker с новой командой
        remoteControl.pressButton();
    }
}