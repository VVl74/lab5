package Exeptions;

public class CommandExeption extends RuntimeException {
    public CommandExeption() {

        System.out.println("Ошибка: команда не выполнена");
    }
}
