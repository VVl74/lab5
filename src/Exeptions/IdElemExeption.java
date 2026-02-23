package Exeptions;

public class IdElemExeption extends RuntimeException {
    public IdElemExeption() {
        System.out.println("Ошибка: ID уже занят");
    }
}
