import java.io.*;
import java.util.*;

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static int[] postOrder, inOrder, inOrderIdx, postOrderIdx;
    static int n;
    enum DIR{
        LEFT,
        RIGHT
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            inOrder = new int[n];
            inOrderIdx = new int[n + 1];
            postOrder = new int[n];
            postOrderIdx = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inOrder[i] = Integer.parseInt(st.nextToken());
                inOrderIdx[inOrder[i]] = i;
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                postOrder[i] = Integer.parseInt(st.nextToken());
                postOrderIdx[postOrder[i]] = i;
            }

            Node head = new Node(postOrder[n - 1], null, null);
            int rootIdx = inOrderIdx[postOrder[n - 1]];
            int leftEnd = rootIdx - 1;
            int rightCnt = n - 1 - rootIdx;
            int leftCnt = rootIdx;
            if (leftEnd >= 0)
                makeNode(head, 0, leftEnd, 0, leftCnt - 1, DIR.LEFT);
            int rightStart = rootIdx + 1;
            if (rightStart < n)
                makeNode(head, rightStart, n - 1, leftCnt, leftCnt + rightCnt - 1, DIR.RIGHT);
            printNode(head);
        }
    }

    private static void printNode(Node head) {
        System.out.print(head.val + " ");
        if (head.left != null)
            printNode(head.left);
        if(head.right != null)
            printNode(head.right);
    }

    private static void makeNode(Node head, int inStart, int inEnd, int poStart, int poEnd, DIR dir) {
        Node node = new Node(postOrder[poEnd], null, null);
        if (dir == DIR.LEFT)
            head.left = node;
        else
            head.right = node;
        if (inStart == inEnd)
            return;

        int rootIdx = inOrderIdx[postOrder[poEnd]];
        int rightCnt = inEnd - rootIdx;
        int leftEnd = rootIdx - 1;
        if (leftEnd >= inStart)
            makeNode(node, inStart, leftEnd, poStart, poEnd - rightCnt - 1, DIR.LEFT);
        int rightStart = rootIdx + 1;
        if (rightStart <= inEnd)
            makeNode(node, rightStart, inEnd, poEnd - rightCnt, poEnd - 1, DIR.RIGHT);
    }

}