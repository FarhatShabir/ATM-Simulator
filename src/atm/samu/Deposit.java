/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm.samu;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Farhat Shabir
 */
public class Deposit extends JFrame implements ActionListener{
    
    JTextField amt,pinno;
    JButton depositb,back,exit;
    JLabel msg,depositlab,pinnol;
    String pin;

     Deposit(String pin){
         this.pin=pin;
         setTitle("DEPOSIT");
         
         msg=new JLabel("ENTER AMOUNT YOU WANT");
         depositlab=new JLabel("TO DEPOSIT");
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
         
         depositb = new JButton("DEPOSIT");
         depositb.setBounds(160,370,150,50);
         depositb.setFont(new Font("Raleway",Font.BOLD,25));
         depositb.setForeground(Color.WHITE);
         depositb.setBackground(Color.BLACK);
         add(depositb);
         
         back = new JButton("BACK");
         back.setBounds(390,370,150,50);
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
         
         pinnol=new JLabel("Enter Pin ::");
         pinnol.setBounds(530, 40, 100, 30);
         add(pinnol);
         
         pinno=new JTextField();
         pinno.setBounds(600,40,80,30);
         add(pinno);
         
         depositb.addActionListener(this);
         back.addActionListener(this);
         exit.addActionListener(this);
         setLayout(null);
        setSize(700,700);
       setLocation(300,20);
      // setUndecorated(true);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
     }

public static void main(String[] args){
    new Deposit("").setVisible(true);
}    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Date date=new Date();
        String amount=amt.getText();
        String pincheck=pinno.getText();
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
            if(!(pinno.getText().equals(pin))){ 
                JOptionPane.showMessageDialog(null, "Enter Valid Pin No. to Continue");            
            }
            if(pinno.getText().equals(pincheck)){
                   conn c1=new conn(); 
                   c1.s.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"RS :: "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transcations(pin).setVisible(true);
                    
                }
            
        }
        }catch(Exception ee){
            ee.setStackTrace(ee.getStackTrace());
        }
      
    }
}
