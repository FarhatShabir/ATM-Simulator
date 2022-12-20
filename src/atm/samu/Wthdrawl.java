
package atm.samu;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Wthdrawl extends JFrame implements ActionListener{
     JTextField amt;
    JButton depositb,back,exit;
    JLabel msg,depositlab;
    String pin;
    
    Wthdrawl(String pin){
   
    this.pin=pin;
         setTitle("WITHDRAWAL ");
         
         msg=new JLabel("ENTER AMOUNT YOU WANT");
         depositlab=new JLabel("TO WITHDRAWAL");
         msg.setFont(new Font("Raleway",Font.BOLD,30));
         depositlab.setFont(new Font("Raleway",Font.BOLD,34));
         
         msg.setBounds(140, 170, 440, 40);
         depositlab.setBounds(250,240 , 300, 40);
         add(msg);
         add(depositlab);
         
         amt=new JTextField();
         amt.setBounds(200, 310, 300, 40);
         amt.setFont(new Font("Raleway",Font.BOLD,26));
         add(amt);
         
         depositb = new JButton("WITHDRAW");
         depositb.setBounds(120,370,190,50);
         depositb.setFont(new Font("Raleway",Font.BOLD,25));
         depositb.setForeground(Color.WHITE);
         depositb.setBackground(Color.BLACK);
         add(depositb);
         
         back = new JButton("BACK");
         back.setBounds(410,370,190,50);
         back.setFont(new Font("Raleway",Font.BOLD,25));
         back.setForeground(Color.WHITE);
         back.setBackground(Color.BLACK);
         add(back);
         
         exit = new JButton("EXIT");
         exit.setBounds(270,500,150,50);
         exit.setFont(new Font("Raleway",Font.BOLD,25));
         exit.setForeground(Color.WHITE);
         exit.setBackground(Color.RED);
         add(exit);
         
         depositb.addActionListener(this);
         back.addActionListener(this);
         exit.addActionListener(this);
         setLayout(null);
        setSize(700,700);
       setLocation(300,20);
      // setUndecorated(true);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
        
    }//Close Constructor
    
    public void actionPerformed(ActionEvent ae) {
        Date date=new Date();
        String amount=amt.getText();
        try{
        if(ae.getSource()==exit){
            JOptionPane.showMessageDialog(null,"Click Ok to Exit");
            System.exit(1);
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transcations(pin).setVisible(true);
        }else if(ae.getSource()==depositb){
            if(amt.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Valid Ammount");
            }
            else {
                   conn c1=new conn(); 
                   
                   ResultSet rs=c1.s.executeQuery("select * from bank where pin ='"+pin+"'");
                   
                   int balance =0;
                   while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance +=Integer.parseInt(rs.getString("amount"));
                       }
                       else{
                           balance-=Integer.parseInt(rs.getString("amount"));
                       }
                   }
                   
                   if(balance<Integer.parseInt(amount)){
                       JOptionPane.showMessageDialog(null, "Insuffient Balance");
                       return;
                   }
                   c1.s.executeUpdate("insert into bank values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"RS :: "+amount+" Withdrawl Successfully");
                    setVisible(false);
                    new Transcations(pin).setVisible(true);
                    
                }
            
        }
        }catch(Exception ee){
            ee.setStackTrace(ee.getStackTrace());
        }
      
    }
    
    public static void main(String[] args){
        new Wthdrawl("").setVisible(true);
    }
}
