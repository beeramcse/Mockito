package com.mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class TodoBusinessImplTest {

	@Test
	public void testRetrieveTodosRelatedToSpring() {
		List<String> list=Arrays.asList("spring java","spring boot","learn dance");
		TodoService todoservice=mock(TodoService.class);
		when(todoservice.retrieveTodos("dummy")).thenReturn(list);
		TodoBusinessImpl impl=new TodoBusinessImpl(todoservice);
		List<String> fliteredList=impl.retrieveTodosRelatedToSpring("dummy");
		
		assertEquals(2, fliteredList.size());
		
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_withEmptyList() {
		TodoService todoservice=mock(TodoService.class);
		TodoBusinessImpl impl=new TodoBusinessImpl(todoservice);
		List<String> fliteredList=impl.retrieveTodosRelatedToSpring("dummy");
		
		assertEquals(0, fliteredList.size());
		
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring() {
		List<String> list=Arrays.asList("spring java","spring boot","learn dance");
		TodoService todoservice=mock(TodoService.class);
		when(todoservice.retrieveTodos("dummy")).thenReturn(list);
		TodoBusinessImpl impl=new TodoBusinessImpl(todoservice);
		impl.deleteTodosNotRelatedToSpring("dummy");
		
          verify(todoservice).deleteTodo("learn dance");
          verify(todoservice,Mockito.never()).deleteTodo("spring java");
          verify(todoservice,Mockito.times(2)).deleteTodo("learn dance");
	}
}
