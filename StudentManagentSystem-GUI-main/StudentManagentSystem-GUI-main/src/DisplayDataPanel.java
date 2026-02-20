import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DisplayDataPanel extends JPanel {
    private final DataModel dataModel;
    private final JTextArea displayArea;

    public DisplayDataPanel(DataModel dataModel) {
        this.dataModel = dataModel;
        setLayout(new BorderLayout());

        // Create display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add components to the panel
        add(scrollPane, BorderLayout.CENTER);

        // Button to display data
        JButton displayButton = new JButton("Display Data");
        add(displayButton, BorderLayout.SOUTH);

        // Button action
        displayButton.addActionListener(e -> displayData());
    }

    // Method to display student-course-grade relationships
    private void displayData() {
        StringBuilder sb = new StringBuilder();
        Map<Student, Map<Course, Grade>> studentCourseGrades = dataModel.getStudentCourseGrades();

        for (Map.Entry<Student, Map<Course, Grade>> entry : studentCourseGrades.entrySet()) {
            Student student = entry.getKey();
            sb.append("Student: ").append(student.getName()).append(" (ID: ").append(student.getId()).append(")\n");

            Map<Course, Grade> courseGrades = entry.getValue();
            for (Map.Entry<Course, Grade> courseEntry : courseGrades.entrySet()) {
                Course course = courseEntry.getKey();
                Grade grade = courseEntry.getValue();
                sb.append("  Course: ").append(course.getName()).append(" (ID: ").append(course.getId()).append("), Grade: ").append(grade.getGrade()).append("\n");
            }
            sb.append("\n");
        }

        displayArea.setText(sb.toString());
    }
}