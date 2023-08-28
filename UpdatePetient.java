import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class UpdatePetient extends JFrame 
{
   private static final String Id = null;
   JButton Update,Cancel,Search;
   JTextField TextFieldFirstname,TextFieldLastname,TextFieldDieses,genderTextField;
   JRadioButton itemGender,item2Gender;
   String TFF;
   UpdatePetient()
    {
      
      setLayout(null);
      setTitle("Update Petient");
      setSize(700, 500);
      setLocation(150, 30);

      JLabel lblId=new JLabel("Id");
      lblId.setBounds(200, 50, 70, 30);
      this.add(lblId);

      JTextField TextFieldId=new JTextField();
      TextFieldId.setBounds(300, 50, 80, 30);
      this.add(TextFieldId);

      JButton Search = new JButton("Search");
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

      JLabel lblDieses = new JLabel("Dieses");
      lblDieses.setBounds(200, 250, 300, 30);
      this.add(lblDieses);

      TextFieldDieses = new JTextField();
      TextFieldDieses.setBounds(300, 250, 200, 30);
      this.add(TextFieldDieses);

      JLabel gender = new JLabel("Gender");
      gender.setBounds(200, 200, 200, 30);
      this.add(gender);

      genderTextField=new JTextField();
      genderTextField.setBounds(300,200,200,30);
      this.add(genderTextField);

     

      ButtonGroup on = new ButtonGroup();
      on.add(itemGender);
      on.add(item2Gender);

      JButton Cancel = new JButton("Cancel");
      Cancel.setBounds(230, 300, 100, 30);
      this.add(Cancel);

      JButton Update = new JButton("Update");
      Update.setBounds(380, 300, 100, 30);
      this.add(Update);

     // Update.addActionListener(this);
     // Cancel.addActionListener(this);

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
                   String query1 = "select * from petient where Id = ?";
                   PreparedStatement preparedStatement = connection.prepareStatement(query1);
                   preparedStatement.setString(1, TextFieldId.getText());
                   ResultSet resultSet = preparedStatement.executeQuery();
                   if (resultSet.next()) {
                        TextFieldFirstname.setText(resultSet.getString("Firstname"));
                        TextFieldLastname.setText(resultSet.getString("Lastname"));
                        genderTextField.setText(resultSet.getString("Gender"));
                        TextFieldDieses.setText(resultSet.getString("Dieses"));
                        
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
                        String query2 = "update petient set FirstName=?,LastName=?,Gender=?,Dieses=? where Id = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query2);
                        preparedStatement.setString(1, TextFieldFirstname.getText());
                        preparedStatement.setString(2, TextFieldLastname.getText());
                        preparedStatement.setString(3, genderTextField.getText());
                        preparedStatement.setString(4, TextFieldDieses.getText());
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
      UpdatePetient ob = new UpdatePetient();
   }
}


