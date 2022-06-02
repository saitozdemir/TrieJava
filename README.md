# TrieJava
A trie class has been created as a priority. 
A key-value relationship was established by creating a HashMap array in it. 
The key value from this generated array structure was injected into the class's constructor. 
An insert method has been created. 
The first character of the value was taken by checking whether the word was entered with the if-else structure. 
If the child is null, it creates a new node and add the child to the children map. 
If the word is more than one character long, recursively it calls insert. 
Otherwise, it sets the isWord to true. 
If the root has no children, values return, for each child of the root. 
It also checks whether the prefix to be searched for exists by creating a find() method. 
Together with the suggestHelper() method, if the root is a word,it adds the word to the list. 
The values of root's children recursively call suggestHelper.
An ArrayList object is created in suggest() methods. 
The root directory is assigned to the TrieNode class as a value. 
All values in toCharArray() are enclosed in children within the parameter in the TrieNode class. 
the resulting values of these parameters are returned to the list suggestHelper() method and the method is executed. 
A list is created in the main method and the names in the homework are written. 
The user is asked to enter a name to be added to the list. 
The resulting list is initially injected into it by deriving a new object from the Trie class we created. 
In addition, this list is used, which is injected to search for the desired word in the while cycle. 
The first method used during the search is the suggest() method, and the word to searched is applied to this method.
