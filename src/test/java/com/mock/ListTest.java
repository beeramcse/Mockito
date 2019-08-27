package com.mock;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void testSize() {
		
		List list=mock(List.class);
		when(list.size()).thenReturn(20);		
		assertEquals(20, list.size());
		
	}
	@Test
	public void testSize_whenmultiplevaluesreturn() {
		
		List list=mock(List.class);
		when(list.size()).thenReturn(20).thenReturn(30).thenReturn(40);
		
		assertEquals(20, list.size());
		assertEquals(30, list.size());
		assertEquals(40, list.size());

	}
	
	@Test
	public void testGetMethod() {
		List list=mock(List.class);
		when(list.get(anyInt())).thenReturn("kondal");
		
		assertEquals("kondal", list.get(0));
		assertEquals("kondal", list.get(1));
		verify(list,Mockito.times(2)).get(anyInt());

		
	}
	
	@Test(expected = RuntimeException.class)
	public void testMockList_throwsException() {
		
		List listmock=mock(List.class);
		when(listmock.get(0)).thenThrow(RuntimeException.class).thenReturn("kondal");
		listmock.get(0);
		listmock.get(1);
		

		
	}
	

}
