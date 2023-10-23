
package dscodes.basicds.DSProject;
import java.util.*;
public class BFSReader {
    public static void bfsReader(Node inputNode, HashMap<Node, ArrayList<Node>> network) {
        String res = " ";
        for (Node n : network.keySet()) {
            if (n.getName().equals(inputNode.getName()) && n.getIp().equals(inputNode.getIp())) {
                for (Node c : network.get(n)) {
                    res = c.getName() + "\nIp Address: " + c.getIp() + "\n\n";
                    System.out.println("Workstation name: " + res);
                }
            }
        }
    }
}