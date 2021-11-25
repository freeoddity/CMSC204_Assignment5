import java.util.ArrayList;
import java.util.Arrays;

/** MorseCodeTree class that contains alphabet in a binary tree
 * @author Kevin Gomes
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	
	// Default constructor, sets root and builds tree
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}

	/** Fetches root node
	 *  @return The tree's root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/** Sets the root node
	 *  @param newNode The new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/** Inserts an item into the tree
	 *  @param code The code for the letter in morse code
	 *  @param result The letter to add into the tree
	 *  @return A reference to this
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	/** Adds a node into the tree
	 *  @param root The node's root
	 *  @param code The path of the letter, in morse code
	 *  @param letter The letter to add
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> nextNode = new TreeNode<>(letter);
		char firstChar = code.charAt(0);
		
		if (code.length() == 1) {
			if(firstChar == '.') {
				if (root.left == null) {
					root.left = nextNode;
				}
			} else if(firstChar == '-') {
				if (root.right == null) {
					root.right = nextNode;
				}
			}
		}
			
		else {
			TreeNode<String> newRoot = root;
			String newCode = code.substring(1);
			if(firstChar == '.')
				newRoot = root.left;
			else if (firstChar == '-')
				newRoot = root.right;
			
			addNode(newRoot, newCode, letter);
		}
	}

	/** Fetches letter from tree
	 *
	 * @param code the morse code given to decode
	 * @return The english letter decoded from the given morse code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/** Fetches node from tree
	 * @param root the root node
	 * @param code the morse code given to decode|if it is longer than 1 character then we must recursively call method to find the letter
	 * @return The english letter decoded from the given morse code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String toReturn = "";
		char firstChar = code.charAt(0);
		if (code.length() == 1) {
			if(firstChar == '.') {
				toReturn = root.left.getData();
			} else if(firstChar == '-') {
				toReturn = root.right.getData();
			}
			
		}else {
			TreeNode<String> newRoot = root;
			String newCode = code.substring(1);
			if(firstChar == '.')
				newRoot = root.left;
			else if (firstChar == '-')
				newRoot = root.right;
			
			toReturn = fetchNode(newRoot, newCode);
		}
		
		return toReturn;
	}

	/** This method is not supported
	 * 
	 * @param data unused since the method is not supported
	 * @return unsupported operation exception
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported in the MorseCodeTree");
	}

	/** This method is not supported 
	 * 
	 * @return unsupported operation exception
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported in the MorseCodeTree");
	}

	/** Builds the tree with all letters in the alphabet and the morse code */
	@Override
	public void buildTree() {
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/** Converts the tree to an ArrayList
	 * 
	 * @return ArrayList of the items in the tree, in order
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> toReturn = new ArrayList<>();
		LNRoutputTraversal(root, toReturn);
		return toReturn;
	}

	/** Traversal order to add the node to ArrayList. This a Inorder Traversal
	 * 
	 * @param root The current node's root
	 * @param list The arraylist to add items
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
	}
}
