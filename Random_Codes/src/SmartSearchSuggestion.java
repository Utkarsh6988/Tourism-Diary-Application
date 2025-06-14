//The Trie data structure is a tree-like structure used for storing a dynamic set of strings. 
//It allows for efficient retrieval and storage of keys, making it highly effective in handling large datasets. 
//Trie supports operations such as insertion, search, deletion of keys, and prefix searches. 
//In this article, we will explore the insertion and search operations and prefix searches in Trie Data Structure.




import java.util.*;
public class SmartSearchSuggestion {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        String word = null; // store full word at end node
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            node.isWord = true;
            node.word = word;
        }

        TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (!node.children.containsKey(ch)) {
                    return null;
                }
                node = node.children.get(ch);
            }
            return node;
        }

        void dfs(TrieNode node, Map<String, Integer> freqMap, PriorityQueue<String> pq, int topN) {
            if (node == null) return;
            if (node.isWord) {
                pq.offer(node.word);
                if (pq.size() > topN) {
                    pq.poll();
                }
            }
            for (char ch : node.children.keySet()) {
                dfs(node.children.get(ch), freqMap, pq, topN);
            }
        }
    }

    public static List<String> getTopSuggestions(List<String> history, String prefix, int topN) {
        // Step 1: Count frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : history) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Build Trie with unique words
        Trie trie = new Trie();
        for (String word : freqMap.keySet()) {
            trie.insert(word);
        }

        // Step 3: Search prefix node
        TrieNode prefixNode = trie.searchPrefix(prefix);
        if (prefixNode == null) return new ArrayList<>();

        // Step 4: Use PriorityQueue to maintain topN results
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) return freqA - freqB; // min heap by frequency
            return b.compareTo(a); // reverse lexicographical to maintain smallest first
        });

        trie.dfs(prefixNode, freqMap, pq, topN);

        // Step 5: Extract and reverse (since it's a min-heap)
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        List<String> history = Arrays.asList("apple", "app", "application", "app", "apple", "apex", "apply");
        String prefix = "app";
        int topN = 3;

        List<String> suggestions = getTopSuggestions(history, prefix, topN);
        System.out.println(suggestions); // Output: [app, apple, application]
    }
}
