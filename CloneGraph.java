// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();

        q.add(node);
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (Node neighbor : cur.neighbors) {

                if (neighbor != null && !map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }

                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}

// DFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    public void dfs(Node cur, HashMap<Node, Node> map) {
        if (map.containsKey(cur))
            return;

        map.put(cur, new Node(cur.val));

        for (Node neighbor : cur.neighbors) {
            dfs(neighbor, map);
            map.get(cur).neighbors.add(map.get(neighbor));
        }
    }
}