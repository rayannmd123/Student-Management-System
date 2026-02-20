import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataModel {
    private final ArrayList<Student> students;
    private final ArrayList<Course> courses;
    private final ArrayList<Grade> grades;
    private final Map<Student, Map<Course, Grade>> studentCourseGrades; // Store relationships

    public DataModel() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        grades = new ArrayList<>();
        studentCourseGrades = new HashMap<>();
    }

    // Student Management Methods
    public void addStudent(Student student) {
        students.add(student);
        studentCourseGrades.put(student, new HashMap<>()); // Initialize map for the student
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // Course Management Methods
    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    // Grade Management Methods
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    // Link a student to a course and grade
    public void linkStudentCourseGrade(Student student, Course course, Grade grade) {
        if (studentCourseGrades.containsKey(student)) {
            studentCourseGrades.get(student).put(course, grade);
        }
    }

    // Get all student-course-grade relationships
    public Map<Student, Map<Course, Grade>> getStudentCourseGrades() {
        return studentCourseGrades;
    }
}