package tmData;

import java.util.Comparator;

public class TimeComparator implements Comparator<Tm> {
    @Override
    public int compare(Tm tm1, Tm tm2) {
        return tm1.time.compareTo(tm2.time);
    }
}