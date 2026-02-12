package ui;

import model.Student;
import service.StudentService;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MainFrame extends BaseFrame {

    private JTextField idField, nameField, courseField;
    private JTextArea displayArea;
    private StudentService service = new StudentService();

    public MainFrame() {
        super("Student Management System");

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(240, 244, 248));
        mainPanel.setLayout(new BorderLayout(10,10));
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        // Title
        JLabel title = new JLabel("Student Management System", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(0, 77, 128));
        mainPanel.add(title, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4,2,10,10));
        formPanel.setBorder(new TitledBorder("Enter Student Details"));
        formPanel.setBackground(Color.WHITE);

        idField = new JTextField();
        nameField = new JTextField();
        courseField = new JTextField();

        formPanel.add(new JLabel("Student ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);

        JButton addBtn = new JButton("Add Student");
        addBtn.setBackground(new Color(0, 123, 181));
        addBtn.setForeground(Color.WHITE);
        addBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        formPanel.add(new JLabel(""));
        formPanel.add(addBtn);

        // Output Panel
        displayArea = new JTextArea();
        displayArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        displayArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(displayArea);
        scroll.setBorder(new TitledBorder("Student Records"));

        // Add to main
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(scroll, BorderLayout.SOUTH);

        add(mainPanel);

        addBtn.addActionListener(e -> addStudent());
    }

    private void addStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String course = courseField.getText();

            Student s = new Student(id, name, course);
            service.addStudent(s);

            displayArea.setText("");
            for (Student st : service.getAllStudents()) {
                displayArea.append("• " + st + "\n");
            }

            idField.setText("");
            nameField.setText("");
            courseField.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid data",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
