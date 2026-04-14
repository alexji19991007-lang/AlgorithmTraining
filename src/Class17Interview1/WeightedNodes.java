package Class17Interview1;

import java.util.*;

public class WeightedNodes {
    // step 1: finding the starting node and terminal nodes
    // step 2: create a HashMap (key: every node; value: a HashSet representing every possible node from the
    // starting node to the current node (including the starting and the current) )
    // step 3: Using BFS start from the starting node.
            // every time we pop a node from the queue, we first check if it's a terminal node or not.
            // if it is, do nothing
            // if not, we'll find all of its children nodes, add them to the queue, and union all its children
            // nodes' HashSet with the current node's HashSet
    // step 4: Sort all the terminal nodes by their HashSet size in descending order.
    public static List<String> sortTerminalNodes(Map<String, List<String>> dag) {
        
        return new ArrayList<>();
    }

    private static StartAndTerminalNodes findStartAndTerminals(Map<String, List<String>> dag) {
        Set<String> allNodes = new HashSet<>();
        Set<String> allChildrenNodes = new HashSet<>();
        Set<String> terminalNodes = new HashSet<>();

        for (Map.Entry<String, List<String>> entry : dag.entrySet()) {
            String parentNode = entry.getKey();
            List<String> childrenNodes = entry.getValue();
            allNodes.add(parentNode);
            if (childrenNodes.isEmpty()) {
                terminalNodes.add(parentNode);
            }
            for (String child : childrenNodes) {
                allChildrenNodes.add(child);
            }
        }

        String startNode = "";
        for (String node : allNodes) {
            if (!allChildrenNodes.contains(node)) {
                startNode = node;
                break;
            }
        }
        return new StartAndTerminalNodes(startNode, terminalNodes);
    }

    private static class StartAndTerminalNodes {
        public String startNode;
        public Set<String> terminalNodes;

        public StartAndTerminalNodes(String startNode, Set<String> terminalNodes) {
            this.startNode = startNode;
            this.terminalNodes = terminalNodes;
        }
    }
}