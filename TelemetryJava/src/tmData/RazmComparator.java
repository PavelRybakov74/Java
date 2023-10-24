package tmData;

import java.util.Comparator;

public class RazmComparator implements Comparator<Tm> {
    @Override
    public int compare(Tm tm1, Tm tm2) {
        return tm1.razm.compareTo(tm2.razm);
    }
}
