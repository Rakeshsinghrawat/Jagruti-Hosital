import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class DeletPetient extends JFrame implements ActionListener
{
   JLabel lblId,lblFirstname;
   JTextField TextFieldFirstname,textFieldId;
   JButton Cancel,Delet;
   DeletPetient()
   {
      setLayout(null);
      setTitle("Delet Petient");
      setSize(700, 500);
      setLocation(150, 30);
      
      lblId=new JLabel("Id");
      lblId.setBounds(180, 130, 100, 30);
      this.add(lblId);

      textFieldId=new JTextField();
      textFieldId.setBounds(250, 130, 250, 50);
      this.add(textFieldId);

      /*lblFirstname=new JLabel("FirstName");
      lblFirstname.setBounds(180,180,100,30);
      this.add(lblFirstname);

      TextFieldFirstname=new JTextField();
      TextFieldFirstname.setBounds(250, 180, 300, 30);
      this.add(TextFieldFirstname);*/

      Cancel=new JButton("Cancel");
      Cancel.setBounds(260, 200, 100, 30);
      this.add(Cancel);

      Delet=new JButton("Delet");
      Delet.setBounds(390, 200, 100, 30);
      this.add(Delet);

      setVisible(true);
     Cancel.addActionListener(this);
     Delet.addActionListener(this);
   }
    @Override
   public void actionPerformed(ActionEvent e) 
   {
      if(e.getSource()==Delet)
      {
        String DB_URL = "jdbc:mysql://localhost:3306/JagrutiHospital";
              String USER = "root";
              String PASS = "";
               try {
                  
                  Class.forName("com.mysql.jdbc.Driver"); 
                  Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                  Statement stmt = conn.createStatement();
                  String sql = "Delete from petient WHERE Id = "+textFieldId.getText();
                  stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data Delet SuccessFully!");
                  } 
             catch (Exception ee)
             {
                  ee.printStackTrace();
                  JOptionPane.showMessageDialog(rootPane, ee);
             }  
      }
        //JOptionPane.showMessageDialog(null, "Data Delet SuccessFully!");
      
       else if(e.getSource()==Cancel)
      {
        System.exit(0);
      }
      }
       
   public static void main(String asd[])
   {
       DeletPetient ob2=new DeletPetient();
   }
}