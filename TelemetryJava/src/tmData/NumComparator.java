package tmData;

import java.util.Comparator;

public class NumComparator implements Comparator<Tm> {
    @Override
    public int compare(Tm tm1, Tm tm2) {
        return tm1.num-tm2.num;
    }
}