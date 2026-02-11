package Commands;

public class Info implements Command {
    public void execute() {
        System.out.println("вывести здесь всю инфу о коллекции ");
    }
    public String getName() {
        return "info";
    }
    public String getDescription() {
        return "1234";
    }
}
