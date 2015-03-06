package com.unico.challenge;

/**
 * @author alex
 *
 */
public class Tree<T> {
	Node<T> root;

	public String getValue() {
		return getValue(root);
	}

	/**
	 * @param node
	 * @return
	 */
	private String getValue(Node<T> node) {
		if (node == null) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder(getValue(node.getLeftChild()));
			sb.append(node.getData());
			sb.append(getValue(node.getRightChild()));
			return sb.toString();
		}
	}
}
