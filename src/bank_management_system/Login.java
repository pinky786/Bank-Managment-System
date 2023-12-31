package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
//    constructor of login class
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
//        center layout bydefault removed now we can use custom
        setLayout(null);
//        image on frame : ImageIcone is a class and provide obj
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
//        image scale
        Image i2 =i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
//        image to imageicon convert becoz jlable cant use image class
        ImageIcon i3=new ImageIcon(i2);
//        place image on frame : we cant do directly
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);

//        components ko frame me add krna
        add(label);

//        JLable use for writing content on frame
        JLabel text =new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card No :");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,250,30);
        add(cardno);

         cardTextField = new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(cardTextField);


        JLabel pin =new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);

        add(pin);

         pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

         clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
      signup.setForeground(Color.WHITE);
      signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);
            setSize(800,480);
            setVisible(true);
            setLocation(350,200);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login){
            conn c = new conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select *  from login where cardnumber = '"+cardNumber+"'and  pinNumber = '"+pinNumber+"'";
            try {
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null , "Incorrect Card Number and PIN number");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
//        object created in main with call constructor
        new Login();
    }
}
