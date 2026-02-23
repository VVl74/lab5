package Exeptions;

public class RecursExeption extends RuntimeException {
    public RecursExeption() {
        System.out.println("Ошибка: бесконечная рекурсия чтения скриптов");
    }
}
