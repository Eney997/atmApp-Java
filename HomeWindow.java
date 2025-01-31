import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;
import java.util.Objects;

public class HomeWindow implements ActionListener {

    JButton loginButton = new JButton("Log in");
    JButton registerButton = new JButton("Register");
    JTextField mainWindowFText = new JTextField();
    JPasswordField mainWindowSText = new JPasswordField();
    JLabel userNameText = new JLabel();
    JLabel passwordText = new JLabel();
    JLabel atmImage = new JLabel();
    RegistrationPage registrationPage;
    UserPage userPage;

    //------------------------------------------------------------------------Constructor to initialize the JPanel START
    HomeWindow() {
        //button LOGIN
        loginButton.setBounds(578, 265, 170, 50);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        loginButton.setBackground(new Color(12, 12, 12));
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setForeground(new Color(195, 42, 109));
        loginButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //BUTTON REGISTER
        registerButton.setBounds(578, 325, 170, 50);
        registerButton.setFocusable(false);
        registerButton.addActionListener(exp->{//if user clicks registration button homeWIndow will dissapear
            loginButton.setVisible(false);
            registerButton.setVisible(false);
            mainWindowSText.setVisible(false);
            mainWindowFText.setVisible(false);
            userNameText.setVisible(false);
            passwordText.setVisible(false);
            atmImage.setVisible(false);

            registrationPage.digitNumText.setVisible(true);
            registrationPage.pinText.setVisible(true);
            registrationPage.cardDigits.setVisible(true);
            registrationPage.cardPin.setVisible(true);
            registrationPage.expMonthText.setVisible(true);
            registrationPage.expYearText.setVisible(true);
            registrationPage.expMonth.setVisible(true);
            registrationPage.expYear.setVisible(true);
            registrationPage.cvvCvcText.setVisible(true);
            registrationPage.cvvCvc.setVisible(true);
            registrationPage.password.setVisible(true);
            registrationPage.passwordText.setVisible(true);
            registrationPage.userNameText.setVisible(true);
            registrationPage.userName.setVisible(true);
            registrationPage.lastName.setVisible(true);
            registrationPage.lastNameText.setVisible(true);
            registrationPage.nameText.setVisible(true);
            registrationPage.name.setVisible(true);
            registrationPage.goBakcButton.setVisible(true);
            registrationPage.submitButton.setVisible(true);

        });
        registerButton.setBackground(new Color(12, 12, 12));
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setForeground(new Color(195, 42, 109));
        registerButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // 1textField
        mainWindowFText.setBounds(510, 120, 300, 50);
        mainWindowFText.setBackground(new Color(12, 12, 12));
        mainWindowFText.setFont(new Font("Arial", Font.PLAIN, 20));
        mainWindowFText.setForeground(new Color(195, 195, 195));
        mainWindowFText.setCaretColor(new Color(195, 195, 195));
        mainWindowFText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // 2textField
        mainWindowSText.setBounds(510, 200, 300, 50);
        mainWindowSText.setBackground(new Color(12, 12, 12));
        mainWindowSText.setFont(new Font("Arial", Font.PLAIN, 20));
        mainWindowSText.setForeground(new Color(195, 195, 195));
        mainWindowSText.setCaretColor(new Color(195, 195, 195));
        mainWindowSText.setLocale(Locale.getDefault());
        mainWindowSText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //USERNAME TEXT
        userNameText.setText("UserName:");
        userNameText.setBounds(510, 105, 300, 12);
        userNameText.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameText.setForeground(new Color(195, 195, 195));

        //PASSWORD TEXT
        passwordText.setText("Password:");
        passwordText.setBounds(510, 185, 200, 12);
        passwordText.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordText.setForeground(new Color(195, 195, 195));

        //------------------------------------------------todoImage
        ImageIcon imageIcon3 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/bank.png")));
        // Scale the image to the desired size
        Image image3 = imageIcon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        atmImage = new JLabel();
        //makeing cp image sizes
        atmImage.setIcon(new ImageIcon(image3));
        atmImage.setBounds(110, 100, 200, 200);
    }
    //--------------------------------------------------------------------------Constructor to initialize the JPanel END

    //method to make registration window elements visible
    public void setRegister(RegistrationPage registrationPage)
    {
        this.registrationPage = registrationPage;
    }

    //method to make registration window elements visible
    public void userPages(UserPage userPage)
    {
        this.userPage = userPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //-------------------------------------------------------------------------ACTION LISTENER ON LOGIN BUTTON START
        if(e.getSource() == loginButton)
        {
            //TAKE AND STORE USERNAME AND PASSWORD INPUTS ON VARIABLE
            String userNameSet = mainWindowFText.getText();
            String passwordSet = mainWindowSText.getText();

            //-------------------------------------------------------------------------SHOOTS ERROR IF INPUTES ARE EMPTY
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

            //----------------------------------------------------------------------------------------------MARIDB START
            final String DB_URL = "jdbc:mariadb://127.0.0.1:3306";
            final String USER = "root";
            final String PASSWORD = "password";

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
            //-----------------------------------------------------------------------------------------------MARIDB ENDS

            //----------------------show userPageif,make invisible homeWindow if pass and username will be corecto START

            userPage.enterPin.setVisible(true);
            userPage.submitPin.setVisible(true);
            userPage.longOut.setVisible(true);
            userPage.welCome.setVisible(true);
            userPage.enterPinText.setVisible(true);
            //updateUsernameToSeeOnUserPage
            userPage.updateUserName();

            loginButton.setVisible(false);
            registerButton.setVisible(false);
            mainWindowSText.setVisible(false);
            mainWindowFText.setVisible(false);
            userNameText.setVisible(false);
            passwordText.setVisible(false);
            atmImage.setVisible(false);

            //------------------------show userPageif,make invisible homeWindow if pass and username will be corecto END
        }
    }
}