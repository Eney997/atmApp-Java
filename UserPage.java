import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class UserPage implements ActionListener {
    HomeWindow homeWindow;
    JPanel userPanel = new JPanel();
    JButton longOut = new JButton("Long out");
    JButton submitPin = new JButton("Submit");
    JLabel imageLable = new JLabel();
    JLabel welCome = new JLabel();
    JLabel enterPinText = new JLabel();
    JTextField enterPin = new JTextField();

    UserPage(HomeWindow homeWindow)
    {
        this.homeWindow = homeWindow;


        enterPin.setBounds(290, 110, 300, 50);
        enterPin.setBackground(new Color(12, 12, 12));
        enterPin.setFont(new Font("Arial", Font.PLAIN, 20));
        enterPin.setForeground(new Color(195, 195, 195));
        enterPin.setCaretColor(new Color(195, 195, 195));
        enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        submitPin.setBounds(390,200,100,50);
        submitPin.setFocusable(false);
        submitPin.addActionListener(this);
        submitPin.setBackground(new Color(12, 12, 12));
        submitPin.setFont(new Font("Arial", Font.BOLD, 16));
        submitPin.setForeground(new Color(195,42,109));
        submitPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        longOut.setBounds(390,260,100,50);
        longOut.setFocusable(false);
        longOut.addActionListener(this);
        longOut.setBackground(new Color(12, 12, 12));
        longOut.setFont(new Font("Arial", Font.BOLD, 16));
        longOut.setForeground(new Color(195,42,109));
        longOut.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));


//        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/cpLogo.bmp")));
//        // Scale the image to the desired size
//        Image image = imageIcon.getImage().getScaledInstance(450, 400, Image.SCALE_SMOOTH);
//        imageLable = new JLabel();
//        //makeing cp image sizes
//        imageLable.setIcon(new ImageIcon(image));
//        imageLable.setBounds(50, 70, 450, 300);

        welCome.setText("Your card is in the ATM machine, please enter the PIN");
        welCome.setBounds(125,25,700,50);
        welCome.setFont(new Font("Arial", Font.BOLD, 24));
        welCome.setForeground(Color.lightGray);

        enterPinText.setText("Enter pin:");
        enterPinText.setBounds(290,85,300,30);
        enterPinText.setFont(new Font("Arial", Font.BOLD, 14));
        enterPinText.setForeground(Color.lightGray);

        userPanel.add(submitPin);
        userPanel.add(enterPinText);
        userPanel.add(enterPin);
        userPanel.add(welCome);
        userPanel.add(longOut);
        //userPanel.add(imageLable);
        userPanel.setLayout(null);
        userPanel.setBounds(0,0,850,400);
        userPanel.setBackground(new Color(12,12,12));
    }

    public JPanel getPanel()
    {
        return userPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == longOut)
        {
            homeWindow.mainWindowSText("");
            homeWindow.mainWindowFText("");
            homeWindow.goBackToMain();
        }

        if(e.getSource() == submitPin)
        {
            String pinEntry  = enterPin.getText();

            if(ValidationClass.emptyInput(pinEntry) == 1)
            {
                enterPinText.setText("Enter pin:Empty input");
                enterPinText.setForeground(Color.red);
                enterPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                return;
            }
            else
            {
                enterPinText.setText("Enter pin:");
                enterPinText.setForeground(Color.lightGray);
                enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            }

            if(!ValidationClass.containsOnlyNumbers(pinEntry))
            {
                enterPinText.setText("Enter pin:Enter only number");
                enterPinText.setForeground(Color.red);
                enterPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                return;
            }
            else
            {
                enterPinText.setText("Enter pin:");
                enterPinText.setForeground(Color.lightGray);
                enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            }

            if(ValidationClass.minimumSix(pinEntry) == 1)
            {
                enterPinText.setText("Enter pin:Pin 6 number");
                enterPinText.setForeground(Color.red);
                enterPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                return;
            }
            else
            {
                enterPinText.setText("Enter pin:");
                enterPinText.setForeground(Color.lightGray);
                enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            }

            //--------------------maria db search pin start

            final String DB_URL = "jdbc:mariadb://127.0.0.1:3306";
            final String USER = "root";
            final String PASSWORD = "";

            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                String query = "SELECT * FROM accinfo WHERE username = ? AND pin = ?";
                try (PreparedStatement stmt = connection.prepareStatement(query)) {
                    // Retrieve authenticated username from HomeWindow
                    String takeUserNameFromHomeWindowInput = homeWindow.mainWindowFText.getText();

                    System.out.println(takeUserNameFromHomeWindowInput);
                    System.out.println(pinEntry);

                    // Set the username and PIN in the query
                    stmt.setString(1, takeUserNameFromHomeWindowInput);
                    stmt.setInt(2, Integer.parseInt(pinEntry));

                    try (ResultSet resultSet = stmt.executeQuery()) {
                        if (!resultSet.next()) {
                            // No matching username and PIN found
                            enterPinText.setText("Enter pin: Incorrect PIN");
                            enterPinText.setForeground(Color.red);
                            enterPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                            return;
                        }
                    }
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }

            //todo

            //--------------------maria db search pin end

        }

    }
}