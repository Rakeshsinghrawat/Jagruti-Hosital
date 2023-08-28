import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import java.util.Scanner;
class UpdateDoctor extends JFrame //implements ActionListener
{
  // private static final String Id = null;
   JButton Update,Cancel,Search;
   JTextField TextFieldFirstname,TextFieldLastname,genderTextField,TextFieldSpecialist, TextFieldId;
   JRadioButton Male,Female;
   String TFF;
   UpdateDoctor()
    {
      
      setLayout(null);
      setTitle("Update Doctor");
      setSize(700, 500);
      setLocation(150, 30);

      JLabel lblId=new JLabel("Id");
      lblId.setBounds(200, 50, 70, 30);
      this.add(lblId);

       TextFieldId=new JTextField();
      TextFieldId.setBounds(300, 50, 80, 30);
      this.add(TextFieldId);

       Search = new JButton("Search");
      Search.setBounds(400, 50, 100, 30);
      this.add(Search);

      JLabel lblFirstname = new JLabel("FirstName");
      lblFirstname.setBounds(200, 100, 100, 30);
      this.add(lblFirstname);

      TextFieldFirstname = new JTextField();
      TextFieldFirstname.setBounds(300, 100, 200, 30);
      this.add(TextFieldFirstname);

      JLabel lblLastname = new JLabel("LastName");
      lblLastname.setBounds(200, 150, 200, 30);
      this.add(lblLastname);

      TextFieldLastname = new JTextField();
      TextFieldLastname.setBounds(300, 150, 200, 30);
      this.add(TextFieldLastname);

      JLabel lblSpecialist = new JLabel("Specialist");
      lblSpecialist.setBounds(200, 250, 300, 30);
      this.add(lblSpecialist);

      TextFieldSpecialist = new JTextField();
      TextFieldSpecialist.setBounds(300, 250, 200, 30);
      this.add(TextFieldSpecialist);

      JLabel gender = new JLabel("Gender");
      gender.setBounds(200, 200, 200, 30);
      this.add(gender);

     genderTextField = new JTextField();
      genderTextField.setBounds(300, 200, 200, 30);
      this.add(genderTextField);

      JButton Cancel = new JButton("Cancel");
      Cancel.setBounds(230, 300, 100, 30);
      this.add(Cancel);

      JButton Update = new JButton("Update");
      Update.setBounds(380, 300, 100, 30);
      this.add(Update);

      //Update.addActionListener(this);
      //Cancel.addActionListener(this);

      setVisible(true);
   


   
      
      // Query for Search Id
           Search.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {

                    String url = "jdbc:mysql://localhost:3306/JagrutiHospital";
                    String username = "root";
                    String password = "";
                    //String Gender = "";
                    //if(Male.isSelected()){
                    //   Gender = "Male";
                    //}else if(Female.isSelected()){
                     //  Gender = "Female";
                   // }
                    try {
                         Connection connection = DriverManager.getConnection(url, username, password);
                         // java.sql.Statement statement = connection.createStatement();
                         String query1 = "select * from doctor where Id = ?";
                         PreparedStatement preparedStatement = connection.prepareStatement(query1);
                         preparedStatement.setString(1, TextFieldId.getText());
                         ResultSet resultSet = preparedStatement.executeQuery();
                         if (resultSet.next()) {
                              TextFieldFirstname.setText(resultSet.getString("Firstname"));
                              TextFieldLastname.setText(resultSet.getString("Lastname"));
                              genderTextField.setText(resultSet.getString("Gender"));
                              TextFieldSpecialist.setText(resultSet.getString("Specialist"));
                              
                         } else {
                              JOptionPane.showMessageDialog(rootPane, "Data not found");
                         }          resultSet.close();
                         preparedStatement.close();
                         connection.close();
                         System.out.println("Search sdfghjm");
                    } catch (SQLException ex) {
                         ex.printStackTrace();
                         JOptionPane.showMessageDialog(rootPane, "Error : Unable to Search");
                    }
               }
          
          });
          
     Update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                       String url = "jdbc:mysql://localhost:3306/JagrutiHospital";
                       String username = "root";
                       String password = "";
                       try {
                              Connection connection = DriverManager.getConnection(url, username, password);
                              // java.sql.Statement statement = connection.createStatement();
                              String query2 = "update doctor set FirstName=?,LastName=?,Gender=?,Specialist=? where Id = ?";
                              PreparedStatement preparedStatement = connection.prepareStatement(query2);
                              preparedStatement.setString(1, TextFieldFirstname.getText());
                              preparedStatement.setString(2, TextFieldLastname.getText());
                              preparedStatement.setString(3, genderTextField.getText());
                              preparedStatement.setString(4, TextFieldSpecialist.getText());
                              preparedStatement.setString(5, TextFieldId.getText());
                              int updateData = preparedStatement.executeUpdate();
                              if (updateData > 0) {
                                     JOptionPane.showMessageDialog(rootPane, "Date Updated SuccessFully!");
                              } else {
                                     JOptionPane.showMessageDialog(rootPane, "Data Not Updated!");
                              }
                    
                              preparedStatement.close();
                              connection.close();
                       } catch (SQLException ex) {
                              ex.printStackTrace();
                              JOptionPane.showMessageDialog(rootPane, "Error : Unable to Update Data");
                       }
                }
         });
     }

  

   public static void main(String[] args) 
   {
      UpdateDoctor ob = new UpdateDoctor();
   }
}











