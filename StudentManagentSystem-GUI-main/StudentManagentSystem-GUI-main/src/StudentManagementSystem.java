import javax.swing.*;
import java.awt.*;

public class StudentManagementSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Student Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            DataModel dataModel = new DataModel(); // Create data model instance

            // Add test data for courses
            dataModel.addCourse(new Course("Math 101", 101));
            dataModel.addCourse(new Course("English 101", 102));
            dataModel.addCourse(new Course("Science 101", 103));
            dataModel.addCourse(new Course("History 101", 104));

            // Create a tabbed pane and add panels
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Students", new StudentPanel(dataModel)); // Pass data model
            tabbedPane.addTab("Courses", new CoursePanel(dataModel)); // Pass data model
            tabbedPane.addTab("Grades", new GradePanel(dataModel)); // Pass data model
            tabbedPane.addTab("Display Data", new DisplayDataPanel(dataModel)); // New panel

            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}