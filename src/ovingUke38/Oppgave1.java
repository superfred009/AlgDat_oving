package ovingUke38;

public class Oppgave1 {
    public static void main(String[] args) {

    }

    public static int a(int n) {           // n må være et ikke-negativt tall

        if (n == 0) return 1;              // a0 = 1
        else if (n == 1) return 2;         // a1 = 2
        else return 2*a(n-1) + 3*a(n-2);   // to rekursive kall
    }
}
