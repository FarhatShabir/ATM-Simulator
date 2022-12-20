
package atm.samu;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
/**
 *
 * @author Farhat Shabir
 */
public class Signup2 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JLabel l13;
    JButton b;
    JRadioButton r1,r2,r3,r4;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3,c4,c5;
    String formno;
    
    Signup2(String formno){
       this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        l1=new JLabel("Page 2 - Additional Detail");
        l1.setFont(new Font("Ralway",Font.BOLD,22));
        
        l2=new JLabel("Religion :");
        l2.setFont(new Font("Ralway",Font.BOLD,18));
        
        l3=new JLabel("Category :");
        l3.setFont(new Font("Ralway",Font.BOLD,18));
        
        l4=new JLabel("Income :");
        l4.setFont(new Font("Ralway",Font.BOLD,18));
        
        l5=new JLabel("Educational");
        l11=new JLabel("Qualification :");
        l5.setFont(new Font("Ralway",Font.BOLD,18));
        l11.setFont(new Font("Ralway",Font.BOLD,18));
        
        l6=new JLabel("Occupation");
        l6.setFont(new Font("Ralway",Font.BOLD,18));
        
        l7=new JLabel("PAN Number :");
        l7.setFont(new Font("Ralway",Font.BOLD,18));
        
        l8=new JLabel("Aadhar Number :");
        l8.setFont(new Font("Ralway",Font.BOLD,18));
        
        l9=new JLabel("Senior Citizen");
        l9.setFont(new Font("Ralway",Font.BOLD,18));
        
        l10=new JLabel("Existing Account");
        l10.setFont(new Font("Ralway",Font.BOLD,18));
        
        l12=new JLabel("Form Number ::");
        l12.setFont(new Font("Ralway",Font.BOLD,14));
        l12.setForeground(Color.RED);
        
        l13=new JLabel(formno);
        l13.setFont(new Font("Ralway",Font.BOLD,14));
        l13.setForeground(Color.RED);
        
        b=new JButton("Next");
       b.setFont(new Font("Ralway",Font.BOLD,14));
       b.setBackground(Color.GREEN);
       b.setForeground(Color.WHITE);
       
       t1=new JTextField();
       t1.setFont(new Font("Ralway",Font.BOLD,16));
       
       
       t2=new JTextField();
       t2.setFont(new Font("Ralway",Font.BOLD,16));
       
       
       t3=new JTextField();
       t3.setFont(new Font("Ralway",Font.BOLD,16));
       t3.setText(formno);
       
       r1=new JRadioButton("Yes");
       r1.setFont(new Font("Ralway",Font.BOLD,14));
       r1.setBackground(Color.WHITE);
       
       r2=new JRadioButton("No");
       r2.setFont(new Font("Ralway",Font.BOLD,14));
       r2.setBackground(Color.WHITE);
       
       r3=new JRadioButton("Yes");
       r3.setFont(new Font("Ralway",Font.BOLD,14));
       r3.setBackground(Color.WHITE);
       
       r4=new JRadioButton("No");
       r4.setFont(new Font("Ralway",Font.BOLD,14));
       r4.setBackground(Color.WHITE);
        
       String religion[]={"Hindu","Muslim","Sikh","Christian","Other"};
       c1=new JComboBox(religion);
       c1.setFont(new Font("Ralway",Font.BOLD,14));
       c1.setBackground(Color.WHITE);
       
       String category[]={"General","OBC","SC","ST","Other"};
       c2=new JComboBox(category);
       c2.setFont(new Font("Ralway",Font.BOLD,14));
       c2.setBackground(Color.WHITE);
       
       String income[]={"Null","< 1 Lakh","< 2.5 Lakh","< 5 Lakh","Upto 10 Lakh","Above 10 Lakh"};
       c3=new JComboBox(income);
       c3.setFont(new Font("Ralway",Font.BOLD,14));
       c3.setBackground(Color.WHITE);
       
       String education[]={"Non-Gradute","Gradute","Post-Gradute","Doctrate","Other"};
       c4=new JComboBox(education);
       c4.setFont(new Font("Ralway",Font.BOLD,14));
       c4.setBackground(Color.WHITE);
       
       String occupation[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
       c5=new JComboBox(occupation);
       c5.setFont(new Font("Ralway",Font.BOLD,14));
       c5.setBackground(Color.WHITE);
       
       setLayout(null);
       
       setSize(700,700);
       setLocation(300,20);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       
       l1.setBounds(200, 50, 500, 30);
       add(l1);
       
       l12.setBounds(500, 10, 130, 25);//form no
       add(l12);
       
       t3.setBounds(620, 10, 60, 25); //formno
       add(t3);
       
       l2.setBounds(100,100,100,30);
       add(l2);
       
       c1.setBounds(250,100,400,30);
       add(c1);    
       
       l3.setBounds(100,150,100,30);
       add(l3);
       c2.setBounds(250, 150, 400, 30);
       add(c2);
       
       l4.setBounds(100, 200, 100, 30);
       add(l4);
       c3.setBounds(250,200,400,30);
       add(c3);
       
       l5.setBounds(100,250,190,30);
       add(l5);
       l11.setBounds(100,270,190,30);
       add(l11);
       c4.setBounds(250, 260, 400, 30);
       add(c4);
       
       l6.setBounds(100, 320, 100, 30);
       add(l6);
       c5.setBounds(250,320,400,30);
       add(c5);
       
       l7.setBounds(100, 360, 150, 30);
       add(l7);
       t1.setBounds(250, 360, 400, 30);
       add(t1);
       
       l8.setBounds(100,410,150,30);
       add(l8);
       t2.setBounds(250, 410, 400, 30);
       add(t2);
       
       l9.setBounds(100,460,150,30);
       add(l9);
       r1.setBounds(250,460,100,30);
       add(r1);
       r2.setBounds(350,460, 100, 30);
       add(r2);
       ButtonGroup sno=new ButtonGroup();
       sno.add(r1);
       sno.add(r2);
       
       l10.setBounds(100, 510, 150, 30);
       add(l10);
       r3.setBounds(250, 510, 100, 30);
       add(r3);
       r4.setBounds(350, 510, 100, 30);
       add(r4);
       
       ButtonGroup exi=new ButtonGroup();
       exi.add(r3);
       exi.add(r4);
       
       
       b.setBounds(550, 590, 100, 40);
       add(b);
       b.addActionListener(this);
       
       
    }// Close Sign up 2 Constructor
    
    public static void main(String[] args){
        new Signup2("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion=(String)c1.getSelectedItem();
        String category=(String)c2.getSelectedItem();
        String income=(String)c3.getSelectedItem();
        String eduqul=(String)c4.getSelectedItem();
        String occup=(String)c5.getSelectedItem();
        
        String pan=t1.getText();
        String aadhar=t2.getText();
        
        String senior="";
         if(r1.isSelected()){
             senior="Yes";
         }
         else{
             senior="No";
         }
         
         String exisacc="";
         if(r3.isSelected()){
             exisacc="Yes";
         }
         else{
             exisacc="No";
         }
        
         try{
             
             if(t2.getText().equals("")){
                 JOptionPane.showMessageDialog(null, "Fill all the Required Fields");
             }else{
                 conn c1=new conn();
                 String q1="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+eduqul+"','"+occup+"','"+pan+"','"+aadhar+"','"+senior+"','"+exisacc+"')";
                 c1.s.executeUpdate(q1);
                 
                 JOptionPane.showMessageDialog(null, "Update Done Click Ok");
                 new Signup3(formno).setVisible(true);
                 setVisible(false);
             }
         }catch(Exception e){
             
         }
    }
}
