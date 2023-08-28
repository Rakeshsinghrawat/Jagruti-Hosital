import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class AddPetient extends JFrame implements ActionListener 
{
   JButton Save,Cancel;
   JTextField TextFieldFirstname,TextFieldLastname,TextFieldDieses;
   JRadioButton Male,Female;
   String TFF;
   AddPetient()
    {
      
      setLayout(null);
     
      setTitle("Add Petient");
      setSize(700, 500);
      setLocation(150, 30);

      JLabel lblFirstname = new JLabel("FirstName");
      lblFirstname.setBounds(200, 50, 100, 30);
      this.add(lblFirstname);

      TextFieldFirstname = new JTextField();
      TextFieldFirstname.setBounds(300, 50, 200, 30);
      this.add(TextFieldFirstname);

      JLabel lblLastname = new JLabel("LastName");
      lblLastname.setBounds(200, 100, 200, 30);
      this.add(lblLastname);

      TextFieldLastname = new JTextField();
      TextFieldLastname.setBounds(300, 100, 200, 30);
      this.add(TextFieldLastname);

      JLabel lblDieses = new JLabel("Dieses");
      lblDieses.setBounds(200, 200, 300, 30);
      this.add(lblDieses);

      TextFieldDieses = new JTextField();
      TextFieldDieses.setBounds(300, 200, 200, 30);
      this.add(TextFieldDieses);

      JLabel gender = new JLabel("Gender");
      gender.setBounds(200, 150, 200, 30);
      this.add(gender);

       Male = new JRadioButton("Male");
      Male.setBounds(300, 150, 100, 30);
      this.add(Male);

       Female = new JRadioButton("Female");
      Female.setBounds(400, 150, 400, 30);
      this.add(Female);

      ButtonGroup on = new ButtonGroup();
      on.add(Male);
      on.add(Female);

       Cancel = new JButton("Cancel");
      Cancel.setBounds(230, 250, 100, 30);
      this.add(Cancel);

       Save = new JButton("Save");
      Save.setBounds(380, 250, 100, 30);
      this.add(Save);

      Save.addActionListener(this);
      Cancel.addActionListener(this);

      setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) 
   {
      
      if (e.getSource()==Save) 
      {
         String DB_URL = "jdbc:mysql://localhost:3306/JagrutiHospital";
         String USER = "root";
         String PASS = "";
          String Gender = "";
           if(Male.isSelected()){
              Gender = "Male";
           }else if(Female.isSelected()){
              Gender = "Female";
           }
          try {
           
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "insert into petient( FirstName,LastName,Gender,Dieses) values( '" + TextFieldFirstname.getText() + "','"+TextFieldLastname.getText()+"','"+Gender+"','"+TextFieldDieses.getText()+"')";
            stmt.executeUpdate(sql);
            //System.out.println(Gender);
            JOptionPane.showMessageDialog(null, "Data Insert SuccessFully!");
         } 
         catch (Exception e1) 
         {
            e1.printStackTrace();
         }


      }
     
      else if(e.getSource() == Cancel)
      {
         JOptionPane.showMessageDialog(null, "Data Insert SuccessFully!");
         System.exit(0);
      }
   }

   
  

   public static void main(String[] args) 
   {
      AddPetient ob1 = new AddPetient();
   }
}
