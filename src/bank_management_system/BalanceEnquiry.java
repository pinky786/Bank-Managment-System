package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;

    BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;

        setTitle("BALANCE ENQUIRY");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back =new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);


        conn c=new conn();
        int balance=0;
        try{
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pinNumber = '" + pinNumber + "'");

            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text= new JLabel("Your Current Account Balance is Rs " + balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.WHITE);
        image.add(text);



        // Create a JScrollPane and add the image JLabel to it
        JScrollPane scrollPane = new JScrollPane(image);

        // Configure the scroll policy to show both vertical and horizontal scrollbars
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Set the preferred size of the image JLabel to match the image size
        image.setPreferredSize(new Dimension(900, 900));

        // Add the scroll pane to the frame
        add(scrollPane, BorderLayout.CENTER);


        pack(); // Automatically adjust the frame size
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }


}
