package dscodes.basicds.DSProject;

import java.util.*;
public class FullMeshTopology {
    protected HashMap<Node,ArrayList<Node>> network;
    public FullMeshTopology() {
        network = new HashMap<>();
    }

    //method for adding node to the network
    public void addNode(Node workstation){

        boolean flag = isDuplicateIp(workstation.getIp());

        if (flag){
            System.out.println("IP address is already in use. Please choose a different IP address. Suggested ip address");
            for (int i = 0 ; i<5 ; i++){
                suggestAlternativeIP();
            }
        }

        else{
            //Connecting all the already present nodes with the given new Node

            for (Node existingNode: network.keySet()
            ) {
                workstation.connections.add(existingNode);
            }

            //Adding the given node to the connection of other nodes present in the network

            for (ArrayList<Node> existingConnections: network.values()
            ) {
                existingConnections.add(workstation);
            }

            //Adding workstation into the network
            network.put(workstation, workstation.connections);
            System.out.println("The given workstation has been connected to the network");
        }

    }

    //Method for checking duplicate ip address
    private boolean isDuplicateIp(String ip){
        boolean res = false;
        for (Node existingNode: network.keySet()
        ) {
            if(existingNode.getIp().equals(ip)){
                res = true;
            }
        }
        return res ;
    }

   //Method for suggesting alternative IP Address to the user in case a duplivate
   // ip address is entered
    private void suggestAlternativeIP() {

        String[] ip = new String[3];
       for (int i = 0; i<3 ; i++){
            double New = (Math.random()*1000);
            int n = (int)New;
            String s = Integer.toString(n);
            ip[i] = s;
       }
       System.out.println("https//."+ip[0]+"."+ip[1]+"."+ip[2]);

    }

    //To check whether the given node is present in the network
    protected boolean isPresent(String nodeName, String ip){
        boolean res = false;
        for (Node presentNode: network.keySet()
             ) {
            if(presentNode.getName().equals(nodeName) && presentNode.getIp().equals(ip)){
                res = true;
                break;
            } else {res = false;}
        }
        return res;
    }
    public void bfsReader(Node inputNode) {
        BFSReader.bfsReader(inputNode, network);}

    public static void menu(){
        FullMeshTopology fullMeshNetwork = new FullMeshTopology();
        String choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("________________Welcome to Full Mesh Topology Network________________________");

        do{
            System.out.println("______________________Choose an option____________:");
            System.out.println("1. Add node");
            System.out.println("2. Connection Test");
            int ch = sc.nextInt();
            sc.nextLine();
            switch(ch) {
                case 1:
                    System.out.print("Enter the name of the node: ");
                    String name = sc.nextLine();//Accept the name

                    System.out.print("Enter the IP address of the node: ");
                    String ip = sc.nextLine();//Accept the IP address

                    Node workStation = new Node(name, ip);//Build an object of Workstation class
                    fullMeshNetwork.addNode(workStation);// Adding the name and IP address
                    break;
                case 2:
                    System.out.println("Enter name: ");
                    String input = sc.nextLine();
                    System.out.println("Enter IP Address: ");
                    String inputIp = sc.nextLine();
                    if(fullMeshNetwork.isPresent(input, inputIp)) {
                        System.out.println("The workstations connected with workstation "+input+ " are: \n");
                        Node inputNode = new Node(input, inputIp);


                        fullMeshNetwork.bfsReader(inputNode);
                    }
                    else{
                        System.out.println("Node not found!");
                    }
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
            System.out.println("Do you want to continue? (Y/N)");
            choice = sc.nextLine();
        }while( choice.equals("Y") || choice.equals("y") );
        System.out.println("Exited");
    }


}






