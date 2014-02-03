//This JUnit test uses Mockito and Hamcrest

package com.kitsunebi.servlet;

import javax.servlet.http.Part;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;



public class GalleryPostTest {

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void getFileNameTest() {
		//Part.getHeader() returns a string in the following format:
		//form-data; name="FILEFORMNAME"; filename="IMG.ext"
		final String IMAGE_NAME = "MyImage.jpg";
		final String PART_HEADER = "form-data; name=\"FILEFORMNAME\"; filename=\""+IMAGE_NAME+"\"";
		Part part = mock(Part.class);
		when(part.getHeader("content-disposition")).thenReturn(PART_HEADER);

		assertEquals(part.getHeader("content-disposition"), PART_HEADER);	//Asserts that the Mockito object mocking is working correctly for the Part object.
		
		
		assertEquals(GalleryPost.getFileName(part), IMAGE_NAME);
		//assertEquals(GalleryPost.getFileName(part), IMAGE_NAME);
	}
	

}
