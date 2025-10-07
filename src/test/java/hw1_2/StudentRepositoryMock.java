package hw1_2;

public class StudentRepositoryMock implements StudentRepo{
    public boolean checkGrade(int grade) {
        return grade < 2 || grade > 5;
    }
}
