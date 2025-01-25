import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;
import java.util.Objects;

public class HomeWindow implements ActionListener {

    JPanel cardCrPanel = new JPanel();
    JButton loginButton = new JButton("Log in");
    JButton registerButton = new JButton("Register");
    JTextField mainWindowFText = new JTextField();
    JPasswordField mainWindowSText = new JPasswordField();
    JLabel userNameText = new JLabel();
    JLabel passwordText = new JLabel();
    JLabel atmImage = new JLabel();
    RegistrationPage regPage;

    // Constructor to initialize the JPanel
    HomeWindow() {

        //button LOGIN
        loginButton.setBounds(575, 230, 170, 50);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(12, 12, 12));
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setForeground(new Color(195, 42, 109));
        loginButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //BUTTON REGISTER
        registerButton.setBounds(575, 290, 170, 50);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);
        registerButton.setBackground(new Color(12, 12, 12));
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setForeground(new Color(195, 42, 109));
        registerButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // 1textField
        mainWindowFText.setBounds(510, 70, 300, 50);
        mainWindowFText.setBackground(new Color(12, 12, 12));
        mainWindowFText.setFont(new Font("Arial", Font.PLAIN, 20));
        mainWindowFText.setForeground(new Color(195, 195, 195));
        mainWindowFText.setCaretColor(new Color(195, 195, 195));
        mainWindowFText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // 2textField
        mainWindowSText.setBounds(510, 160, 300, 50);
        mainWindowSText.setBackground(new Color(12, 12, 12));
        mainWindowSText.setFont(new Font("Arial", Font.PLAIN, 20));
        mainWindowSText.setForeground(new Color(195, 195, 195));
        mainWindowSText.setCaretColor(new Color(195, 195, 195));
        mainWindowSText.setLocale(Locale.getDefault());
        mainWindowSText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //USERNAME TEXT
        userNameText.setText("UserName:");
        userNameText.setBounds(510, 55, 300, 12);
        userNameText.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameText.setForeground(new Color(195, 195, 195));

        //PASSWORD TEXT
        passwordText.setText("Password:");
        passwordText.setBounds(510, 145, 200, 12);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordText.setForeground(new Color(195, 195, 195));

        //------------------------------------------------todoImage
        ImageIcon imageIcon3 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/atm.png")));
        // Scale the image to the desired size
        Image image3 = imageIcon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        atmImage = new JLabel();
        //makeing cp image sizes
        atmImage.setIcon(new ImageIcon(image3));
        atmImage.setBounds(70, 70, 200, 200);

        cardCrPanel.add(atmImage);
        cardCrPanel.add(loginButton);
        cardCrPanel.add(registerButton);
        cardCrPanel.add(mainWindowSText);
        cardCrPanel.add(mainWindowFText);
        cardCrPanel.add(passwordText);
        cardCrPanel.add(userNameText);
        cardCrPanel.setBounds(20, 51, 850, 400);
        cardCrPanel.setLayout(null);
        cardCrPanel.setBackground(new Color(12, 12, 12));

    }

    public Component getPanel() {
        return cardCrPanel;
    }

    public void goBackToMain()
    {
        //restore main window
        cardCrPanel.removeAll();

        cardCrPanel.add(loginButton);
        cardCrPanel.add(registerButton);
        cardCrPanel.add(mainWindowFText);
        cardCrPanel.add(mainWindowSText);
        cardCrPanel.add(atmImage);
        cardCrPanel.add(userNameText);
        cardCrPanel.add(passwordText);

        cardCrPanel.revalidate();
        cardCrPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            Container parent = cardCrPanel.getParent();

            if (parent != null) {
                // Remove the panel from its parent
                parent.remove(cardCrPanel);

                // Create and add the new registration panel
                regPage = new RegistrationPage(this);
                JPanel secondPanel = regPage.getPanel();
                parent.add(secondPanel);

                // Refresh the parent container
                parent.revalidate();
                parent.repaint();
            }
        }

        if(e.getSource() == loginButton)
        {
            String userNameSet = mainWindowFText.getText();
            String passwordSet = mainWindowSText.getText();

            //-------------------------------------SHOOTS ERROR IF INPUTES ARE EMPTY
            if(ValidationClass.emptyInput(userNameSet) == 1)
            {
                userNameText.setText("UserNmae:Input can't be empty");
                userNameText.setForeground(Color.RED);
                mainWindowFText.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                return;
            }
            else
            {
                userNameText.setText("UserNmae:");
                userNameText.setForeground(Color.lightGray);
                mainWindowFText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            }

            if(ValidationClass.emptyInput(passwordSet) == 1)
            {
                passwordText.setText("Password:Input can't be empty");
                passwordText.setForeground(Color.RED);
                mainWindowSText.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                return;
            }
            else
            {
                passwordText.setText("Password:");
                passwordText.setForeground(Color.lightGray);
                mainWindowSText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            }

            //--------------------------------MARIDB START

            final String DB_URL = "jdbc:mariadb://127.0.0.1:3306";
            final String USER = "root";
            final String PASSWORD = "";

            try(Connection connection = (Connection) DriverManager.getConnection(DB_URL,USER,PASSWORD))
            {
                String query = "SELECT * FROM accinfo WHERE username = ? AND password = ?";
                try(PreparedStatement stmt = connection.prepareStatement(query))
                {
                    stmt.setString(1,userNameSet);
                    stmt.setString(2,passwordSet);

                    try(ResultSet resultSet = stmt.executeQuery())
                    {
                        if (resultSet.next()) {
                            // Username and password found
                            userNameText.setText("Username:");
                        }
                        else {
                            // Username or password incorrect
                            userNameText.setText("UserName:Invalid username or password.");
                            mainWindowSText.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                            mainWindowFText.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                            userNameText.setForeground(Color.RED);
                            passwordText.setForeground(Color.RED);
                            return;
                        }
                    }
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
            //--------------------------------MARIDB ENDS

            cardCrPanel.removeAll();
            // Add the second window's content
            UserPage userPage = new UserPage(this);
            JPanel secondPanel = userPage.getPanel(); // Get the panel from SecondWindow
            cardCrPanel.add(secondPanel);
            // Refresh the main panel to display the new content
            cardCrPanel.revalidate();
            cardCrPanel.repaint();
        }
    }
    //RESET USERNAME FIELD AFTER RETURNING HOME PAGE
    public void mainWindowSText(String s)
    {
        mainWindowSText.setText(s);
    }
    //RESET PASSWORD FIELD AFTER RETURNING HOME PAGE
    public void mainWindowFText(String s)
    {
        mainWindowFText.setText(s);
    }
}