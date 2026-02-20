import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {
    private final DataModel dataModel;
    private final JList<Course> courseList;
    private final DefaultListModel<Course> listModel;

    public CoursePanel(DataModel dataModel) {
        this.dataModel = dataModel;
        setLayout(new BorderLayout());

        // Create list model and JList
        listModel = new DefaultListModel<>();
        courseList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(courseList);

        // Add components to the panel
        add(scrollPane, BorderLayout.CENTER);

        // Form for adding courses
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JButton addButton = new JButton("Add Course");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel(""));
        formPanel.add(addButton);

        add(formPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int id = Integer.parseInt(idField.getText());
                Course course = new Course(name, id);
                dataModel.addCourse(course);
                listModel.addElement(course); // Update the list
            }
        });
    }
}