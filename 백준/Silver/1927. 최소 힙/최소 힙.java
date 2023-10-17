import java.io.*;
import java.util.*;


class MinHeap{
    int[] arr;
    int p;
    int size;

    public MinHeap(int capacity) {
        this.arr = new int[capacity + 1];
        this.p = 1;
    }

    public void add(int n){
        arr[p] = n;
        int now = p;
        p++;
        int par = now / 2;
        while (par >= 1){
            if (arr[now] < arr[par]){
                int tmp = arr[now];
                arr[now] = arr[par];
                arr[par] = tmp;
            }else
                break;
            now = par;
            par = now / 2;
        }
        size++;
    }

    public int get(){
        if (size == 0)
            return 0;
        size--;
        int res = arr[1];

        //1번노드 삭제
        arr[1] = arr[--p];
        int par = 1;
        while (par <= p){
            int cl = par * 2;
            int cr = par * 2 + 1;
            if (p >= cl && cr <= p) {
                if (arr[cl] < arr[par] && arr[cl] <= arr[cr]){
                    int tmp = arr[cl];
                    arr[cl] = arr[par];
                    arr[par] = tmp;
                    par = cl;
                }else if (arr[cr] < arr[par] && arr[cr] < arr[cl]){
                    int tmp = arr[cr];
                    arr[cr] = arr[par];
                    arr[par] = tmp;
                    par = cr;
                }else
                    break;
            }else if (p >= cl && cr > p){
                if (arr[cl] < arr[par]){
                    int tmp = arr[cl];
                    arr[cl] = arr[par];
                    arr[par] = tmp;
                    par = cl;
                }else
                    break;
            }else if (cr <= p && cl > p){
                if (arr[cr] < arr[par]){
                    int tmp = arr[cr];
                    arr[cr] = arr[par];
                    arr[par] = tmp;
                    par = cr;
                } else
                    break;
            }else
                break;
        }

        return res;
    }

    void print(){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        MinHeap minHeap = new MinHeap(n);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(st.nextToken());
            if (num == 0) System.out.println(minHeap.get());
            else minHeap.add(num);
        }

    }
}