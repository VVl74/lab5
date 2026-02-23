package Exeptions;

public class InputExeption extends RuntimeException {
    public InputExeption() {
        System.out.println("Ошибка: Неверный тип данных ввода");
    }
}
