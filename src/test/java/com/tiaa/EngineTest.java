package com.tiaa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EngineTest {
	
	@Before
	public void setUp() throws Exception
	{
	   
	}
	
	@After
	public void destroy() throws Exception
	{
	   
	}
	
	@Test
	public void test() throws Exception
	{
	   Engine engine = new Engine();
	   engine.process("C:/My WorkSpaces/NewWS1/example/src/test/resources/in");
	   
	   
	}

}
