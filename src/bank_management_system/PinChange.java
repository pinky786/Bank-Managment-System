package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    JLabel text,pintext,repintext;
    JPasswordField pin,repin;
    JButton change,back;
    String pinNumber;
    PinChange(String pinNumber){
        this.pinNumber=pinNumber;
        //   setUndecorated(true);
        setTitle("Pinchange");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text= new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        pintext= new JLabel("NEW PIN:");
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);

        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        repintext= new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);

         repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);








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
        if (ae.getSource()==change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doest Not Match");
                    return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                conn c= new conn();
                String query1= "update bank set pinNumber ='"+rpin+"' where pinNumber='"+pinNumber+"'";
                String query2= "update login set pinNumber ='"+rpin+"' where pinNumber='"+pinNumber+"'";
                String query3= "update signupthree set pinNumber ='"+rpin+"' where pinNumber='"+pinNumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN change successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }



    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }}

