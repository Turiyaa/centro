package com.sunyoswego.centro;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	App app = new App();
	
	@Test
	public void testHelloWorld() {
		String helloWorld = "Hello Centro";
		assertEquals(helloWorld, app.helloCentro());
		System.out.println(app.helloCentro());
	}
}
