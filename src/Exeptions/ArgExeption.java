package Exeptions;

public class ArgExeption extends RuntimeException {
    public ArgExeption() {
        System.out.println("Ошибка: неверное число аргументов");
    }
}
