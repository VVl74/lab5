package Exeptions;

public class NotElemExeption extends RuntimeException {
    public NotElemExeption() {
        System.out.println("Ошибка: нет элемента с таким ID");
    }
}
