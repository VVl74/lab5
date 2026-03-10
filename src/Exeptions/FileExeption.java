package Exeptions;

public class FileExeption extends RuntimeException {
    public FileExeption(String message) {
        super("Ошибка, неверный формат ввода: " + message);
    }
}
