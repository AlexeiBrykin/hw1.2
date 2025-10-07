package hw1_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class Tests {
    @Test
    public void testAddGrade(){
        Student student = new Student("A");
        student.setRepo(Mockito.mock(StudentRepositoryMock.class));
        Mockito.when(student.repo.checkGrade(Mockito.anyInt())).thenReturn(true);
        student.addGrade(4);
        Assertions.assertEquals(4, student.getGrades().get(0));
    }
}
