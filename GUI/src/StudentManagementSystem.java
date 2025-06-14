import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String id;
    private String name;
    private String grade;
    
    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public String getGrade() { return grade; }
}

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private Color primaryColor = new Color(70, 130, 180); // Steel blue
    private Color secondaryColor = new Color(245, 245, 245); // Light gray
    private Color accentColor = new Color(100, 149, 237); // Cornflower blue

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem().initialize());
    }

    @SuppressWarnings("serial")
	private void initialize() {
        // Main Frame with modern styling
        frame = new JFrame("🎓 Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 550); // Increased size for better visibility
        frame.setLocationRelativeTo(null);
        
        // Main panel with border and padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(secondaryColor);
        frame.add(mainPanel);

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(primaryColor);
        headerPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        
        JLabel titleLabel = new JLabel("STUDENT MANAGEMENT SYSTEM");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Content Panel (holds form and table)
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBackground(secondaryColor);
        
        // Form Panel with modern styling
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15));
        formPanel.setBorder(new CompoundBorder(
            new TitledBorder("Student Information"),
            new EmptyBorder(10, 10, 10, 10)
        ));
        formPanel.setBackground(secondaryColor);
        
        // Form Components
        JTextField idField = createStyledTextField();
        JTextField nameField = createStyledTextField();
        JTextField gradeField = createStyledTextField();
        
        formPanel.add(createFormLabel("Student ID:"));
        formPanel.add(idField);
        formPanel.add(createFormLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(createFormLabel("Grade:"));
        formPanel.add(gradeField);

        // Table with modern styling
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table non-editable
            }
        };
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Grade");
        
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        
        // Table header styling
        JTableHeader header = table.getTableHeader();
        header.setBackground(primaryColor);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new CompoundBorder(
            new EmptyBorder(5, 0, 5, 0),
            new LineBorder(new Color(200, 200, 200))
        ));

        // Add form and table to content panel
        contentPanel.add(formPanel, BorderLayout.WEST);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Button Panel with modern buttons - now properly sized
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 0));
        buttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        buttonPanel.setBackground(secondaryColor);
        
        JButton addButton = createStyledButton("Add Student", accentColor);
        JButton deleteButton = createStyledButton("Delete Selected", new Color(220, 80, 80));
        JButton clearButton = createStyledButton("Clear Fields", new Color(150, 150, 150));
        
        // Make buttons fill available space
        addButton.setPreferredSize(new Dimension(0, 50)); // Height fixed, width flexible
        deleteButton.setPreferredSize(new Dimension(0, 50));
        clearButton.setPreferredSize(new Dimension(0, 50));
        
        // Button Actions
        addButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String grade = gradeField.getText().trim().toUpperCase();
            
            if (!id.isEmpty() && !name.isEmpty() && !grade.isEmpty()) {
                students.add(new Student(id, name, grade));
                updateTable();
                clearFields(idField, nameField, gradeField);
                showMessage("Student added successfully!");
            } else {
                showError("All fields are required!");
            }
        });
        
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                students.remove(selectedRow);
                updateTable();
                showMessage("Student deleted successfully!");
            } else {
                showError("Please select a student to delete!");
            }
        });

        clearButton.addActionListener(e -> clearFields(idField, nameField, gradeField));

        // Add buttons to button panel
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        
        // Add button panel to main panel
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Helper methods for styling
    private JLabel createFormLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(new Color(70, 70, 70));
        return label;
    }
    
    private JTextField createStyledTextField() {
        JTextField field = new JTextField(15);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(new CompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1),
            new EmptyBorder(8, 10, 8, 10)
        ));
        return field;
    }
    
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new CompoundBorder(
            new LineBorder(bgColor.darker(), 1),
            new EmptyBorder(8, 20, 8, 20)
        ));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    // Business Logic Methods
    private void updateTable() {
        model.setRowCount(0);
        students.forEach(s -> model.addRow(new Object[]{s.getId(), s.getName(), s.getGrade()}));
    }
    
    private void clearFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, 
            "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}