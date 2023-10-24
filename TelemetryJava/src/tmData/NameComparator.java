package tmData;

import java.util.Comparator;

public class NameComparator implements Comparator<Tm> {
    @Override
    public int compare(Tm tm1, Tm tm2) {
        return tm1.name.compareTo(tm2.name);
    }
}
