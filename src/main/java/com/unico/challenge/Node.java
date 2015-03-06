package com.unico.challenge;

/**
 * @author alex
 *
 */
public class Node<T> {

	private Node<T> leftChild;
	private Node<T> rightChild;

	private Node<T> parent;

	private final T data;

	public Node(Node<T> parent, T data) {
		this.parent = parent;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public Node<T> getLeftChild() {
		return leftChild;
	}

	public Node<T> getRightChild() {
		return rightChild;
	}

	public Node<T> getParent() {
		return parent;
	}

	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}
}
