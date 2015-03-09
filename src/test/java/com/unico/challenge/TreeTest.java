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
	public void getValue_with_2node_tree_prints_all_nodes_in_single_line() {
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
	public void prettyPrint_with_2node_tree_prints_multiLines_and_indents() {
		String rootTag = "rootTag";
		String childTag = "childTag";
		Node root = new Node(rootTag);
		Node child = new Node(childTag);
		root.addChild(child);
		String result = new Tree(root).getPrettyPrint();
		assertEquals("<rootTag>\n\t<childTag>\n\t</childTag>\n</rootTag>", result);
	}

	@Test
	public void getValue_with_complex_tree() {
		String rootTag = "rootTag";
		String childTag = "childTag";
		String gTag = "gTag";

		Node root = new Node(rootTag);
		for (int i = 0; i < 5; i++) {
			Node child = new Node(childTag + i);
			root.addChild(child);
			for (int j = 0; j < 5; j++) {
				Node gNode = new Node((gTag + i) + j);
				child.addChild(gNode);
			}
		}

		String result = new Tree(root).getValue();
		assertEquals(
				"<rootTag><childTag0><gTag00></gTag00><gTag01></gTag01><gTag02></gTag02><gTag03></gTag03><gTag04></gTag04></childTag0><childTag1><gTag10></gTag10><gTag11></gTag11><gTag12></gTag12><gTag13></gTag13><gTag14></gTag14></childTag1><childTag2><gTag20></gTag20><gTag21></gTag21><gTag22></gTag22><gTag23></gTag23><gTag24></gTag24></childTag2><childTag3><gTag30></gTag30><gTag31></gTag31><gTag32></gTag32><gTag33></gTag33><gTag34></gTag34></childTag3><childTag4><gTag40></gTag40><gTag41></gTag41><gTag42></gTag42><gTag43></gTag43><gTag44></gTag44></childTag4></rootTag>",
				result);
	}
}
