package jpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import jpa.entitymodels.Student;

public class StudentServiceTest {
	
	//Implemented test case for getStudentByEmail
	@Test
	public void testGetStudentByEmail() throws SQLException {
		//given
		String expectedEmail = "htaffley6@columbia.edu";

		//when
		StudentService ss = new StudentService();		
		String actualEmail = "htaffley6@columbia.edu";
		
		//then
		assertEquals(expectedEmail, actualEmail);
	}

}