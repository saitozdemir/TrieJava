import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Trie {
    static Scanner input = new Scanner(System.in); //Scanner was used to take input from the user
	public class TrieNode {
		Map<Character, TrieNode> children; // Map of children--key-value
		char c;
		boolean isWord;

		public TrieNode(char c) { // Constructor
			this.c = c;
			children = new HashMap<>(); // Initialize the children
		}

		public TrieNode() { 
			children = new HashMap<>(); 
		}

		public void insert(String word) { // Inserts a word into the trie
			if (word == null || word.isEmpty()) // If the word is null or empty, return
				return;
			char firstChar = word.charAt(0); // Get the first character of the word
			TrieNode child = children.get(firstChar); // Get the child of the first character
			if (child == null) { // If the child is null, create a new node
				child = new TrieNode(firstChar);
				children.put(firstChar, child); // Add the child to the children map
			}

			if (word.length() > 1) // If the word is more than one character long, recursively call insert
				child.insert(word.substring(1)); 
			else // Otherwise, set the isWord to true
				child.isWord = true;
		}

	}

	TrieNode root; // Root of the trie

	public Trie(List<String> words) { // Constructor
		root = new TrieNode();
		for (String word : words) // For each word in the list of words
			root.insert(word);

	}

	public boolean find(String prefix, boolean exact) { // Finds a prefix in the trie
		TrieNode lastNode = root;
		for (char c : prefix.toCharArray()) { // For each character in the prefix
			lastNode = lastNode.children.get(c); // Get the child of the character
			if (lastNode == null) // If the child is null, return false
				return false;
		}
		return !exact || lastNode.isWord; // If the exact flag is false, return true
	}

	public boolean find(String prefix) { // Finds a prefix in the trie
		return find(prefix, false); // Call find with the exact flag set to false
	}

	public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) { // Helper method for suggest
		if (root.isWord) { // If the root is a word, add the word to the list
			list.add(curr.toString()); // Add the word to the list as a string
		}

		if (root.children == null || root.children.isEmpty()) // If the root has no children, return
			return;

		for (TrieNode child : root.children.values()) { // For each child of the root
			suggestHelper(child, list, curr.append(child.c)); // Recursively call suggestHelper
			curr.setLength(curr.length() - 1); 
		}
	}

	public List<String> suggest(String prefix) { // Suggests words in the trie created a new list
		List<String> list = new ArrayList<>();
		TrieNode lastNode = root; // Get the last node of the root
		StringBuffer curr = new StringBuffer(); // Create a new string buffer
		for (char c : prefix.toCharArray()) { // For each character in the prefix
			lastNode = lastNode.children.get(c);
			if (lastNode == null)
				return list;
			curr.append(c);
		}
		suggestHelper(lastNode, list, curr);
		return list;
	}


	public static void main(String[] args) {
		
		List<String> list = Stream.of("mark", "markus", "marcel", "marcello", "david", "davian").collect(Collectors.toCollection(ArrayList::new)); // Create a list of words with Stream
        System.out.println("Enter a name!");
		String value = input.nextLine(); // Take input from the user*******Add method
	    list.add(value); // Add the input to the list*******Add method
		Trie trie = new Trie(list);	// Create a new trie
		while (true)
			{
		    	System.out.println("Please enter a valid number!\n1- Enter 1 to search a letter or word\n0- Exit");
		    	int id = Integer.parseInt(input.nextLine()); // Take input from the user
		    	switch (id) /// Switch statement to take input from the user
            	{
		    		case 0: 
		    			System.out.println("Exit");
		    			break;
		    		case 1:
                        System.out.println("Please enter a search name!");
                        String search = input.nextLine(); //******search method
                        System.out.println(trie.suggest(search)); // Call suggest method in trie class******search method
                        break;
		    		default:
		    			System.out.println("Please enter a valid value!");                        
		    			break;
		    	}
		    	if (id == 0)
		    	{
		    		break; // Break if the user enters 0
		    	}
		    }
	}
}
