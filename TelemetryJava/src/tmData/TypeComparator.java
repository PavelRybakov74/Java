package tmData;

import java.util.Comparator;

public class TypeComparator implements Comparator<Tm> {
    @Override
    public int compare(Tm tm1, Tm tm2) {
        return tm1.type-tm2.type;
    }
}
