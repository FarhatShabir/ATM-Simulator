
package atm.samu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
     
public class Fastcash extends JFrame implements ActionListener{
    JLabel label;
    JButton rs100,rs500,rs1000,rs2000,rs5000,rs10000,exit;
    String pin;
    Fastcash(String pin){
       this.pin=pin;
        label=new JLabel("Select Withdrawl Amount");
        label.setFont(new Font("Times New Roman",Font.BOLD,34));
        label.setBounds(170, 80, 400, 40);
        add(label);
        
        rs100=new JButton("Rs 100");
        rs100.setFont(new Font("Times New Roman",Font.BOLD,24));
        rs100.setBounds(100, 200, 200, 40);
        rs100.setForeground(Color.WHITE);
        rs100.setBackground(Color.BLACK);
        add(rs100);
        
        rs500=new JButton("Rs 500");
        rs500.setFont(new Font("Times New Roman",Font.BOLD,24));
        rs500.setBounds(400, 200, 200, 40);
        rs500.setForeground(Color.WHITE);
        rs500.setBackground(Color.BLACK);
        add(rs500);
        
        rs1000=new JButton("Rs 1000");
        rs1000.setFont(new Font("Times New Roman",Font.BOLD,24));
        rs1000.setBounds(100, 300, 200, 40);
        rs1000.setForeground(Color.WHITE);
        rs1000.setBackground(Color.BLACK);
        add(rs1000);
        
        rs2000=new JButton("Rs 2000");
        rs2000.setFont(new Font("Times New Roman",Font.BOLD,24));
        rs2000.setBounds(400, 300, 200, 40);
        rs2000.setForeground(Color.WHITE);
        rs2000.setBackground(Color.BLACK);
        add(rs2000);
        
        rs5000=new JButton("Rs 5000");
        rs5000.setFont(new Font("Times New Roman",Font.BOLD,24));
        rs5000.setBounds(100, 400, 200, 40);
        rs5000.setForeground(Color.WHITE);
        rs5000.setBackground(Color.BLACK);
        add(rs5000);
        
        rs10000=new JButton("Rs 10000");
        rs10000.setFont(new Font("Times New Roman",Font.BOLD,24));
        rs10000.setBounds(400, 400, 200, 40);
        rs10000.setForeground(Color.WHITE);
        rs10000.setBackground(Color.BLACK);
        add(rs10000);
        
        exit=new JButton("BACK");
        exit.setFont(new Font("Times New Roman",Font.BOLD,24));
        exit.setBounds(240, 500, 200, 40);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.RED);
        add(exit);
        
        rs100.addActionListener(this);
        rs500.addActionListener(this);
        rs1000.addActionListener(this);
        rs2000.addActionListener(this);
        rs5000.addActionListener(this);
        rs10000.addActionListener(this);
        
        exit.addActionListener(this);
        
        
       setLayout(null);
       setSize(700,700);
       setLocation(300,20);
      // setUndecorated(true);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ae){
             String amount;
             Date date=new Date();
             if(ae.getSource()==exit){
                 setVisible(false);
                 new Transcations(pin).setVisible(true);
                 return;
             }
        try {
       
            amount=null;
            if(ae.getSource()==rs500){
                amount="500";
            }else if(ae.getSource()==rs1000){
                amount="1000";
            }else if(ae.getSource()==rs100){
                amount="100";
            }else if(ae.getSource()==rs2000){
                amount="2000";
            }else if(ae.getSource()==rs5000){
                amount="5000";
            }
            else if(ae.getSource()==rs10000){
                amount="10000";
            }else {
                setVisible(false);
                new Transcations(pin).setVisible(true);
            }
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
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
        
    }
    public static void main(String[] args){
       new Fastcash("").setVisible(true);
    }
}
