package com.unico.challenge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author alex
 *
 */
public class NodeTest {

	@Test
	public void nodes_are_equal_if_they_have_same_name() {
		Node n = new Node("test");
		Node m = new Node("test");
		assertEquals(n, m);
	}

	@Test
	public void node_can_not_have_repeated_children() {
		Node n = new Node("root");
		for (int i = 0; i < 10; i++) {
			Node m = new Node("child");
			n.addChild(m);
		}

		assertEquals(1, n.getChildren().size());
	}

}
