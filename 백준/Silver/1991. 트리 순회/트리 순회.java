
import java.io.*;
import java.util.*;


class Node{
    String n;
    Node left;
    Node right;

    public Node(String n, Node left, Node right) {
        this.n = n;
        this.left = left;
        this.right = right;
    }
}
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            Node head = new Node("A", null, null);
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String p = st.nextToken();
                String left = st.nextToken();
                String right = st.nextToken();
                addNode(p, left, right, head);
            }
            printNode1(head);
            System.out.println();
            printNode2(head);
            System.out.println();
            printNode3(head);
            System.out.println();
        }
    }

    //전위순회
    private static void printNode1(Node head) {
        System.out.print(head.n);
        if (head.left != null)
            printNode1(head.left);
        if (head.right != null)
            printNode1(head.right);
    }

    //중위순회
    private static void printNode2(Node head) {
        if (head.left != null)
            printNode2(head.left);
        System.out.print(head.n);
        if (head.right != null)
            printNode2(head.right);
    }

    //후위순회
    private static void printNode3(Node head) {
        if (head.left != null)
            printNode3(head.left);
        if (head.right != null)
            printNode3(head.right);
        System.out.print(head.n);
    }

    private static void addNode(String target, String left, String right, Node head) {
        if (head.n.equals(target)){
            if (!left.equals("."))
                head.left = new Node(left, null, null);
            if (!right.equals("."))
                head.right = new Node(right, null, null);
            return;
        }
        if (head.left != null)
            addNode(target, left, right, head.left);
        if (head.right != null)
            addNode(target, left, right, head.right);
    }

}