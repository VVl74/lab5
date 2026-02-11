package Collection;

public class Chapter implements Comparable<Chapter> {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
    private long marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000
    private String world; //Поле может быть null


    @Override
    public int compareTo(Chapter p) {
        return Double.compare(this.marinesCount, p.marinesCount);
    }
}
