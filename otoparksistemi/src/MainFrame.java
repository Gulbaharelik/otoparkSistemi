import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainFrame extends JFrame implements ActionListener {
    private JButton addBtn, viewBtn;
    private JTextField licenseField, brandField, ownerField;

    public MainFrame() {
        setTitle("Parking Management System");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("License Plate"));
        licenseField = new JTextField(10);
        add(licenseField);

        add(new JLabel("Brand"));
        brandField = new JTextField(15);
        add(brandField);

        add(new JLabel("Owner ID"));
        ownerField = new JTextField(10);
        add(ownerField);

        add(addBtn = new JButton("Add Vehicle"));
        addBtn.addActionListener(this);
        addBtn.setActionCommand("ADD");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD")) {
            try {
                addVehicle();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
                JOptionPane.showMessageDialog(this, "Failed to add vehicle.");
            }
        }
    }

    private void addVehicle() throws SQLException {
        String license = licenseField.getText();
        String brand = brandField.getText();
        int owner_id = Integer.parseInt(ownerField.getText());

        try (Connection connection = DatabaseConnection.getInstance()) {
            PreparedStatement addStatement = connection.prepareStatement(
                    "INSERT INTO vehicles (license_plate, brand, owner_id) VALUES (?, ?, ?)"
            );

            addStatement.setString(1, license);
            addStatement.setString(2, brand);
            addStatement.setInt(3, owner_id);

            int rowsAffected = addStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Vehicle Added Successfully!");
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        new MainFrame();
    }
}
