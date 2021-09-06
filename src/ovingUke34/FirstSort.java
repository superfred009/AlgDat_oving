package ovingUke34;

public class FirstSort {
    public static void main(String[] args) {
        int values[] = {1, 7, 2, 4, 6, 9};

        myFirstSort(values);

        System.out.println(find2MaxIndex(values, 0, values.length-1));
    }

    /**
     * Findmax - finner index til største tall i et array,
     * men søker bare innenfor tallene i [fra, til)
     */
    public static int findMax(int[] values, int fra, int til) {
        //Initialiser ved å se på første "kort"
        //Dette er det største tallet jeg har funnet
        //så langt
        int index = fra;
        int max_value = values[fra];

        //Sjekk at grensene for løkken er riktig.
        // [1, values.length)
        for (int i=fra+1; i<til; i++) {
            //Sjekk om vi har funnet nytt største tall
            if (values[i] > max_value) {
                max_value = values[i];
                index = i;
            }
        }

        return index;
    }

    public static void myFirstSort(int[] values) {
        for (int k = 0; k < values.length - 1; k++) {
            //Sjekk at vi får fornuftig svar for *ett* tilfelle.
            //Vi må utføre ordentlig testing før vi
            //faktisk kan stole på kildekoden vår
            int max_index = findMax(values, k, values.length);
            //System.out.println("Største verdi ligger på plass "
                    //+ max_index + " og har verdi " + values[max_index]);

            //Bytte plass på tall på plass 0 og max_index
            int temp = values[k];
            values[k] = values[max_index];
            values[max_index] = temp;
            /*
            System.out.println("Bytter plass " + k + " med plass " + max_index);
            System.out.println("Arrayet etter ombytting");
            for (int i = 0; i < values.length; ++i) {
                System.out.print(values[i] + ", ");
            }
            System.out.println();

             */
        }

    }
    // finner index til største og nest største tall, i intervallet [fra, til)
    public static int find2MaxIndex(int[] values, int fra, int til) {
        //Initialiser ved å se på første "kort"
        //Dette er det største tallet jeg har funnet
        //så langt
        if (til-fra < 2) {
            throw new ArrayIndexOutOfBoundsException("Feil i grenser");
        }
        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException("Fra er negativ");
        }
        if (til < 2) {
            throw new ArrayIndexOutOfBoundsException("Til er ikke lang nok");
        }
        if (til > values.length-1) {
            throw new ArrayIndexOutOfBoundsException("Til er ikke lang nok");
        }
        int index_max = fra;
        int index_second_max = fra+1;
        int max_value = values[fra];
        int second_max_value = values[fra+1];

        //sjekker om nest max er større enn max og bytter om
        if (max_value < second_max_value) {
            int temp = max_value;
            max_value = second_max_value;
            second_max_value = temp;

            temp = index_max;
            index_max = index_second_max;
            index_second_max = temp;
            // bør refactores til en egen metode som bytter to variabler
            // for å gjøre koden mer lesbar, og mindre sjanse for feil
        }

        //Sjekk at grensene for løkken er riktig.
        // [fra, til)
        for (int i=fra+2; i<til; i++) {
            //Sjekk om vi har funnet nytt nest største tall
            if (values[i] > second_max_value) {
                //Sjekker om det tallet også er det største
                if (values[i] > max_value) {
                    second_max_value = max_value;
                    index_second_max = index_max;
                    max_value = values[i];
                    index_max = i;
                } else {
                    second_max_value = values[i];
                    index_second_max = i;
                }
            }
        }

        return index_second_max;
    }
}