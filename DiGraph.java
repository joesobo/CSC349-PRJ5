//DiGraph
//By Joseph Soboleski (jsoboles@calpoly.edu) and Salman Wajahat (swajahat@calpoly.edu)
//5/28/19

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class DiGraph{
    private LinkedList<Integer>[] graph;
    private int N;

    //constructor
    public DiGraph(int N){
        this.N = N;
        this.graph = (LinkedList<Integer>[])new LinkedList[N];
        for(int i = 0; i < N; i++){
            this.graph[i] = new LinkedList<Integer>();
        }
    }

    //private nested class
    private class VertexInfo {
        private int length;
        private int predecessor;

        public VertexInfo(int length, int predecessor){
            this.length = length;
            this.predecessor = predecessor;
        }
    }

    //private nested class
    private class TreeNode {
        private int vertexNum;
        private LinkedList<TreeNode> children;

        public TreeNode(int vertexNum, LinkedList<TreeNode> children){
            this.vertexNum = vertexNum;
            this.children = children;
        }
    }

    //Breadth first search of graph
    private VertexInfo[] BFS(int s){
        LinkedList<Integer> queue = new LinkedList<>();
    }

    //returns if there is a path between from and to
    public boolean isTherePath(int from, int to){

    }

    //returns shortest distance between from and to
    public Integer lengthOfPath(int from, int to){

    }

    //arranges output of shortest path if reachable and prints it out
    public void printPath(int from, int to){

    }

    //returns root of BFS tree
    private TreeNode buildTree(int s){

    }

    //prints BFS tree
    public void printTree(int s){

    }

    //5 public methods
    //adds to vertex as froms neighbor
    public void addEdge(int from, int to){
        //check for existance
        LinkedList<Integer> fromVertex = graph[from-1];
        if(!fromVertex.contains((Integer)to-1)){
            fromVertex.add(to-1);
        }
    }

    //remove to vertex as from neighbor
    public void deleteEdge(int from, int to){
        //check for existance
        LinkedList<Integer> fromVertex = graph[from-1];
        fromVertex.removeFirstOccurrence((Integer)to-1);
    }

    //returns number of edges in graph
    public int edgeCount(){
        int edgeCount = 0;
        for(int i = 0; i < graph.length; i++){
            edgeCount += graph[i].size();
        }
        return edgeCount;
    }

    //returns number of vertices in the graph (array length)
    public int vertexCount(){
        return graph.length;
    }

    //output formatted graph
    public void print(){
        for(int i = 0; i < vertexCount(); i++){
            System.out.print((i + 1) + " is connected to: ");
            //get linked list
            LinkedList<Integer> vertex = graph[i];
            int adjacent = vertex.size();
            //linked list empty
            if(adjacent == 0){
                System.out.println();
                continue;
            }

            //loop through to N-1
            int v;
            for(v = 0; v < adjacent - 1; v++){
                Integer V = vertex.get(v);
                System.out.print((V.intValue() + 1) + ", ");
            }
            Integer V = vertex.get(v);
            System.out.println(V.intValue() + 1);
        }
    }
    private Integer[] indegrees() {
        int N = graph.length;
        int indegree[] = new int[N];
        Integer f[] = new Integer[N];

        for(int v = 0; v < N; v++){
            LinkedList<Integer> vertex = graph[v];
            for(Integer i : vertex){
                indegree[i.intValue()]++;
            }
        }

        for(int i = 0; i < N; i++){
            f[i] = indegree[i];
        }

        return f;
    }

    public ArrayList<Integer> topSort() throws IllegalArgumentException {
        int N = vertexCount();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        Integer indegrees[] = indegrees();
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(graph.length == 0 || graph == null){
            return new ArrayList<Integer>();
        }

        for(int i = 0; i < N; i++){
            if(indegrees[i].intValue() == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            Integer vertex = queue.remove();
            result.add(vertex);

            LinkedList<Integer> vertexes = graph[vertex];
            for(Integer edge : vertexes){
                indegrees[edge] = indegrees[edge] - (Integer)1;
                if(indegrees[edge] == (Integer)0){
                    queue.add(edge);
                }
            }
        }

        if(result.size() != N){
            throw new IllegalArgumentException();
        }

        return new ArrayList<Integer>(result);
    }
}
