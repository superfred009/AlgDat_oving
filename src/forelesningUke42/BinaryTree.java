package forelesningUke42;

import java.util.ArrayDeque;

public class BinaryTree {

    private static final class Node {        // Nøstet node-klasse

        private char value;
        private Node left_child;
        private Node right_child;

        private Node (char value){                        // Node konstruktør
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        Node addLeftChild(char value) {
            this.left_child = new Node(value);
            return this.left_child;
        }

        Node addRightChild(char value) {
            this.right_child = new Node(value);
            return this.right_child;
        }
    }

    static void printLevelOrder(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // legg til rot-noden
        queue.addLast(root);

        while (!queue.isEmpty()) {
            // Ta ut første fra køen
            Node current = queue.removeFirst();

            // legg til current sine to barn til køen
            if (current.left_child != null) {
                queue.addLast(current.left_child);
            }
            if (current.right_child != null) {
                queue.addLast(current.right_child);
            }

            // Skriv ut
            System.out.print(current.value + " ");
        }
    }

    static void printPreOrder(Node node){
        // Skal skrive ut : A B D E C F G
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreOrder(node.left_child);
        printPreOrder(node.right_child);
    }

    static void printInOrder(Node node){
        // skal skrive ut : D B E A F C G
        if (node == null) {
            return;
        }
        printInOrder(node.left_child);
        System.out.print(node.value + " ");
        printInOrder(node.right_child);
    }

    static void printPostorder(Node node){
        // skal skrive ut : D E B F G C A
        if (node == null) {
            return;
        }
        printPostorder(node.left_child);
        printPostorder(node.right_child);
        System.out.print(node.value + " ");
    }

    static void printPreOrderNonRecursive(Node root) {
        ArrayDeque<Node> stack = new ArrayDeque<>();

        stack.addLast(root);

        while (!stack.isEmpty()) {
            Node current = stack.removeLast();
            if (current.right_child != null) {
                stack.addLast(current.right_child);
            }
            if (current.left_child != null) {
                stack.addLast(current.left_child);
            }
            System.out.print(current.value + " ");
        }
    }

    public static void main(String[] args) {
        // Legg inn roten på nivå 0
        Node root = new Node('A');

        // Legg inn node på nivå 1
        Node b = root.addLeftChild('B');
        Node c = root.addRightChild('C');

        // Legg inn noder på nivå 2
        Node d = b.addLeftChild('D');
        Node e = b.addRightChild('E');

        Node f = c.addLeftChild('F');
        Node g = c.addRightChild('G');

        printLevelOrder(root);
        System.out.println();

        System.out.println("Pre Order : ");
        printPreOrder(root);
        System.out.println();

        System.out.println("In Order : ");
        printInOrder(root);
        System.out.println();

        System.out.println("Post order : ");
        printPostorder(root);
        System.out.println();

        System.out.println("Pre order non recursive : ");
        printPreOrderNonRecursive(root);
    }
}