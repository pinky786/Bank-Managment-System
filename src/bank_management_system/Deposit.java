package bank_management_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    JLabel text;
    JTextField amount;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber=pinNumber;
        setTitle("Deposit");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Disable frame resizing (fixed size)
        setResizable(false);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

         text= new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

         amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        deposit= new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back= new JButton("Back");
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
if (ae.getSource()==deposit){
    String number=amount.getText();
    Date date=new Date();
    if (number.equals("")){
        JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
    }else{
        try {

            conn c = new conn();
            String query = "insert into bank values('" + pinNumber + "', '" + date + "','Deposit','" + number + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
           setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
    }
} else if (ae.getSource()==back) {
    setVisible(false);
new Transactions(pinNumber).setVisible(true);
}
    }

    public static void main(String[] args) {
        new Deposit("");
    }


}
