import java.util.LinkedList;

public class DiGraph{
    private LinkedList<Integer>[] graph;
    private int N;

    //constructor
    public DiGraph(int N){
        this.N = N;
        this.graph = new LinkedList<Integer>[N];
        for(int i = 0; i < N; i++){
            this.graph[i] = new LinkedList<Integer>();
        }
    }

    //5 public methods
    //adds to vertex as froms neighbor
    public addEdge(int from, int to){
        //check for existance
        LinkedList<Integer> fromVertex = graph[from-1];
        if(!fromVertex.contains((Integer)to-1)){
            fromVertex.add(to-1);
        }
    }

    //remove to vertex as from neighbor
    public deleteEdge(int from, int to){
        //check for existance
        LinkedList<Integer> fromVertex = graph[from-1];
        fromVertex.removeFirstOccurrence((Integer)to-1);
    }

    //returns number of edges in graph
    public edgeCount(){
        int edgeCount = 0;
        for(int i = 0; i < graph.length; i++){
            edges += graph[i].size();
        }
        return edgeCount;
    }

    //returns number of vertices in the graph (array length)
    public vertexCount(){
        return graph.length;
    }

    //output formatted graph
    public print(){
        for(int i = 0; i < vertexCount(); i++){
            System.out.print((i + 1) + " is connected to : ");
            //get linked list
            LinkedList<Integer> vertex = graph[i];
            int adjacent = vertex.size();
            //linked list empty
            if(adjacent == 0){
                System.out.println();
                continue;
            }

            //loop through to N-1
            for(int v = 0; v < adjacent - 1; v++){

            }
        }
    }
}