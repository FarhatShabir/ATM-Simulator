
package atm.samu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    
    Login(){
        setTitle("Automated Teller Machine");
        
        l1=new JLabel("WELCOME TO ATM");
        l1.setFont(new  Font("Osward",Font.BOLD,42));
        
        l2=new JLabel("CARD NO.");
        l2.setFont(new Font("Times New Roman",Font.BOLD,28));
        
        l3=new JLabel("PIN");
        l3.setFont(new Font("Raleway",Font.BOLD,28));
        
        tf1=new JTextField(15);
        pf2=new JPasswordField(15);
        
        b1=new JButton("SIGN IN");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.white);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        
        b3=new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        
        
        setLayout(null);
        l1.setBounds(175,50,450,200);
        add(l1);
        
        l2.setBounds(125,150,375,200);
        add(l2);
        
        l3.setBounds(125,225,375,200);
        add(l3);
        
        tf1.setFont(new Font("Arial",Font.BOLD,14));
        tf1.setBounds(300, 235, 230, 30);
        add(tf1);
        
        pf2.setFont(new Font("Arial",Font.BOLD,14));
        pf2.setBounds(300,310,230,30);
        add(pf2);
        
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setBounds(300, 400, 100, 30);
        add(b1);
        
        b2.setFont(new Font("Arial",Font.BOLD,14));
        b2.setBounds(430, 400, 100, 30);
        add(b2);
        
        b3.setFont(new Font("Arial",Font.BOLD,14));
        b3.setBounds(300, 450, 230, 30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,600);
        setLocation(250,100);
        setVisible(true);
    }//close login Constructor
  
    public void actionPerformed(ActionEvent ae){
        try{
            
             if(ae.getSource()==b1){
            conn c1 = new conn();
            String cardno=tf1.getText();
            String pin=pf2.getText();
            String q="Select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
            ResultSet rs=c1.s.executeQuery(q);
                if(rs.next()){
                     new Transcations(pin).setVisible(true);
                     setVisible(false);
                 }else{
                     JOptionPane.showMessageDialog(null,"InCorrect Card Number Or Password");
                 }
             }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
             }else if(ae.getSource()==b3){
                 new  Signup().setVisible(true);
                 setVisible(false);
             }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error"+e);
        }
        
    }
    public static void main(String[] args){
       new Login().setVisible(true);
 // System.out.println("This is the test");
    }
    
}

