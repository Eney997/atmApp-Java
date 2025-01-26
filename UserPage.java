import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;
import java.util.Objects;

public class UserPage implements ActionListener {

    double moneyBalance = 0.00;
    HomeWindow homeWindow;
    JPanel userPanel = new JPanel();
    JButton longOut = new JButton("Long out");
    JButton submitPin = new JButton("Submit");
    JLabel welCome = new JLabel();
    JLabel enterPinText = new JLabel();
    JPasswordField enterPin = new JPasswordField();
    //atm menu elements
    JButton exit = new JButton("Exit");
    JButton transferMoney = new JButton("Transfer");
    JButton withdrawMoney = new JButton("Withdraw");
    JButton depositMoney = new JButton("Deposit");
    JLabel useService = new JLabel();
    JLabel hiUserName = new JLabel();
    JLabel amountMoney = new JLabel();
    JLabel paymentImage = new JLabel();
    //in atmButton deposite
    JButton inDepositButton = new JButton("Pay");
    JLabel pleasePutDepositeMoney = new JLabel();
    JTextField depositeMoenyInput = new JTextField();
    JLabel depositErrors = new JLabel();
    //go back button from all service
    JButton goBackFromAllService = new JButton("Go Back");


    UserPage(HomeWindow homeWindow)
    {
        this.homeWindow = homeWindow;

        //DEPOSITE MONEY STATR
        inDepositButton.setBounds(390,190,100,50);
        inDepositButton.setFocusable(false);
        inDepositButton.addActionListener(this);
        inDepositButton.setBackground(new Color(12, 12, 12));
        inDepositButton.setFont(new Font("Arial", Font.BOLD, 16));
        inDepositButton.setForeground(new Color(195,42,109));
        inDepositButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        inDepositButton.setVisible(false);

        pleasePutDepositeMoney.setText("Enter the deposit amount");
        pleasePutDepositeMoney.setBounds(315,65,300,30);
        pleasePutDepositeMoney.setFont(new Font("Arial", Font.BOLD, 20));
        pleasePutDepositeMoney.setForeground(Color.lightGray);
        pleasePutDepositeMoney.setVisible(false);

        depositErrors.setText("Enter amount:");
        depositErrors.setBounds(290,110,300,20);
        depositErrors.setFont(new Font("Arial", Font.BOLD, 14));
        depositErrors.setForeground(Color.lightGray);
        depositErrors.setVisible(false);

        depositeMoenyInput.setBounds(290, 130, 300, 50);
        depositeMoenyInput.setBackground(new Color(12, 12, 12));
        depositeMoenyInput.setFont(new Font("Arial", Font.PLAIN, 20));
        depositeMoenyInput.setForeground(new Color(195, 195, 195));
        depositeMoenyInput.setCaretColor(new Color(195, 195, 195));
        depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        depositeMoenyInput.setVisible(false);

        //DEPOSITE MONEY END


        //ATM MENU ELEMENTS START

        amountMoney.setText("Balance:$"+moneyBalance);
        amountMoney.setBounds(0,30,180,20);
        amountMoney.setFont(new Font("Arial", Font.BOLD, 16));
        amountMoney.setForeground(Color.lightGray);
        amountMoney.setVisible(false);

        ImageIcon imageIcon3 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/payments.png")));
        // Scale the image to the desired size
        Image image3 = imageIcon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        paymentImage = new JLabel();
        //makeing cp image sizes
        paymentImage.setIcon(new ImageIcon(image3));
        paymentImage.setBounds(580, 90, 100, 100);
        paymentImage.setVisible(false);


        String takeUserName = homeWindow.mainWindowFText.getText();
        hiUserName.setText("Hi,"+takeUserName);
        hiUserName.setBounds(0,10,100,20);
        hiUserName.setFont(new Font("Arial", Font.BOLD, 16));
        hiUserName.setForeground(Color.lightGray);
        hiUserName.setVisible(false);

        useService.setText("Please select a service");
        useService.setBounds(300,50,500,50);
        useService.setFont(new Font("Arial", Font.BOLD, 24));
        useService.setForeground(Color.lightGray);
        useService.setVisible(false);

        transferMoney.setBounds(440, 150, 170, 50);
        transferMoney.setFocusable(false);
        transferMoney.addActionListener(this);
        transferMoney.setBackground(new Color(12, 12, 12));
        transferMoney.setFont(new Font("Arial", Font.BOLD, 16));
        transferMoney.setForeground(new Color(195, 42, 109));
        transferMoney.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        transferMoney.setVisible(false);

        withdrawMoney.setBounds(250, 240, 170, 50);
        withdrawMoney.setFocusable(false);
        withdrawMoney.addActionListener(this);
        withdrawMoney.setBackground(new Color(12, 12, 12));
        withdrawMoney.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawMoney.setForeground(new Color(195, 42, 109));
        withdrawMoney.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        withdrawMoney.setVisible(false);

        depositMoney.setBounds(250, 150, 170, 50);
        depositMoney.setFocusable(false);
        depositMoney.addActionListener(ex -> {
            depositMoney.setVisible(false);
            exit.setVisible(false);
            transferMoney.setVisible(false);
            withdrawMoney.setVisible(false);
            useService.setVisible(false);
            paymentImage.setVisible(false);

            pleasePutDepositeMoney.setVisible(true);
            inDepositButton.setVisible(true);
            depositeMoenyInput.setVisible(true);
            depositErrors.setVisible(true);
            goBackFromAllService.setVisible(true);
        });
        depositMoney.setBackground(new Color(12, 12, 12));
        depositMoney.setFont(new Font("Arial", Font.BOLD, 16));
        depositMoney.setForeground(new Color(195, 42, 109));
        depositMoney.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        depositMoney.setVisible(false);

        exit.setBounds(440, 240, 170, 50);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setBackground(new Color(12, 12, 12));
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setForeground(new Color(195, 42, 109));
        exit.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        exit.setVisible(false);

        //ATM MENU ELEMENTS END

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

        welCome.setText("Your card is in the ATM machine, please enter the PIN");
        welCome.setBounds(125,25,700,50);
        welCome.setFont(new Font("Arial", Font.BOLD, 24));
        welCome.setForeground(Color.lightGray);

        enterPinText.setText("Enter pin:");
        enterPinText.setBounds(290,85,300,30);
        enterPinText.setFont(new Font("Arial", Font.BOLD, 14));
        enterPinText.setForeground(Color.lightGray);

        //Go back from all service Button start

        goBackFromAllService.setBounds(390,245,100,50);
        goBackFromAllService.setFocusable(false);
        goBackFromAllService.addActionListener(ex1 -> {
            pleasePutDepositeMoney.setVisible(false);
            inDepositButton.setVisible(false);
            depositeMoenyInput.setVisible(false);
            depositErrors.setVisible(false);
            goBackFromAllService.setVisible(false);

            depositMoney.setVisible(true);
            exit.setVisible(true);
            transferMoney.setVisible(true);
            withdrawMoney.setVisible(true);
            useService.setVisible(true);
            paymentImage.setVisible(true);

            depositErrors.setText("Enter amount:");
            depositErrors.setForeground(Color.lightGray);
            depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        });
        goBackFromAllService.setBackground(new Color(12, 12, 12));
        goBackFromAllService.setFont(new Font("Arial", Font.BOLD, 16));
        goBackFromAllService.setForeground(new Color(195,42,109));
        goBackFromAllService.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        goBackFromAllService.setVisible(false);

        //Go back from all service Button end


        //go back from all service
        userPanel.add(goBackFromAllService);
        //atmIn
        userPanel.add(inDepositButton);
        userPanel.add(pleasePutDepositeMoney);
        userPanel.add(depositeMoenyInput);
        userPanel.add(depositErrors);
        //atmMenuPageElements
        userPanel.add(exit);
        userPanel.add(depositMoney);
        userPanel.add(transferMoney);
        userPanel.add(withdrawMoney);
        userPanel.add(useService);
        userPanel.add(hiUserName);
        userPanel.add(paymentImage);
        userPanel.add(amountMoney);
        //userPincodeEntryPageElements
        userPanel.add(submitPin);
        userPanel.add(enterPinText);
        userPanel.add(enterPin);
        userPanel.add(welCome);
        userPanel.add(longOut);
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
        if(e.getSource() == longOut) {
            // Get the parent container of the current panel
            Container parent = userPanel.getParent();

            if (parent != null) {
                // Remove the RegistrationWindow panel from the parent
                parent.remove(userPanel);
                homeWindow.mainWindowSText("");
                homeWindow.mainWindowFText("");
                // Call goBackToMain to reset the HomeWindow panel
                homeWindow.goBackToMain();
                // Revalidate and repaint the parent to refresh the UI
                parent.revalidate();
                parent.repaint();
            }
        }

            if (e.getSource() == submitPin) {
                String pinEntry = enterPin.getText();

                if (ValidationClass.emptyInput(pinEntry) == 1) {
                    enterPinText.setText("Enter pin:Empty input");
                    enterPinText.setForeground(Color.red);
                    enterPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                } else {
                    enterPinText.setText("Enter pin:");
                    enterPinText.setForeground(Color.lightGray);
                    enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if (!ValidationClass.containsOnlyNumbers(pinEntry)) {
                    enterPinText.setText("Enter pin:Enter only number");
                    enterPinText.setForeground(Color.red);
                    enterPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                } else {
                    enterPinText.setText("Enter pin:");
                    enterPinText.setForeground(Color.lightGray);
                    enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if (ValidationClass.minimumSix(pinEntry) == 1) {
                    enterPinText.setText("Enter pin:Pin 6 number");
                    enterPinText.setForeground(Color.red);
                    enterPin.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                } else {
                    enterPinText.setText("Enter pin:");
                    enterPinText.setForeground(Color.lightGray);
                    enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                //--------------------maria db search pin start

                final String DB_URL = "jdbc:mariadb://127.0.0.1:3306";
                final String USER = "root";
                final String PASSWORD = "password";

                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                    String query = "SELECT * FROM accinfo WHERE username = ? AND pin = ?";
                    try (PreparedStatement stmt = connection.prepareStatement(query)) {
                        // Retrieve authenticated username from HomeWindow
                        String takeUserNameFromHomeWindowInput = homeWindow.mainWindowFText.getText();

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
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                //--------------------maria db search pin end

                //if user enters correct pin than go in atm menu . start.

                enterPin.setVisible(false);
                longOut.setVisible(false);
                submitPin.setVisible(false);
                welCome.setVisible(false);
                enterPinText.setVisible(false);

                depositMoney.setVisible(true);
                exit.setVisible(true);
                transferMoney.setVisible(true);
                withdrawMoney.setVisible(true);
                useService.setVisible(true);
                hiUserName.setVisible(true);
                paymentImage.setVisible(true);
                amountMoney.setVisible(true);

                //if user enters correct pin than go in atm menu . END.
            }

            if (e.getSource() == exit) {
                    // Get the parent container of the current panel
                    Container parent = userPanel.getParent();

                    if (parent != null) {
                    // Remove the RegistrationWindow panel from the parent
                    parent.remove(userPanel);
                    homeWindow.mainWindowSText("");
                    homeWindow.mainWindowFText("");
                    // Call goBackToMain to reset the HomeWindow panel
                    homeWindow.goBackToMain();
                    // Revalidate and repaint the parent to refresh the UI
                    parent.revalidate();
                    parent.repaint();
                 }
            }


            if(e.getSource() == inDepositButton)
            {
                String depositSet = depositeMoenyInput.getText();

                if(ValidationClass.emptyInput(depositSet) == 1)
                {
                    depositErrors.setText("Enter amount:Empty input");
                    depositErrors.setForeground(Color.red);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    depositErrors.setText("Enter amount:");
                    depositErrors.setForeground(Color.lightGray);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.forbidSpace(depositSet) == 1)
                {
                    depositErrors.setText("Enter amount:Space detected");
                    depositErrors.setForeground(Color.red);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    depositErrors.setText("Enter amount:");
                    depositErrors.setForeground(Color.lightGray);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(!ValidationClass.containsOnlyNumbers(depositSet))
                {
                    depositErrors.setText("Enter amount:Enter only number");
                    depositErrors.setForeground(Color.red);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    depositErrors.setText("Enter amount:");
                    depositErrors.setForeground(Color.lightGray);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.depositAmountMaxNumber(depositSet) == 1)
                {
                    depositErrors.setText("Enter amount:To many digit");
                    depositErrors.setForeground(Color.red);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    depositErrors.setText("Enter amount:");
                    depositErrors.setForeground(Color.lightGray);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.maxAmountForDeposite(depositSet) == 1)
                {
                    depositErrors.setText("Enter amount:Max amount is 5000$");
                    depositErrors.setForeground(Color.red);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    depositErrors.setText("Enter amount:");
                    depositErrors.setForeground(Color.lightGray);
                    depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                double depositAmount = Double.parseDouble(depositSet);
                moneyBalance += depositAmount;

                // Update the displayed balance
                amountMoney.setText("Balance: $" + String.format(Locale.US, "%.2f", moneyBalance));

                depositErrors.setText("Enter amount:Transaction was completed");
                depositErrors.setForeground(Color.green);
                depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.green, 1));

            }
    }
}