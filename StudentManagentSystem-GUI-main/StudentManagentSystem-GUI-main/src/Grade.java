public class Grade {
    private int studentId;
    private int courseId;
    private String grade;

    public Grade(int studentId, int courseId, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Course ID: " + courseId + ", Grade: " + grade;
    }
}