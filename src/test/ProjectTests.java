package test;

import static org.junit.Assert.*;

import app.*;
import org.junit.Before;
import org.junit.Test;


public class ProjectTests {

	private ListInterface<String> list;

	@Before
	public void setup() {
		list = new RecursiveList<String>();
	}

	@Test
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
	}

	@Test
	public void testInsertFirstIsEmptySizeAndGetFirst3() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		list.insertLast("hello");
		list.insertLast("hello1");
		list.insertLast("hello2");
		list.insertLast("hello3");
		list.remove("hello2");
		assertEquals("Inserted and then got an element at the first position", "hello3", list.get(2));
	}

	@Test
	public void testInsertFirstIsEmptySizeAndGetFirst4() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		list.insertFirst("hello3");
		list.insertFirst("hello2");
		list.insertFirst("hello1");
		list.insertFirst("hello");
		assertEquals("Inserted and then got an element at the first position", "hello3", list.getLast());
	}

	@Test(timeout = 500, expected = IllegalStateException.class)
	public void testExceptionOnEmptyGetLast() {
		list.getLast();
	}

	@Test(timeout = 500, expected = ItemNotFoundException.class)
	public void testItemNotFoundExceptionOnRemove() {
		list.insertFirst("hello");
		list.remove("there");
	}

	@Test
	public void testInsertsGetsRemovesS() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertLast("Hello");
		list.insertLast("Hello1");
		list.insertLast("Hello2");
		list.insertLast("Hello1");
		list.insertLast("Hello3");
		list.remove("Hello1");
		list.remove("Hello1");
		//list.insertAt(1, "There");

		assertEquals("Checking position 1.", "Hello1", list.get(2));
	}

	@Test
	public void testInsertsGetsRemovesSize() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.insertLast("Hello");
		list.insertLast("World!");
		list.insertAt(1, "There");

		assertEquals("Checking position 1.", "There", list.get(1));

		assertEquals("Size should be 3", 3, list.size());
		assertEquals("0th element should .equals \"Hello\"", "Hello", list.get(0));
		assertEquals("Last element should .equals \"World!\"", "World!", list.getLast());
		list.insertAt(0, "foo");
		list.insertAt(4, "bar");
		assertEquals("foo", list.get(0));
		assertEquals("bar",  list.get(4));
		assertEquals("Size should be 5", 5, list.size());
		assertEquals("The third element should have been \"World!\"", "World!", list.removeAt(3));
		assertEquals("Size should be 4", 4, list.size());
		assertEquals("Last element should be \"bar\"", "bar", list.getLast());
	}

}
