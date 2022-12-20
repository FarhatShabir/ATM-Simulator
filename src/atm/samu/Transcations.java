
package atm.samu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transcations extends JFrame implements ActionListener{
    JLabel trans;
    JButton deposit,cashwithdraw,fastcash,ministatement,pinchange,balanceenq,exit;
    String pin;
    Transcations(String pin){
     this.pin=pin;
     setTitle("Transaction");
     
     trans=new JLabel("Please Select Your Transaction");
     trans.setFont(new Font("Times New Roman",Font.BOLD,35));
     trans.setBounds(110, 100, 500, 30);
     add(trans);
     
     deposit=new JButton("DEPOSIT");
     deposit.setBounds(80, 200, 230, 60);
     deposit.setFont(new Font("Raleway",Font.BOLD,18));
     deposit.setForeground(Color.WHITE);
     deposit.setBackground(Color.BLACK);
     add(deposit);
     
     cashwithdraw=new JButton("CASH WITHDRAWL");
     cashwithdraw.setBounds(380, 200, 230, 60);
     cashwithdraw.setFont(new Font("Raleway",Font.BOLD,18));
     cashwithdraw.setForeground(Color.WHITE);
     cashwithdraw.setBackground(Color.BLACK);
     add(cashwithdraw);
     
     fastcash=new JButton("FAST CASH");
     fastcash.setBounds(80, 300, 230, 60);
     fastcash.setFont(new Font("Raleway",Font.BOLD,20));
     fastcash.setForeground(Color.WHITE);
     fastcash.setBackground(Color.BLACK);
     add(fastcash);
     
     ministatement=new JButton("MINI STATEMENT");
     ministatement.setBounds(380, 300, 230, 60);
     ministatement.setFont(new Font("Raleway",Font.BOLD,20));
     ministatement.setForeground(Color.WHITE);
     ministatement.setBackground(Color.BLACK);
     add(ministatement);
     
     pinchange=new JButton("PIN CHANGE");
     pinchange.setBounds(80, 400, 230, 60);
     pinchange.setFont(new Font("Raleway",Font.BOLD,20));
     pinchange.setForeground(Color.WHITE);
     pinchange.setBackground(Color.BLACK);
     add(pinchange);
     
     balanceenq=new JButton("BALANCE ENQUIRY");
     balanceenq.setBounds(380, 400, 230, 60);
     balanceenq.setFont(new Font("Raleway",Font.BOLD,20));
     balanceenq.setForeground(Color.WHITE);
     balanceenq.setBackground(Color.BLACK);
     add(balanceenq);
     
     exit=new JButton("EXIT");
     exit.setBounds(240, 500, 230, 60);
     exit.setFont(new Font("Raleway",Font.BOLD,20));
     exit.setForeground(Color.WHITE);
     exit.setBackground(Color.RED);
     add(exit);
     
     balanceenq.addActionListener(this);
     cashwithdraw.addActionListener(this);
     deposit.addActionListener(this);
     exit.addActionListener(this);
     fastcash.addActionListener(this);
     ministatement.addActionListener(this);
     pinchange.addActionListener(this);
   
     
       setLayout(null);
       setSize(700,700);
       setLocation(300,20);
      // setUndecorated(true);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
    }
   
   
    
    public static void main(String[] args){
        new Transcations("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     if(ae.getSource()==deposit){
         setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(ae.getSource()==cashwithdraw){
            setVisible(false);
             new Wthdrawl(pin).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
         setVisible(false);
         new PinChange(pin).setVisible(true);
      }else if(ae.getSource()==balanceenq){
          this.setVisible(false);
          new BalanceEnquiry(pin).setVisible(true);
      }else if(ae.getSource()==ministatement){
          setVisible(false);
          new MiniStatement(pin).setVisible(true);
      }else if(ae.getSource()==exit){
        System.exit(1);
      }     
    }
}
