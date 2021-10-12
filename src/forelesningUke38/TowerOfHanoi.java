package forelesningUke38;

public class TowerOfHanoi {

    public static void main(String[] args) {
        towerOfHanoi(1);
        System.out.println();
        towerOfHanoi(7);
    }

    /**
     * Lager en funksjon som kjører "tower of hanoi"
     * ved hjelp av rekursivt kall
     * @param num_pieces er antall brikker å bruke i spillet
     */
    static void towerOfHanoi(int num_pieces) {
        hanoiMove(num_pieces, 'A', 'C', 'B');
    }

    /**
     * Utfører et rekursivt flytt i "Tower of Hanoi"
     * @param piece_number Brikken vi skal flytte på
     * @param from stikken vi flytter fra
     * @param to stikken vi flytter til
     * @param helper hjelpestikken
     */
    static void hanoiMove(int piece_number, char from, char to, char helper) {
        // Vi slutter rekursjon når vi kommer til øverste brikke (basistilfelle)
        if (piece_number < 0) {
            return;
        }

        // punkt 1: flytt alt fra stikke C til stikke B
        //          bruker stikke A som hjelpestikke
        hanoiMove(piece_number-1, from, helper, to);

        // punkt 2: flytt øverste brikke på A til C
        //          trenger ingen hjelpestikke, flytter bare en brikke
        System.out.println("Flytter brikke "+piece_number+" : "+from+" -> "+to);

        // punkt 3: flytt alt på stikke B (fra punkt 1) over på stikke C
        //          bruker stikke A som hjelpestikke
        hanoiMove(piece_number-1, helper, to, from);
    }
}
