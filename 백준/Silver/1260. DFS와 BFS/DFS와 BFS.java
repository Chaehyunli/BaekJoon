import java.util.*;

class Main {

    static class Node{
        int value;
        List<Node> next = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }
    }

    static class Graph {
        Node[] nodes;
        boolean[] visited;

        Graph(int size) {
            nodes = new Node[size + 1];
            visited = new boolean[size + 1];
            for (int i = 1; i <= size; i++) {
                addNode(i);
            }
        }

        void addNode(int value) {
            nodes[value] = new Node(value);
        }

        void addEdge(int from, int to) {
            nodes[from].next.add(nodes[to]);
            nodes[to].next.add(nodes[from]); // 무방향 그래프
        }

        void sortEdges() {
            for (int i = 1; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    nodes[i].next.sort(Comparator.comparingInt(n -> n.value));
                }
            }
        }

        void dfs(int start) {
            Arrays.fill(visited, false);
            Stack<Node> stack = new Stack<>();
            stack.push(nodes[start]);

            while (!stack.isEmpty()) {
                Node current = stack.pop();

                if (visited[current.value]) continue;
                visited[current.value] = true;
                System.out.print(current.value + " ");

                // 오름차순 방문을 위해 역순 push
                List<Node> neighbors = new ArrayList<>(current.next);
                Collections.reverse(neighbors);

                for (Node next : neighbors) {
                    if (!visited[next.value]) {
                        stack.push(next);
                    }
                }
            }

            System.out.println();
        }

        void bfs(int start) {
            Arrays.fill(visited, false);
            Queue<Node> queue = new LinkedList<>();
            visited[start] = true;
            queue.offer(nodes[start]);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                System.out.print(current.value + " ");

                for (Node next : current.next) {
                    if (!visited[next.value]) {
                        visited[next.value] = true;
                        queue.offer(next);
                    }
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int K = sc.nextInt(); // 시작 정점의 번호

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.addEdge(from, to);
        }

        graph.sortEdges(); // 오름차순 정렬
        graph.dfs(K);
        graph.bfs(K);
        
        sc.close();
    }
}
