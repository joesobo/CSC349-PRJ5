import java.util.Scanner;
import java.util.LinkedList;

public class DiGraphTest{
    public static void main(String[] args) {
        boolean finished = false;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of vertices: ");
        DiGraph graph = new DiGraph(scan.nextInt());
        System.out.println();

        printMenu();

        scan.nextLine();

        do {
            int from, to, source;

            //prompt user for choice
            System.out.println("Enter operation: ");

            if(scan.hasNext()){
                String input = scan.nextLine();

                //if user entered more than 1 thing
                if(input.split(" ").length > 1){
                    System.out.println("Invalid option.");
                    continue;
                }

                System.out.println();

                //switch for available user inputs
                switch(input){
                    case "a":
                        System.out.print("Add edge: ");
                        from = scan.nextInt();
                        to = scan.nextInt();

                        scan.nextLine();
                        System.out.println();

                        graph.addEdge(from, to);
                        System.out.println(String.format("\nAdded edge: (%d, %d)", from, to));
                        break;
                    case "d":
                        System.out.print("Delete edge: ");
                        from = scan.nextInt();
                        to = scan.nextInt();

                        scan.nextLine();
                        System.out.println();

                        graph.deleteEdge(from, to);
                        System.out.println(String.format("\nDeleted edge: (%d, %d)", from, to));
                        break;
                    case "e":
                        System.out.println("Number of edges: " + graph.edgeCount());
                        break;
                    case "v":
                        System.out.println("Number of vertexes: " + graph.vertexCount());
                        break;
                    case "p":
                        graph.print();
                        break;
                    case "q":
                        finished = true;
                        System.out.println("Shutting Down...");
                        break;
                    case "t":
                        Integer[] arr = new Integer[graph.vertexCount()];
                        try{   
                            graph.topSort().toArray(arr);
                            System.out.print("Topological sort: ");
                            int i;
                            for(i = 0; i < arr.length-1; i++){
                                System.out.print((arr[i] + 1) + ", ");
                            }
                            System.out.println(arr[i] + 1);
                        }catch(IllegalArgumentException e){
                            System.out.println("Graph is cyclic.");
                        }
                        break;
                    default:
                        //scan.nextLine();
                        //System.out.println();
                        System.out.println("Invalid option.");
                        break;
                }
            }  
        } while(!finished);
        scan.close();
    }

    private static void printMenu(){
        System.out.println("Choose one of the following operations:");
        System.out.println("- add edge (enter a) ");
        System.out.println("- delete edge (enter d) ");
        System.out.println("- edge count (enter e) ");
        System.out.println("- vertex count (enter v) ");
        System.out.println("- print graph (enter p) ");
        System.out.println("- topographical sort (enter t) ");
        System.out.println("- Quit (enter q)\n");
   
    }
}
