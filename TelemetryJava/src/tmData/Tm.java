package tmData;

/**
 * Объект этого класса хранит в себе одну запись для вывода результата
 * <p>num - номер из KNP == DatXML
 * <p>name - имя из DatXML
 * <p>znach - значение из KNP
 * <p>razm - название размерности из Dim
 * <p>time - время из KNP
 * <p>type - тип из KNP
 */
public class Tm implements Comparable<Tm>{
    int num;
    String name;
    long znachL;
    double znachD;
    long znachC;
    long znachP;
    String razm;
    String time;
    int type;

    @Override
    public int compareTo(Tm anotherTm) {
        return this.num-anotherTm.num;
    }
}
