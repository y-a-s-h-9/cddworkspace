import java.util.*;

public class Graph {

    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int U = sc.nextInt() - 1;  
            int V = sc.nextInt() - 1;
            graph[U].add(V);
            graph[V].add(U);
        }

        int A = sc.nextInt() - 1;
        int B = sc.nextInt() - 1;
        int C = sc.nextInt() - 1;

        visited = new boolean[N];
        dfs(A);

        if (!visited[B]) {
            System.out.println("No");
            return;
        }

        visited = new boolean[N];
        dfs(B);

        System.out.println(visited[C] ? "Yes" : "No");
    }

    private static void dfs(int v) {
        if (visited[v]) return;
        visited[v] = true;
        for (int u : graph[v]) {
            dfs(u);
        }
    }
}
