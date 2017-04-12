class BinaryTreeHeight {

    static int leftHeight = 0;
    static int rightHeight = 0;

	static int height(Node root) {
        return findHeight(root) - 1;
    }

    static int findHeight(Node node){
        if (node != null){
            return Math.max(findHeight(node.left), findHeight(node.right)) + 1;
        } else {
            return 0;
        }
    }

    /*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/

    public static void main(String[] args) {
        // Instantiate new BinaryTree based on Node above
        // System.out.println(height(root));
    }	
}