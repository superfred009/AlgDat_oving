package ovingUke35;

public class avsnitt1_2_1 {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 6, 5, 7, 2, 6};
        Tabellen tabell = new Tabellen();
        System.out.println("Index til minste tall er "+tabell.min(a));
    }


}

class Tabellen {
    public static int min1(int[] a, int from, int end) {
        if (from < 0 || end > a.length || from >= end) {
            throw new IllegalArgumentException("Illegal interval");
        }

        int m = from;
        int min_value = a[from];

        for (int i = from + 1; i < end; i++) {
            if (a[i] < min_value) {
                m = i;
                min_value = a[i];

            }
        }
        return m;
    }

    public static int min(int[] a) {
        return min1(a, 0, a.length);
    }
}
