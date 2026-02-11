package Commands;

public class Help implements Command {
    public void execute() {
        System.out.println("вывести тут стену текста");
        System.out.println("про все команды кучей принтов");
    }
    public String getName() {
        return "help";
    }
    public String getDescription() {
        return "1234";
    }
}
