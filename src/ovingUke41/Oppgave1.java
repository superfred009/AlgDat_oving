package ovingUke41;

public class Oppgave1 {
    public static void main(String[] args) {
        // Oppgaver til avsnitt 4.1.1 i kompendiet

        //// Oppgave 1 ////
        Stakk.TabellStakk A = new Stakk.TabellStakk(8);

        A.leggInn(5);
        A.leggInn(7);
        A.leggInn(3);
        A.leggInn(7);
        A.taUt();

        // Nå ligger 3 på toppen
        System.out.println(A);


        //// Oppgave 2 ////
        A.leggInn(2);
        A.leggInn(5);
        A.leggInn(1);
        A.kikk();
        A.taUt();

        // Nå ligger 5 på toppen
        System.out.println(A);

        //// Oppgave 3 /////
        Stakk.TabellStakk B = new Stakk.TabellStakk(8);
        Stakk.TabellStakk C = new Stakk.TabellStakk(8);

        while (!A.tom()) {
            C.leggInn(A.taUt());
        }
        while (!C.tom()) {
            B.leggInn(C.taUt());
        }
        System.out.println("B : "+B);

        /** //// Oppgave 4 ////
         * Man kan snu om rekkefølgen på en stakk ved hjelp av kun én hjelpestakk og én hjelpevariabel:
         * Ved eksempelvis 1, 2, 3, 4, flytter man 4 til temp, resten til andre stakk.
         * Deretter temp til første stakk, og så resten til første stakk. Da har vi 4, 1, 2, 3.
         * Videre flytter vi 3 til temp, og 1 og 2 over, og gjentar første operasjon.
         */

        /** //// Oppgave 5 ////
         * Ja, det er mulig. Ved å gjøre det samme i oppgave 4, slik at stakken
         * er omvendt i A, og deretter flytte over til B.
         */

        /** //// Oppgave 6 ////
         * Ja, det er mulig ved å bruke samme prinsipp som i oppgave 4
         */
    }
}
