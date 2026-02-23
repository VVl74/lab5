package Exeptions;

public class RecordExeption extends RuntimeException {
    public RecordExeption() {
        System.out.println("Ошибка: запись не удалась");
    }
}
