package com.unico.challenge;

/**
 * @author alex
 *
 */
public class Tree {
	private Node root;
	private static final String TAB = "\t";
	private static final String ENDL = "\n";

	public Tree(Node root) {
		if (root == null) {
			throw new NullPointerException("Can;t create a tree with a null Node");
		}
		this.root = root;
	}

	public String getValue() {
		return getValue(root);
	}

	public String getPrettyPrint() {
		return getPrettyPrint(root, 0);
	}

	/**
	 * Returns a String with line breaks for every node and tab indentations
	 * according the node depth
	 * 
	 * @param node
	 * @param depth
	 * @return
	 */
	private String getPrettyPrint(Node node, int depth) {
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			prefix.append(TAB);
		}
		prefix.append("<");
		StringBuilder sb = new StringBuilder();
		sb.append(prefix).append(node.getName()).append(">").append(ENDL);
		if (!node.isLeaf()) {
			int d = depth + 1;
			for (Node n : node.getChildren()) {
				sb.append(getPrettyPrint(n, d)).append(ENDL);
			}
		}
		sb.append(prefix).append("/").append(node.getName()).append(">");
		return sb.toString();
	}

	/**
	 * Return a string with a representation of the node and its children
	 * 
	 * @param node
	 * @return
	 */
	private String getValue(Node node) {
		StringBuilder sb = new StringBuilder("<").append(node.getName()).append(">");
		if (!node.isLeaf()) {
			for (Node n : node.getChildren()) {
				sb.append(getValue(n));
			}
		}
		sb.append("</").append(node.getName()).append(">");

		return sb.toString();
	}
}
