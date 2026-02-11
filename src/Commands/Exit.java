package Commands;

public class Exit implements Command {
    public void execute() {
        System.exit(0);
    }
    public String getName() {
        return "help";
    }
    public String getDescription() {
        return "1234";
    }
}
