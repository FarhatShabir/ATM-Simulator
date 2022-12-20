
package atm.samu;

/**
 *
 * @author Farhat Shabir
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JTextField t1;
    
    String formno;
    
    Signup3(String formno){
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        l1=new JLabel("Page 3 - Accout Detail ");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        
        l2=new JLabel("Account Type :");
        l2.setFont(new Font("Raleway",Font.BOLD,18));
        
        l3= new JLabel("Card Number :");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        
        l4=new JLabel("XXXX-XXXX-XXXX-X418");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        
        l5 = new JLabel("(Your 16-Digit Card Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,11));
        
        l6=new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway",Font.BOLD,11));
        
        l7=new JLabel("PIN :");
        l7.setFont(new Font("Raleway",Font.BOLD,18));
        
        l8=new JLabel("XXXX");
        l8.setFont(new Font("Raleway",Font.BOLD,19));
        
        l9=new JLabel("4-Digit Password");
        l9.setFont(new Font("Raleway",Font.BOLD,12));
        
        l10=new JLabel("Services Required :");
        l10.setFont(new Font("Raleway",Font.BOLD,18));
        
        l11=new JLabel(formno);
        l11.setFont(new Font("Raleway",Font.BOLD,14));
        
        b1=new JButton("Submit");
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.WHITE);
        
        b2=new JButton("Cancel");
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        
        c4=new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        
        c7=new JCheckBox("I hereby declares that the above entered detail is correct to the best of my knowladge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        
        r1=new JRadioButton("Saving Account");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        
        r3=new JRadioButton("Current Account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        
        ButtonGroup all=new ButtonGroup();
        all.add(r1);
        all.add(r2);
        all.add(r3);
        all.add(r4);
        
        setLayout(null);
        setSize(700,700);
       setLocation(300,20);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       
       l1.setBounds(230, 20, 500, 30);
       add(l1);
       
       l2.setBounds(100,100,150,30);
       add(l2);
       
       r1.setBounds(100,150,150,30);
       add(r1);
       r2.setBounds(300,150,250,30);
       add(r2);
       r3.setBounds(100,200,200,30);
       add(r3);
       r4.setBounds(300,200,250,30);
       add(r4);
       
       l3.setBounds(100,250,150,30);
       add(l3);
       l4.setBounds(300, 250, 250, 30);
       add(l4);
       
       l5.setBounds(100,270,200,30);
       add(l5);
       
       l6.setBounds(300, 270, 300, 30);
       add(l6);
       
       l7.setBounds(100, 330, 100, 30);
       add(l7);
       
       l8.setBounds(300,330,100,30);
       add(l8);
       
       l9.setBounds(100,350,100,30);
       add(l9);
       
       l10.setBounds(100,400,300,30);
       add(l10);
       
       l11.setBounds(600,20,300,30);
       add(l11);
       
       c1.setBounds(120,450,150,40);
       add(c1);
       c2.setBounds(300, 450, 250, 40);
       add(c2);
       
       c3.setBounds(120,500,150,40);
       add(c3);
       c4.setBounds(300, 500, 150, 40);
       add(c4);
       
       c5.setBounds(120, 550, 150, 30);
       add(c5);
       c6.setBounds(300,550,150,30);
       add(c6);
       
       c7.setBounds(70, 580, 700, 20);
       add(c7);
       
       b1.setBounds(550,610,100,40);
       add(b1);
       b1.addActionListener(this);
    }//Cons
    
    
 
    public static void main(String[] args){
   new Signup3("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    String acctype=null;
    if(r1.isSelected()){
        acctype="Saving Account";
    }
    else if(r2.isSelected()){
        acctype="Fixed Deposit Account";
    }else if(r3.isSelected()){
        acctype="Current Account";
    }else if(r4.isSelected()){
        acctype="Recurring Deposit Account";
    }
    
    Random ran =new Random();
    long first7=(ran.nextLong()%90000000L)+5040936000000000L;
    String cardno=""+Math.abs(first7);
    
    long first3=(ran.nextLong()%9000L)+1000L;
    String pin=""+Math.abs(first3);
    
    String services="";
    if(c1.isSelected()){
        services=services+"ATM Card";
    }
    if(c2.isSelected()){
        services=services+"Internet Banking";
    }
    if(c3.isSelected()){
        services=services+"Mobile Banking";
    }
    if(c4.isSelected()){
        services=services+"Email Alerts";
    }
    if(c5.isSelected()){
        services=services+"Cheque Book"; 
    }
    if(c6.isSelected()){
        services = services +"E-Statement";
    }
    
      try{
          if(ae.getSource()==b2){
               if(services.equals("")){
                   JOptionPane.showMessageDialog(null, "Fill All The Required Fields");
               }
          }else{
              conn c1=new conn();
              String q1="insert into signup3 values('"+formno+"','"+acctype+"','"+cardno+"','"+pin+"','"+services+"')";
              String q2="insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
              c1.s.executeUpdate(q1);
              c1.s.executeUpdate(q2);
              
              JOptionPane.showMessageDialog(null,"Card Number :: "+cardno+"\n Pin : "+pin+" \n Thank you for Choosing Us");
              
             new Deposit(pin).setVisible(true);
              setVisible(false);
          }
      }catch(Exception e){
         e.printStackTrace();
      }
    
    }// close action performed
}
