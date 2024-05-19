// Time Complexity : O(n^n)
// Space Complexity : O(n!)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// BFS
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(s);
        boolean flag = false;

        while (!q.isEmpty()) {
            s = q.poll();
            if (validate(s) == true) {
                flag = true;
                res.add(s);
            }
            if (!flag) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                        String sub = s.substring(0, i) + s.substring(i + 1, s.length());
                        if (!set.contains(sub)) {
                            q.add(sub);
                            set.add(sub);
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean validate(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (count == 0)
                    return false;
                else
                    count--;
            } else if (ch == '(')
                count++;
        }
        return (count == 0);
    }
}

// DFS
class Solution {
    int len = -1;
    HashSet<String> set = new HashSet<>();
    List<String> res = new ArrayList<String>();

    public List<String> removeInvalidParentheses(String s) {
        dfs(s);
        return res;
    }

    public void dfs(String s) {
        if (set.contains(s) || s.length() < len)
            return;
        if (validate(s)) {
            if (s.length() > len) {
                res = new ArrayList<String>();
                len = s.length();
            }
            res.add(s);
        }
        set.add(s);

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                String str = s.substring(0, i) + s.substring(i + 1, s.length());
                dfs(str);
            }
        }
    }

    public boolean validate(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (count == 0)
                    return false;
                count--;
            } else if (ch == '(')
                count++;
        }
        return (count == 0);
    }
}