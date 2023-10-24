package tmData;

import java.util.Comparator;

public class ZnachComparator implements Comparator<Tm> {
    @Override
    public int compare(Tm tm1, Tm tm2) {
        return switch (tm1.type) {
            case 0 -> switch (tm2.type) {
                case 0 -> Long.compare(tm1.znachL, tm2.znachL);
                case 1 -> Double.compare(tm1.znachL, tm2.znachD);
                case 2 -> Long.compare(tm1.znachL, tm2.znachC);
                case 3 -> Long.compare(tm1.znachL, tm2.znachP);
                default -> 0;};
            case 1 -> switch (tm2.type) {
                case 0 -> Double.compare(tm1.znachD, tm2.znachL);
                case 1 -> Double.compare(tm1.znachD, tm2.znachD);
                case 2 -> Double.compare(tm1.znachD, tm2.znachC);
                case 3 -> Double.compare(tm1.znachD, tm2.znachP);
                default -> 0;};
            case 2 -> switch (tm2.type) {
                case 0 -> Long.compare(tm1.znachC, tm2.znachL);
                case 1 -> Double.compare(tm1.znachC, tm2.znachD);
                case 2 -> Long.compare(tm1.znachC, tm2.znachC);
                case 3 -> Long.compare(tm1.znachC, tm2.znachP);
                default -> 0;};
            case 3 -> switch (tm2.type) {
                case 0 -> Long.compare(tm1.znachP, tm2.znachL);
                case 1 -> Double.compare(tm1.znachP, tm2.znachD);
                case 2 -> Long.compare(tm1.znachP, tm2.znachC);
                case 3 -> Long.compare(tm1.znachP, tm2.znachP);
                default -> 0;};
            default -> 0;
        };
    }
}