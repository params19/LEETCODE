class Solution {
    List<String> result = new ArrayList<>();
    int r, c;
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    class TrieNode {
        boolean endOfWord = false;
        TrieNode[] children = new TrieNode[26];
        String word = "";
    }
    TrieNode getNode() 
    {
        return new TrieNode();
    }
    void insert(TrieNode root, String str) 
    {
        TrieNode node = root;
        for (char ch : str.toCharArray()) 
        {
            int idx = ch - 'a';
            if (node.children[idx] == null) 
            {
                node.children[idx] = getNode();
            }
            node = node.children[idx];
        }
        node.endOfWord = true;
        node.word = str;
    }
    void DFS(char[][] board, int i, int j, TrieNode node) 
    {
        if (i < 0 || i >= r || j < 0 || j >= c || board[i][j] == '$' || node.children[board[i][j] - 'a'] == null)
            return;
        node = node.children[board[i][j] - 'a'];
        if (node.endOfWord) 
        {
            result.add(node.word);
            node.endOfWord = false; //DUPLICATE KE LIYE
        }
        char temp = board[i][j];
        board[i][j] = '$';
        for (int[] dir : directions) 
        {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            DFS(board, new_i, new_j, node);
        }
        board[i][j] = temp;
    }

    public List<String> findWords(char[][] board, String[] words) 
    {
        r = board.length;
        c = board[0].length;
        TrieNode root = getNode();
        for (String word : words) 
        {
            insert(root, word);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    DFS(board, i, j, root);
                }
            }
        }
        return result;
    }
}
