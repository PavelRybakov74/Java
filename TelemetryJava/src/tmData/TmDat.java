package tmData;

/**
 * ������ ����� ������ ������ � ���� ���� ������ �� ����� tm.KNP
 * <p>num - ����� ��������� (0 � 1 �����)
 * <p>time - ����� ������������ ��������� (2-5 �����)
 * <p>razm - ����� ����������� (6 ����)
 * <p>type - ��� �������� (4 ������� ���� �� 7 ����� (0x0F))
 * <p>znach - �������� (8-15 �����)
 */
public class TmDat {
    int num;
    long time;
    int razm;
    int type;
    long znachL;
    double znachD;
    long znachC;
    long znachP;
}
