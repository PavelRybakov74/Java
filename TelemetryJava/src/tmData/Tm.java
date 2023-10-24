package tmData;

/**
 * ������ ����� ������ ������ � ���� ���� ������ ��� ������ ����������
 * <p>num - ����� �� KNP == DatXML
 * <p>name - ��� �� DatXML
 * <p>znach - �������� �� KNP
 * <p>razm - �������� ����������� �� Dim
 * <p>time - ����� �� KNP
 * <p>type - ��� �� KNP
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
