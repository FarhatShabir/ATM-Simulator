
package atm.samu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel msg,amt;
    String pin;
    JButton back;
    BalanceEnquiry(String pin){
       this.pin=pin;
       setTitle("BALANCE ENQUIRY");
       
       msg=new JLabel("YOUR ACCOUNT BALANCE IS ");
       msg.setFont(new Font("Times New Roman",Font.BOLD,34));
     //  msg.setBackground(Color.GREEN);
       msg.setForeground(Color.BLACK);
       msg.setBounds(100, 200, 600, 40);
       add(msg);
       
       amt=new JLabel("test");
       amt.setFont(new Font("Times New Roman",Font.BOLD,60));
       amt.setForeground(Color.BLUE);
       amt.setBounds(260, 300, 600, 60);
       int balance =0;
                try{
                conn c1=new conn(); 
                   
                ResultSet rs=c1.s.executeQuery("select * from bank where pin ='"+pin+"'");
                   
                
                   while(rs.next()){
                       if(rs.getString("mode").equals("Deposit")){
                           balance +=Integer.parseInt(rs.getString("amount"));
                       }
                       else{
                           balance-=Integer.parseInt(rs.getString("amount"));
                       }
                   }
                   
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            amt.setText(""+balance);
            add(amt);
            
       
       back=new JButton("BACK");
       back.setFont(new Font("Times New Roman",Font.BOLD,34));
       back.setForeground(Color.WHITE);
       back.setBackground(Color.RED);
       back.setBounds(220, 500, 250, 40);
       add(back);
       back.addActionListener(this);
       
       setLayout(null);
       setSize(700,700);
       setLocation(300,20);
      // setUndecorated(true);
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==back){
          setVisible(false);
          new Transcations(pin).setVisible(true);
      }
    }
    
    public static void main(String[] args){
        new BalanceEnquiry("").setVisible(true);
    }
    
}
