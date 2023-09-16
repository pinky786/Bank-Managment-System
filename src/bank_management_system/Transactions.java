package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit ,withdrawl,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinNumber;
    Transactions(String pinNumber) {
        this.pinNumber=pinNumber;
//   setUndecorated(true);
        setTitle("Transactions");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

         deposit =new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

         withdrawl =new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

         fastcash =new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

         ministatement =new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

         pinchange =new JButton("PIN Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

         balanceenquiry =new JButton("Balance  Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

         exit =new JButton("Exit ");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


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
        if (ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource()==withdrawl) {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        } else if (ae.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if (ae.getSource()==pinchange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if (ae.getSource()==balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if (ae.getSource()==ministatement) {

            new MiniStatement(pinNumber).setVisible(true);
        }

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Transactions(""));
    }


}
