import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Node initialNode = new Node('A', null, null);
    static class Node {
        char value;
        Node left;
        Node right;
        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(initialNode, root, left, right);
        }

        preOrder(initialNode);
        sb.append("\n");
        inOrder(initialNode);
        sb.append("\n");
        postOrder(initialNode);
        System.out.println(sb);
    }

    static void insertNode(Node node, char root, char left, char right){
        if(node.value == root){
            node.left = (left == '.' ? null : new Node(left, null, null));
            node.right = (right == '.' ? null : new Node(right, null, null));
            return;
        }
        if(node.left != null) {
            insertNode(node.left, root, left, right);
        }
        if(node.right != null) {
            insertNode(node.right, root, left, right);
        }
    }

    static void preOrder(Node node){
        if(node==null) return;
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}
