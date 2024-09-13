import java.util.*;

// Represent an edge between two stations
class Edge {
    int dest;
    int distance;
    int time;

    Edge(int dest, int distance, int time) {
        this.dest = dest;
        this.distance = distance;
        this.time = time;
    }
}

// Represent graph
class Graph {
    private int numberOfStations;
    public ArrayList<ArrayList<Edge>> adjacencyList;

    Graph(int numberOfStations) {
        this.numberOfStations = numberOfStations;
        adjacencyList = new ArrayList<>(numberOfStations);
        for (int i = 0; i < numberOfStations; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addConnection(int source, int destination, int distance, int time) {
        adjacencyList.get(source).add(new Edge(destination, distance, time));
        adjacencyList.get(destination).add(new Edge(source, distance, time));
    }

    // Dijkstra's algorithm for shortest path based on time or distance
    public int dijkstra(int startStation, int endStation, boolean useTime) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> useTime ? edge.time : edge.distance));
        int[] distancesOrTimes = new int[numberOfStations];
        Arrays.fill(distancesOrTimes, Integer.MAX_VALUE);
        distancesOrTimes[startStation] = 0;

        pq.add(new Edge(startStation, 0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int currDest = curr.dest;

            if (currDest == endStation) {
                return distancesOrTimes[endStation];
            }

            for (Edge edge : adjacencyList.get(currDest)) {
                int newMetric = distancesOrTimes[currDest] + (useTime ? edge.time : edge.distance);
                if (newMetric < distancesOrTimes[edge.dest]) {
                    distancesOrTimes[edge.dest] = newMetric;
                    pq.add(new Edge(edge.dest, edge.distance, edge.time));
                }
            }
        }

        return distancesOrTimes[endStation];
    }

    // DFS
    void dfs(int startStation) {
        boolean[] visited = new boolean[numberOfStations];
        dfsUtil(startStation, visited);
    }

    private void dfsUtil(int station, boolean[] visited) {
        visited[station] = true;
        System.out.print(station + " ");

        for (Edge edge : adjacencyList.get(station)) {
            if (!visited[edge.dest]) {
                dfsUtil(edge.dest, visited);
            }
        }
    }

    // BFS
    void bfs(int startStation) {
        boolean[] visited = new boolean[numberOfStations];
        Queue<Integer> queue = new LinkedList<>();

        visited[startStation] = true;
        queue.add(startStation);

        while (!queue.isEmpty()) {
            int station = queue.poll();
            System.out.print(station + " ");

            for (Edge edge : adjacencyList.get(station)) {
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    queue.add(edge.dest);
                }
            }
        }
    }
}
