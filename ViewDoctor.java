import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class ViewDoctor extends JFrame {
    JButton Cancel, View;
    JFrame frame = new JFrame("View Doctor");

    ViewDoctor() {

        View = new JButton("View");
        View.setBounds(20, 20, 100, 30);

        String url = "jdbc:mysql://localhost:3306/JagrutiHospital";
        String username = "root";
        String password = "";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String query1 = "select * from doctor";
            // java.sql.Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query1);
            ResultSet resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModal = new DefaultTableModel();
            tableModal.addColumn("Id");
            tableModal.addColumn("FirstName");
            tableModal.addColumn("LastName");
            tableModal.addColumn("Gender");
            tableModal.addColumn("Specialist");
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Gender = resultSet.getString("Gender");
                String Secialist = resultSet.getString("Specialist");

                tableModal.addRow(new Object[] { Id, FirstName, LastName, Gender, Secialist });
            }
            JTable sideTable = new JTable(tableModal);
            JScrollPane scrollPane = new JScrollPane(sideTable);
            // Assuming 'fram' in your Frame
            frame.getContentPane().removeAll();
            // Remove Previos Content
            frame.getContentPane().add(scrollPane);
            frame.revalidate();
            // Refrash JFrame
            resultSet.close();
            preparedStatement.close();
            connection.close();
            frame.setVisible(true);
            frame.setSize(600, 400);
            System.out.println("Successfully view");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        ViewDoctor ob = new ViewDoctor();
    }

}
