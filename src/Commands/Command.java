package Commands;

public interface Command {
    void execute();
    String getName();
    String getDescription();
}
