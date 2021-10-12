package forelesningUke36;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] val = {5, 6, 7, 9, 2, 1, 3, 10, 34, 14, 4, 8, 11, 13};

        bubbleSort(val);
        System.out.println("Sorterte verdier : ");
        System.out.println(Arrays.toString(val));

        int index1 = binarySearchRecursive(val, 9, 0, val.length-1); //binarySearch(val, 12);
        System.out.println("fant tallet 9 på plass "+index1);
    }

    public static int binarySearch(int[] val, int search_val) {
        // Søke etter 6
        // søke i intervallet [L, R]:

        int l = 0;
        int r = val.length-1;
        int m = (l + r) / 2;
        while (l <= r || val[m] == search_val) {
            // hvis midtverdien er større gå til left
            if (val[m]> search_val) {
                r = m-1;
                m = (l + r) / 2;
            } else if (val[m]< search_val){
                l = m+1;
                m = (l + r) / 2;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] val, int search_val, int l, int r){
        int m = (l + r) / 2;

        if (val[m] > search_val){
            r = m - 1;
            return binarySearchRecursive(val, search_val, l, r);
        } else if (val[m] < search_val) {
            l = m + 1;
            return binarySearchRecursive(val, search_val, l, r);
        } else if (val[m] == search_val) {
            return m;
        } else if(l>r){
            return -1;
        } else {
            //Something wrong
            System.out.println("Something wrong!, NaN etc.");
            return -m;
        }
    }


    public static void bubbleSort(int[] val) {
        //to for løkker
        // ytre løkke sorterer ett tall per gjennomgang
        for (int i = 0; i<val.length-1; i++){
            //System.out.println("Array før sortering av index "+i);
            //System.out.println(Arrays.toString(val));
            // indre løkke bobler opp tall til riktig posisjon
            for (int j = val.length-1; j>i; j--){
                //sjekk om tall på posisjon j og j-1 er sortert riktig
                if (val[j] < val[j-1]) {
                    //System.out.println("Inversjon bytter om på "+j+" og "+(j-1));
                    //System.out.println(Arrays.toString(val));
                    int tmp = val[j];
                    val[j] = val[j-1];
                    val[j-1] = tmp;
                }
            }
        }
    }
}