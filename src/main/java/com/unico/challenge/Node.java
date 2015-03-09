package com.unico.challenge;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author alex
 *
 */
public class Node {

	private final List<Node> children = new LinkedList<>();

	private final String name;

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Node> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public boolean isLeaf() {
		return children.isEmpty();
	}

	public void addChild(Node child) {
		if (!children.contains(child)) {
			children.add(child);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Node)) {
			return false;
		}
		Node that = (Node) o;
		return this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
