package Exeptions;

public class ReadExeption extends RuntimeException {
    public ReadExeption(String message) {
        System.out.println("Ошибка: чтение файла не удалось " + message);
    }
}
