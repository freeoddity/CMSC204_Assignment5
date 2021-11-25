/** TreeNode class, contains left and right node
 * @author Kevin Gomes
 * @param <T> Place holder for data type of node
 */
public class TreeNode<T> {
	
	TreeNode<T> left;
	TreeNode<T> right;
	private T data;
	
	/** Generic Constructor for Node
	 * @param dataNode Data to be stored in node
	 */
	public TreeNode(T dataNode) {
		left = null; 
		right = null;
		data = dataNode;
	}
	
	/** Copy constructor for the TreeNode
	 * @param node Data to be copied into node
	 */
	public TreeNode(TreeNode<T> node) {
		this(node.getData());
		left = node.left;
		right = node.right;
	}
	
	/** Fetches data from Node
	 * @return The data in the node
	 */
	public T getData() {
		return data;
	}
}
