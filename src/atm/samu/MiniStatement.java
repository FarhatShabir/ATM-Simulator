package atm.samu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pin;
    JButton back;
    JLabel nameofbank, print;

    MiniStatement(String pin) {
        setTitle("MINI STATEMENT");
        this.pin = pin;

        nameofbank = new JLabel("BANK.LTD");
        nameofbank.setFont(new Font("System", Font.BOLD, 36));
        nameofbank.setBounds(240, 50, 400, 30);
        add(nameofbank);

        back = new JButton("BACK");
        back.setFont(new Font("System", Font.BOLD, 20));
        back.setBounds(300, 600, 100, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);

        print = new JLabel();
        print.setBounds(100, 120, 400, 30);
        print.setFont(new Font("System", Font.BOLD, 16));
        add(print);
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pin + "'");
            while (rs.next()) {
                print.setText("Card Number ::" + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));

            }
        } catch (Exception e) {

        }
        JLabel detail = new JLabel();
        detail.setBounds(100, 100, 400, 500);
        detail.setFont(new Font("System", Font.BOLD, 14));
        add(detail);

        JLabel balance = new JLabel("text");
        balance.setBounds(490, 80, 400, 30);
        balance.setFont(new Font("System", Font.BOLD, 16));
        add(balance);

        int amt = 0;
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
            while (rs.next()) {
                detail.setText(detail.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("mode") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("mode").equals("Deposit")) {
                    amt += Integer.parseInt(rs.getString("amount"));
                } else {
                    amt -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {

        }
        balance.setText("Aialable Balance = " + amt);

        setLayout(null);
        setSize(700, 700);
        setLocation(300, 20);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }//Close Construcotr

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transcations(pin).setVisible(true);
        }

    }
}
