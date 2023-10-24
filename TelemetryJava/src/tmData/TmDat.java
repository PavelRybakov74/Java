package tmData;

/**
 * Объект этого класса хранит в себе одну запись из файла tm.KNP
 * <p>num - номер параметра (0 и 1 байты)
 * <p>time - время формирования параметра (2-5 байты)
 * <p>razm - номер размерности (6 байт)
 * <p>type - тип значения (4 младших бита из 7 байта (0x0F))
 * <p>znach - значение (8-15 байты)
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
