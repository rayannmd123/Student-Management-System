import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradePanel extends JPanel {
    private final DataModel dataModel;
    private final JList<Grade> gradeList;
    private final DefaultListModel<Grade> listModel;

    public GradePanel(DataModel dataModel) {
        this.dataModel = dataModel;
        setLayout(new BorderLayout());

        // Create list model and JList
        listModel = new DefaultListModel<>();
        gradeList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(gradeList);

        // Add components to the panel
        add(scrollPane, BorderLayout.CENTER);

        // Form for adding grades
        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JTextField studentIdField = new JTextField();
        JTextField courseIdField = new JTextField();
        JTextField gradeField = new JTextField();
        JButton addButton = new JButton("Add Grade");

        formPanel.add(new JLabel("Student ID:"));
        formPanel.add(studentIdField);
        formPanel.add(new JLabel("Course ID:"));
        formPanel.add(courseIdField);
        formPanel.add(new JLabel("Grade:"));
        formPanel.add(gradeField);
        formPanel.add(new JLabel(""));
        formPanel.add(addButton);

        add(formPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentId = Integer.parseInt(studentIdField.getText());
                int courseId = Integer.parseInt(courseIdField.getText());
                String grade = gradeField.getText();

                // Find student and course
                Student student = findStudentById(studentId);
                Course course = findCourseById(courseId);

                if (student != null && course != null) {
                    Grade newGrade = new Grade(studentId, courseId, grade);
                    dataModel.addGrade(newGrade);
                    dataModel.linkStudentCourseGrade(student, course, newGrade); // Link student, course, and grade
                    listModel.addElement(newGrade); // Update the list
                } else {
                    JOptionPane.showMessageDialog(GradePanel.this, "Student or Course not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Utility method to find a student by ID
    private Student findStudentById(int studentId) {
        for (Student student : dataModel.getStudents()) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    // Utility method to find a course by ID
    private Course findCourseById(int courseId) {
        for (Course course : dataModel.getCourses()) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null;
    }
}