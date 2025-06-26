import java.util.StringJoiner;
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;
        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    TrieNode root;
    public Solution() {
        root = new TrieNode();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) 
        {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }
    /** Returns if the word is in the trie. */
    public String search(String word) 
    {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                return word;
            }
            crawler = crawler.children[index];
            if (crawler.isEndOfWord) {
                return word.substring(0, i + 1);
            }
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sent) 
    {
        for(String word : dict) 
        {
            insert(word);
        }
        String[] words = sent.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        for (String word : words) 
        {
            sj.add(search(word));
        }
        return sj.toString();
    }
}