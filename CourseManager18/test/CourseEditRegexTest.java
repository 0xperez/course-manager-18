import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CourseEditRegexTest {
	
	public CourseEditRegexTest() {
		
	}

	@Test
	void testName1() {
		boolean res = "Mathematical methods for Experimental Science 1".matches("^[a-zA-Z0-9\\+\\, ]{1,50}$");
		assertTrue(res);
	}
	
	
	@Test
	void testName2() {
		boolean res = "Java, C++ and other languages".matches("^[a-zA-Z0-9\\+\\, ]{1,50}$");
		assertTrue(res);
	}
	
	
	@Test
	void testName3() {
		boolean res = "Networks-and-Internet".matches("^[a-zA-Z0-9\\+\\, ]{1,50}$");
		assertFalse(res);	
	}
	
	
	void testProf1() {
		boolean res = "John Master".matches("^[a-zA-Z ]{1,40}$");
		assertTrue(res);
	}
	
	void testProf2() {
		boolean res = "Prof. Master".matches("^[a-zA-Z ]{1,40}$");
		assertFalse(res);
	}
	
	void testProf3() {
		boolean res = "".matches("^[a-zA-Z ]{1,40}$");
		assertFalse(res);
	}
	

}
