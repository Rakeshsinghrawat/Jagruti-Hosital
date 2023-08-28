import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class JagrutiHospital   
{
    public static void main(String as[])
   
    {
        JFrame  frame = new JFrame("Hospital");
        GridLayout grid =new GridLayout(1,2);
        frame.setLayout(grid);
        frame.setSize(500, 500);
        
        frame.setTitle("Jagruti Hospital");

        JMenuBar menuBar = new JMenuBar();

        JMenu DoctorMenu=new JMenu("Doctor");
        JMenuItem AddDoctor=new JMenuItem("Add Doctor");
        JMenuItem DeletDoctor=new JMenuItem("Delet Doctor");
        JMenuItem UpdateDoctor=new JMenuItem("Updat Doctor");
        JMenuItem ViewDoctor=new JMenuItem("View Doctor");

        DoctorMenu.add(AddDoctor);
        DoctorMenu.add(DeletDoctor);
        DoctorMenu.add(UpdateDoctor);
        DoctorMenu.add(ViewDoctor);

        menuBar.add(DoctorMenu);
        frame.setJMenuBar(menuBar);

        JMenu PetientMenu=new JMenu("Petient");
        JMenuItem AddPetient=new JMenuItem("Add petient");
        JMenuItem DeletPetient=new JMenuItem("Delet petient");
        JMenuItem UpdatePetient=new JMenuItem("Updat petient");
        JMenuItem ViewPetient=new JMenuItem("View Petient");
        
        PetientMenu.add(AddPetient);
        PetientMenu.add(DeletPetient);
        PetientMenu.add(UpdatePetient);
        PetientMenu.add(ViewPetient);
       
        menuBar.add(PetientMenu);
        frame.setJMenuBar(menuBar);
      frame.setVisible(true);


        AddDoctor.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e)
           {
              new AddDoctor();
           }
        });
        DeletDoctor.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e2)
           {
              new DeletDoctor();
           }
        });
        UpdateDoctor.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e2)
           {
              new UpdateDoctor();
           }
        });

         ViewDoctor.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e2)
           {
              new ViewDoctor();
           }
        });  
        
         AddPetient.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e2)
           {
              new AddPetient();
           }
        });  

         DeletPetient.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e2)
           {
              new DeletPetient();
           }
        });  

         UpdatePetient.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e2)
           {
              new UpdatePetient();
           }
        });  

         ViewPetient.addActionListener ( new ActionListener() {
           public void actionPerformed (ActionEvent e2)
           {
              new ViewPetient();
           }
        });  

        
    }

}

    
 