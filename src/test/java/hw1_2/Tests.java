package hw1_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
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
    @RepeatedTest(value = 4, name = "корректные оценки добавляются в список")
    public void marksInRange(RepetitionInfo repetitionInfo) {
        int num = repetitionInfo.getCurrentRepetition()+1;
        Student student = new Student("A");
        student.setRepo(Mockito.mock(StudentRepositoryMock.class));
        Mockito.when(student.repo.checkGrade(Mockito.anyInt())).thenReturn(true);
        student.addGrade(num);
        Assertions.assertEquals(student.getGrades().get(0),num);
    }
    @ParameterizedTest(name = "добавление неверных оценок кидает исключение")
    @MethodSource("hw1_2.MarksGenerator#ints")
    public void marksNotInRange(int x) {
        Student student = new Student("A");
        student.setRepo(Mockito.mock(StudentRepositoryMock.class));
        Mockito.when(student.repo.checkGrade(x)).thenReturn(false);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> student.addGrade(x));
    }
}
