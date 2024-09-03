/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * DFS Graph
     * Node -> LinkedList
     * runtime: 63.67% (26 ms)
     * memory: 86.15% (42.4 MB)
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visitedMap = new HashMap<>();
        return cloneHelper(visitedMap, node);
    }

    private Node cloneHelper(Map<Node, Node> visitedMap, Node currNode) {
        Node copy = new Node(currNode.val);
        visitedMap.put(currNode, copy);

        for (Node neighbor : currNode.neighbors) {
            if (visitedMap.containsKey(neighbor)) {
                copy.neighbors.add(visitedMap.get(neighbor));
            } else {
                Node neighborCopy = cloneHelper(visitedMap, neighbor);
                copy.neighbors.add(neighborCopy);
            }
        }

        return copy;
    }
}
// @lc code=end

