
package atm.samu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    JLabel msg,current,newpin,reenterpin;
    JPasswordField current1,newpin1,reenterpin1;
    JButton save,back;
    String pin;
    
    PinChange(String pin){
        this.pin=pin;
        setTitle("PIN CHANGE");
        
        msg=new JLabel("CHANGE YOUR PIN");
        msg.setFont(new Font("System",Font.BOLD,34));
        msg.setBounds(165,170,400,30);
        add(msg);
        
        current =new JLabel("Current PIN  ::");
        current.setFont(new Font("System",Font.BOLD,24));
        current.setBounds(100,250,200,30);
        add(current);
        
        current1=new JPasswordField();
        current1.setFont(new Font("System",Font.BOLD,24));
        current1.setBounds(330,250,250,30);
        add(current1); 
        
        newpin=new JLabel("New PIN       ::");
        newpin.setFont(new Font("System",Font.BOLD,24));
        newpin.setBounds(100,300,200,30);
        add(newpin);
        
        newpin1=new JPasswordField();
        newpin1.setFont(new Font("System",Font.BOLD,24));
        newpin1.setBounds(330,300,250,30);
        add(newpin1);
        
        reenterpin=new JLabel("Re-Enter PIN ::");
        reenterpin.setFont(new Font("System",Font.BOLD,24));
        reenterpin.setBounds(100,350,200,30);
        add(reenterpin);
        
        reenterpin1=new JPasswordField();
        reenterpin1.setFont(new Font("System",Font.BOLD,24));
        reenterpin1.setBounds(330,350,250,30);
        add(reenterpin1);
        
        save=new JButton("SAVE");
        save.setFont(new Font("System",Font.BOLD,19));
        save.setBounds(200,420,150,40);
        save.setForeground(Color.WHITE);
        save.setBackground(Color.GREEN);
        add(save);
        
        back=new JButton("BACK");
        back.setFont(new Font("System",Font.BOLD,19));
        back.setBounds(400,420,150,40);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.RED);
        add(back);
        
        back.addActionListener(this);
        save.addActionListener(this);
        setLayout(null);
        setSize(700,700);
        setLocation(300,20);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
   
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }

    @Override
   
    public void actionPerformed(ActionEvent ae) {
              if(ae.getSource()==back){
            setVisible(false);
            new Transcations(pin).setVisible(true);
        }
           if(ae.getSource()==save){
            try{
                String pin1,pin2,pin3;
                pin1=current1.getText().toString();
                pin2=newpin1.getText().toString();
                pin3=reenterpin1.getText().toString();
                if(pin1.equals(pin)){
                    conn c1=new conn();
                    String q1="update bank set pin ='"+pin2+"' where pin = '"+pin+"'";
                    String q2="update login set pin ='"+pin2+"' where pin = '"+pin+"'";
                    String q3="update signup3 set pin ='"+pin2+"' where pin = '"+pin+"'";
                    
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
                    
                    JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                    new Transcations(pin2).setVisible(true);// or use pin
                }else if(newpin1.getText()!=reenterpin1.getText()||current1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Check your New PIN");
                    newpin1.setText("");
                    reenterpin1.setText("");
                }else{
                   JOptionPane.showMessageDialog(null,"Something Went Wrong");
                   return;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
