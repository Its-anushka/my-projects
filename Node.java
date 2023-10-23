package dscodes.basicds.DSProject;

import java.util.ArrayList;

public class Node {
    /*The object of Node class will have a name, an IP address and an arraylist
    containing all other nodes connected to it */

    private String name;
    private String ip;
    ArrayList<Node> connections;

    Node(String wName, String wIp) {
        this.name = wName;
        this.ip = wIp;
        this.connections = new ArrayList<>();
    }

    //Getters for name and Ip address of the node
    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

}

