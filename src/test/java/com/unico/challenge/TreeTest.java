package com.unico.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * @author alex
 *
 */
public class TreeTest {

	@Before
	public void setup() {

	}

	@Test(expected = NullPointerException.class)
	public void constructTree_with_nullNode_causes_exception() {
		new Tree(null);
		fail("An exception should have been raised");
	}

	@Test
	public void getValue_prints_open_and_close_tag() {
		Node singleNode = new Node("single");
		Tree t = new Tree(singleNode);
		String result = t.getValue();
		assertEquals("<single></single>", result);
	}

	@Test
	public void getValue_with_complex_tree_prints_all_nodes_in_single_line() {
		String rootTag = "rootTag";
		String childTag = "childTag";
		Node root = new Node(rootTag);
		Node child = new Node(childTag);
		root.addChild(child);
		String result = new Tree(root).getValue();
		assertEquals("<rootTag><childTag></childTag></rootTag>", result);
	}

	@Test
	public void prettyPrint_single_node_has_no_tab() {
		Node singleNode = new Node("single");
		Tree t = new Tree(singleNode);
		String result = t.getPrettyPrint();
		assertEquals("<single>\n</single>", result);
	}

	@Test
	public void prettyPrint_with_complex_tree_prints_multiLines_and_indents() {
		String rootTag = "rootTag";
		String childTag = "childTag";
		Node root = new Node(rootTag);
		Node child = new Node(childTag);
		root.addChild(child);
		String result = new Tree(root).getPrettyPrint();
		assertEquals("<rootTag>\n\t<childTag>\n\t</childTag>\n</rootTag>", result);
	}
}
