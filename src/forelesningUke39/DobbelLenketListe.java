package forelesningUke39;

public class DobbelLenketListe {


    public static void main(String[] args) {
        DobbelLenketListe values = new DobbelLenketListe();

        values.add_first(3);
        values.print();
        // forventer: 3,

        values.add_first(1);
        values.print();
        // forventer: 1, 3,

        values.add_first(7);
        values.print();
        // forventer: 7, 1, 3,
    }

    /**
     * Representasjon av en node i dobbelt lenket liste
     */
    static class Node {
        int value; // verdien vi vil lagre, burde brukt generics
        Node next; // peker til neste node eller null
        Node prev; // peker til forrige node eller null

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    // variabler i klassen
    Node head; // peker til første node i den lenkede listen
    Node tail; // peker til siste node i den lenkede listen
    int num_values; // antall verdier i den lenkede listen

    // Konstruktør
    DobbelLenketListe() {
        this.head = null;
        this.tail = null;
        this.num_values = 0;
    }

    public void print() {
        // alternativ 1: skriv som for-løkke
        Node p = head;
        for (int i = 0; i<num_values; i++) {
            System.out.print(p.value + ", ");
            p = p.next;
        }
        System.out.println();

        // alternativ 2: skriv som while-løkke
        Node q = head;
        while(q != null) {
            System.out.print(q.value + ", ");
            q = q.next;
        }
        System.out.println();
    }

    // add funksjon som legger til ved hode-enden
    int add_first(int value) {
        Node p = new Node(value);

        // Spesialtilfelle: vi har tom liste
        // head == null
        // tail == null
        if (head == null && tail == null){
            head = p;
            tail = p;
            num_values++;
        }
        // generelt tilfelle: vi har noder allerede
        else {
            Node q = head;
            head = p;
            q.prev = p;
            p.next = q;
            num_values++;
        }

        return num_values;
    }

    // add funksjon som legger til ved hale-enden
    void add_last() {

    }

    // insert - legger til ny node med index index
    void insert(int index, int value) {

        if (index == 0) {
            // spesialtilfelle - add_first
        }

        if (index == num_values-1) {
            // spesialtilfelle - add_last
        }

        Node q = new Node(value);

        // finn de nodene vi skal sette inn q mellom
        // slik at vi får p - q - r i listen vår
        Node r = head;
        for (int i = 0; i<index; i++) {
            r = r.next;
        }
        Node p = r.prev;

        p.next = q;
        q.next = r;
        q.prev = p;
        r.prev = q;
    }


}
