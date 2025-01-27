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
    JButton exchangeMoney = new JButton("Exchange");
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
    //WIDTHDRAW MONEY
    JButton inwithdrawButton = new JButton("Take Money");
    JLabel pleasePutWithdrawMoney = new JLabel();
    JTextField withdrawMoenyInput = new JTextField();
    JLabel withdrawErrors = new JLabel();
    //in exchange
    JLabel withdrawalAmountExchange = new JLabel();
    JLabel exchangeRate = new JLabel();
    JLabel accountChargOnExchange = new JLabel();
    JTextField withdrawalAmountTextFiled = new JTextField();
    JTextField exchangeRateTextFiled = new JTextField("EUR = $5000 × 0.92 = 4600EUR");
    JTextField accountChargeTextFiled = new JTextField();
    JButton exchangeGoBackButton = new JButton("Go Back");
    JLabel chargAmountError = new JLabel();
    JButton takeMoneyFromExchange = new JButton("Take");


    UserPage(HomeWindow homeWindow)
    {
        this.homeWindow = homeWindow;

        //-----------------------------------------------------------------------------------------EXCHANGE AMOUNT START
        withdrawalAmountExchange.setText("Withdrawal Amount");
        withdrawalAmountExchange.setBounds(200,100,150,20);
        withdrawalAmountExchange.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawalAmountExchange.setForeground(Color.lightGray);
        withdrawalAmountExchange.setVisible(false);

        exchangeRate.setText("Exchange Rate");
        exchangeRate.setBounds(200,157,140,30);
        exchangeRate.setFont(new Font("Arial", Font.BOLD, 16));
        exchangeRate.setForeground(Color.lightGray);
        exchangeRate.setVisible(false);

        accountChargOnExchange.setText("Account Charge");
        accountChargOnExchange.setBounds(200,217,150,30);
        accountChargOnExchange.setFont(new Font("Arial", Font.BOLD, 16));
        accountChargOnExchange.setForeground(Color.lightGray);
        accountChargOnExchange.setVisible(false);

        withdrawalAmountTextFiled.setBounds(420, 90, 250, 50);
        withdrawalAmountTextFiled.setBackground(new Color(12, 12, 12));
        withdrawalAmountTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        withdrawalAmountTextFiled.setForeground(new Color(195, 195, 195));
        withdrawalAmountTextFiled.setCaretColor(new Color(195, 195, 195));
        withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        withdrawalAmountTextFiled.setVisible(false);

        exchangeRateTextFiled.setBounds(420, 150, 250, 50);
        exchangeRateTextFiled.setBackground(new Color(12, 12, 12));
        exchangeRateTextFiled.setFont(new Font("Arial", Font.PLAIN, 16));
        exchangeRateTextFiled.setForeground(new Color(195, 195, 195));
        exchangeRateTextFiled.setCaretColor(new Color(195, 195, 195));
        exchangeRateTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        exchangeRateTextFiled.setEditable(false);
        exchangeRateTextFiled.setVisible(false);

        accountChargeTextFiled.setBounds(420, 210, 250, 50);
        accountChargeTextFiled.setBackground(new Color(12, 12, 12));
        accountChargeTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        accountChargeTextFiled.setForeground(new Color(195, 195, 195));
        accountChargeTextFiled.setCaretColor(new Color(195, 195, 195));
        accountChargeTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        accountChargeTextFiled.setEditable(false);
        accountChargeTextFiled.setVisible(false);

        chargAmountError.setText("Enter amount:");
        chargAmountError.setBounds(420,70,300,20);
        chargAmountError.setFont(new Font("Arial", Font.BOLD, 13));
        chargAmountError.setForeground(Color.lightGray);
        chargAmountError.setVisible(false);


        exchangeGoBackButton.setBounds(570,300,100,50);
        exchangeGoBackButton.setFocusable(false);
        exchangeGoBackButton.addActionListener(expr -> {//LAMMBDA FOR exchange go back service
            withdrawalAmountExchange.setVisible(false);
            accountChargOnExchange.setVisible(false);
            exchangeRate.setVisible(false);
            withdrawalAmountTextFiled.setVisible(false);
            exchangeRateTextFiled.setVisible(false);
            accountChargeTextFiled.setVisible(false);
            exchangeGoBackButton.setVisible(false);
            chargAmountError.setVisible(false);
            takeMoneyFromExchange.setVisible(false);

            depositMoney.setVisible(true);
            exit.setVisible(true);
            exchangeMoney.setVisible(true);
            withdrawMoney.setVisible(true);
            useService.setVisible(true);
            paymentImage.setVisible(true);

            chargAmountError.setText("Enter amount:");
            chargAmountError.setForeground(Color.lightGray);
            withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            withdrawalAmountTextFiled.setText("");
            accountChargeTextFiled.setText("");
        });
        exchangeGoBackButton.setBackground(new Color(12, 12, 12));
        exchangeGoBackButton.setFont(new Font("Arial", Font.BOLD, 16));
        exchangeGoBackButton.setForeground(new Color(195,42,109));
        exchangeGoBackButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        exchangeGoBackButton.setVisible(false);

        takeMoneyFromExchange.setBounds(460,300,100,50);
        takeMoneyFromExchange.setFocusable(false);
        takeMoneyFromExchange.addActionListener(this);
        takeMoneyFromExchange.setBackground(new Color(12, 12, 12));
        takeMoneyFromExchange.setFont(new Font("Arial", Font.BOLD, 16));
        takeMoneyFromExchange.setForeground(new Color(195,42,109));
        takeMoneyFromExchange.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        takeMoneyFromExchange.setVisible(false);

        //-------------------------------------------------------------------------------------------EXCHANGE AMOUNT END

        //------------------------------------------------------------------------------------------WITHDRAW MONEY START
        inwithdrawButton.setBounds(390,190,100,50);
        inwithdrawButton.setFocusable(false);
        inwithdrawButton.addActionListener(this);
        inwithdrawButton.setBackground(new Color(12, 12, 12));
        inwithdrawButton.setFont(new Font("Arial", Font.BOLD, 16));
        inwithdrawButton.setForeground(new Color(195,42,109));
        inwithdrawButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        inwithdrawButton.setVisible(false);

        pleasePutWithdrawMoney.setText("Enter the withdrawal amount");
        pleasePutWithdrawMoney.setBounds(315,65,300,30);
        pleasePutWithdrawMoney.setFont(new Font("Arial", Font.BOLD, 20));
        pleasePutWithdrawMoney.setForeground(Color.lightGray);
        pleasePutWithdrawMoney.setVisible(false);

        withdrawErrors.setText("Enter amount:");
        withdrawErrors.setBounds(290,110,300,20);
        withdrawErrors.setFont(new Font("Arial", Font.BOLD, 14));
        withdrawErrors.setForeground(Color.lightGray);
        withdrawErrors.setVisible(false);

        withdrawMoenyInput.setBounds(290, 130, 300, 50);
        withdrawMoenyInput.setBackground(new Color(12, 12, 12));
        withdrawMoenyInput.setFont(new Font("Arial", Font.PLAIN, 20));
        withdrawMoenyInput.setForeground(new Color(195, 195, 195));
        withdrawMoenyInput.setCaretColor(new Color(195, 195, 195));
        withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        withdrawMoenyInput.setVisible(false);
        //---------------------------------------------------------------------------------------WITHDRAW MONEY MENU END

        //-------------------------------------------------------------------------------------DEPOSITE MONEY MENU STATR
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
        //---------------------------------------------------------------------------------------DEPOSITE MONEY MENU END


        //---------------------------------------------------------------------------------------ATM MENU ELEMENTS START
        amountMoney.setText("Balance: $"+moneyBalance);
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

        exchangeMoney.setBounds(440, 150, 170, 50);
        exchangeMoney.setFocusable(false);
        exchangeMoney.addActionListener(epxr ->{
            depositMoney.setVisible(false);
            exit.setVisible(false);
            exchangeMoney.setVisible(false);
            withdrawMoney.setVisible(false);
            useService.setVisible(false);
            paymentImage.setVisible(false);

            withdrawalAmountExchange.setVisible(true);
            chargAmountError.setVisible(true);
            accountChargOnExchange.setVisible(true);
            exchangeRate.setVisible(true);
            withdrawalAmountTextFiled.setVisible(true);
            exchangeRateTextFiled.setVisible(true);
            accountChargeTextFiled.setVisible(true);
            takeMoneyFromExchange.setVisible(true);
            exchangeGoBackButton.setVisible(true);
        });
        exchangeMoney.setBackground(new Color(12, 12, 12));
        exchangeMoney.setFont(new Font("Arial", Font.BOLD, 16));
        exchangeMoney.setForeground(new Color(195, 42, 109));
        exchangeMoney.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        exchangeMoney.setVisible(false);

        withdrawMoney.setBounds(250, 240, 170, 50);
        withdrawMoney.setFocusable(false);
        withdrawMoney.addActionListener(expr -> { //lambda for setVisible elements
            depositMoney.setVisible(false);
            exit.setVisible(false);
            exchangeMoney.setVisible(false);
            withdrawMoney.setVisible(false);
            useService.setVisible(false);
            paymentImage.setVisible(false);

            pleasePutWithdrawMoney.setVisible(true);
            inwithdrawButton.setVisible(true);
            withdrawErrors.setVisible(true);
            withdrawMoenyInput.setVisible(true);
            goBackFromAllService.setVisible(true);
        });
        withdrawMoney.setBackground(new Color(12, 12, 12));
        withdrawMoney.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawMoney.setForeground(new Color(195, 42, 109));
        withdrawMoney.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        withdrawMoney.setVisible(false);

        depositMoney.setBounds(250, 150, 170, 50);
        depositMoney.setFocusable(false);
        depositMoney.addActionListener(expr -> { //lambda for setVisible elements
            depositMoney.setVisible(false);
            exit.setVisible(false);
            exchangeMoney.setVisible(false);
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

        //-----------------------------------------------------------------------------------------ATM MENU ELEMENTS END

        enterPin.setBounds(290, 110, 300, 50);
        enterPin.setBackground(new Color(12, 12, 12));
        enterPin.setFont(new Font("Arial", Font.PLAIN, 20));
        enterPin.setForeground(new Color(195, 195, 195));
        enterPin.setCaretColor(new Color(195, 195, 195));
        enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        submitPin.setBounds(390,180,100,50);
        submitPin.setFocusable(false);
        submitPin.addActionListener(this);
        submitPin.setBackground(new Color(12, 12, 12));
        submitPin.setFont(new Font("Arial", Font.BOLD, 16));
        submitPin.setForeground(new Color(195,42,109));
        submitPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        longOut.setBounds(390,240,100,50);
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

        //-----------------------------------------------------------Go back from all service Button start (no exchange)
        goBackFromAllService.setBounds(390,245,100,50);
        goBackFromAllService.setFocusable(false);
        goBackFromAllService.addActionListener(expr -> {//LAMMBDA FOR SHARED GO BACK BUTTON FOR ALL SERVICESIN
            pleasePutDepositeMoney.setVisible(false);
            inDepositButton.setVisible(false);
            depositeMoenyInput.setVisible(false);
            depositErrors.setVisible(false);
            goBackFromAllService.setVisible(false);
            pleasePutWithdrawMoney.setVisible(false);
            inwithdrawButton.setVisible(false);
            withdrawErrors.setVisible(false);
            withdrawMoenyInput.setVisible(false);
            withdrawalAmountExchange.setVisible(false);
            accountChargOnExchange.setVisible(false);
            exchangeRate.setVisible(false);
            withdrawalAmountTextFiled.setVisible(false);
            exchangeRateTextFiled.setVisible(false);
            accountChargeTextFiled.setVisible(false);

            depositMoney.setVisible(true);
            exit.setVisible(true);
            exchangeMoney.setVisible(true);
            withdrawMoney.setVisible(true);
            useService.setVisible(true);
            paymentImage.setVisible(true);

            chargAmountError.setText("Enter amount:");
            chargAmountError.setForeground(Color.lightGray);
            withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            withdrawalAmountTextFiled.setText("");

            withdrawErrors.setText("Enter amount:");
            withdrawErrors.setForeground(Color.lightGray);
            withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
            withdrawMoenyInput.setText("");

            depositErrors.setText("Enter amount:");
            depositErrors.setForeground(Color.lightGray);
            depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            depositeMoenyInput.setText("");
        });
        goBackFromAllService.setBackground(new Color(12, 12, 12));
        goBackFromAllService.setFont(new Font("Arial", Font.BOLD, 16));
        goBackFromAllService.setForeground(new Color(195,42,109));
        goBackFromAllService.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        goBackFromAllService.setVisible(false);

        //-------------------------------------------------------------Go back from all service Button END (no exchange)

        //-------------------------------------------------------------------------------add elements on userPanel START
        //exchange money
        userPanel.add(withdrawalAmountExchange);
        userPanel.add(accountChargOnExchange);
        userPanel.add(exchangeRate);
        userPanel.add(withdrawalAmountTextFiled);
        userPanel.add(exchangeRateTextFiled);
        userPanel.add(accountChargeTextFiled);
        userPanel.add(exchangeGoBackButton);
        userPanel.add(chargAmountError);
        userPanel.add(takeMoneyFromExchange);
        //widthdraw money
        userPanel.add(pleasePutWithdrawMoney);
        userPanel.add(inwithdrawButton);
        userPanel.add(withdrawMoenyInput);
        userPanel.add(withdrawErrors);
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
        userPanel.add(exchangeMoney);
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
        //---------------------------------------------------------------------------------add elements on userPanel END
    }

    //method to get userpanel in enother window
    public JPanel getPanel()
    {
        return userPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //---------------------------------------------------------------------- long out from entering pin window START
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
            //---------------------------------------------------------------------long out from entering pin window END

            //----------------------------------------------------------pincode validations and search in database START
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

                //-----------------------------------------------if user enters correct pin than go in atm menu . start.

                enterPin.setVisible(false);
                longOut.setVisible(false);
                submitPin.setVisible(false);
                welCome.setVisible(false);
                enterPinText.setVisible(false);

                depositMoney.setVisible(true);
                exit.setVisible(true);
                exchangeMoney.setVisible(true);
                withdrawMoney.setVisible(true);
                useService.setVisible(true);
                hiUserName.setVisible(true);
                paymentImage.setVisible(true);
                amountMoney.setVisible(true);

                //-------------------------------------------------if user enters correct pin than go in atm menu . END.
            }
            //------------------------------------------------------------pincode validations and search in database END

            //--------------------------------------------------------------------go to main window on exit button START
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
            //----------------------------------------------------------------------go to main window on exit button END

            //----------------------------------------------------------------------------events in deposit button START
            if(e.getSource() == inDepositButton)
            {
                //take user input drom deposit textfield
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

                if(ValidationClass.forbidFirstNumZero(depositSet) == 1)
                {
                    depositErrors.setText("Enter amount:First number is zero");
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

                //add deposit amount to balance
                double depositAmount = Double.parseDouble(depositSet);
                moneyBalance += depositAmount;

                // Update the displayed balance
                amountMoney.setText("Balance: $" + String.format(Locale.US, "%.2f", moneyBalance));

                depositErrors.setText("Enter amount:Transaction was completed");
                depositErrors.setForeground(Color.green);
                depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.green, 1));

            }
            //------------------------------------------------------------------------------events in deposit button END

            //--------------------------------------------------------------------------enets in withdrawal button START
            if(e.getSource() == inwithdrawButton)
            {
                //take user input from textField
                String withdrawSet = withdrawMoenyInput.getText();

                //validations on input
                if(ValidationClass.emptyInput(withdrawSet) == 1)
                {
                    withdrawErrors.setText("Enter amount:Empty input");
                    withdrawErrors.setForeground(Color.red);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    withdrawErrors.setText("Enter amount:");
                    withdrawErrors.setForeground(Color.lightGray);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.forbidSpace(withdrawSet) == 1)
                {
                    withdrawErrors.setText("Enter amount:Space detected");
                    withdrawErrors.setForeground(Color.red);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    withdrawErrors.setText("Enter amount:");
                    withdrawErrors.setForeground(Color.lightGray);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(!ValidationClass.containsOnlyNumbers(withdrawSet))
                {
                    withdrawErrors.setText("Enter amount:Enter only number");
                    withdrawErrors.setForeground(Color.red);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    withdrawErrors.setText("Enter amount:");
                    withdrawErrors.setForeground(Color.lightGray);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.depositAmountMaxNumber(withdrawSet) == 1)
                {
                    withdrawErrors.setText("Enter amount:To many digit");
                    withdrawErrors.setForeground(Color.red);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    withdrawErrors.setText("Enter amount:");
                    withdrawErrors.setForeground(Color.lightGray);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.maxAmountForDeposite(withdrawSet) == 1)
                {
                    withdrawErrors.setText("Enter amount:Max amount is 5000$");
                    withdrawErrors.setForeground(Color.red);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    withdrawErrors.setText("Enter amount:");
                    withdrawErrors.setForeground(Color.lightGray);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.forbidFirstNumZero(withdrawSet) == 1)
                {
                    withdrawErrors.setText("Enter amount:First number is zero");
                    withdrawErrors.setForeground(Color.red);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    withdrawErrors.setText("Enter amount:");
                    withdrawErrors.setForeground(Color.lightGray);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                //calculate if balance is less that witdrawal amount than shoot error
                double withdrawAmount = Double.parseDouble(withdrawSet);
                if(moneyBalance<withdrawAmount)
                {
                    withdrawErrors.setText("Enter amount:Insufficient amount");
                    withdrawErrors.setForeground(Color.red);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    moneyBalance -= withdrawAmount;
                    withdrawErrors.setText("Enter amount:");
                    withdrawErrors.setForeground(Color.lightGray);
                    withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                // Update the displayed balance
                amountMoney.setText("Balance: $" + String.format(Locale.US, "%.2f", moneyBalance));

                withdrawErrors.setText("Enter amount:Transaction was completed");
                withdrawErrors.setForeground(Color.green);
                withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.green, 1));
            }
            //---------------------------------------------------------------------------events in withdrawal button END

            //---------------------------------------------------------------------------events in exchange button START
            if(e.getSource() == takeMoneyFromExchange)
            {
                //take user input from textField
                String exchangeWithdrowalSet = withdrawalAmountTextFiled.getText();

                if(ValidationClass.emptyInput(exchangeWithdrowalSet) == 1)
                {
                    chargAmountError.setText("Enter amount:Empty input");
                    chargAmountError.setForeground(Color.red);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    chargAmountError.setText("Enter amount:");
                    chargAmountError.setForeground(Color.lightGray);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.forbidSpace(exchangeWithdrowalSet) == 1)
                {
                    chargAmountError.setText("Enter amount:Space detected");
                    chargAmountError.setForeground(Color.red);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    chargAmountError.setText("Enter amount:");
                    chargAmountError.setForeground(Color.lightGray);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(!ValidationClass.containsOnlyNumbers(exchangeWithdrowalSet))
                {
                    chargAmountError.setText("Enter amount:Enter only number");
                    chargAmountError.setForeground(Color.red);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    chargAmountError.setText("Enter amount:");
                    chargAmountError.setForeground(Color.lightGray);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.depositAmountMaxNumber(exchangeWithdrowalSet) == 1)
                {
                    chargAmountError.setText("Enter amount:To many digit");
                    chargAmountError.setForeground(Color.red);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    chargAmountError.setText("Enter amount:");
                    chargAmountError.setForeground(Color.lightGray);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.maxAmountForDeposite(exchangeWithdrowalSet) == 1)
                {
                    chargAmountError.setText("Enter amount:Max amount is 5000$");
                    chargAmountError.setForeground(Color.red);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    chargAmountError.setText("Enter amount:");
                    chargAmountError.setForeground(Color.lightGray);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                if(ValidationClass.forbidFirstNumZero(exchangeWithdrowalSet) == 1)
                {
                    chargAmountError.setText("Enter amount:First number is zero");
                    chargAmountError.setForeground(Color.red);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    chargAmountError.setText("Enter amount:");
                    chargAmountError.setForeground(Color.lightGray);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                }

                double withdrawAmountExchange = Double.parseDouble(exchangeWithdrowalSet);
                if(moneyBalance<withdrawAmountExchange)
                {
                    chargAmountError.setText("Enter amount:Insufficient amount");
                    chargAmountError.setForeground(Color.red);
                    withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    return;
                }
                else
                {
                    double calculatedCharg =  withdrawAmountExchange / 0.92;
                    if(moneyBalance < calculatedCharg)
                    {
                        chargAmountError.setText("Enter amount:Insufficient amount");
                        chargAmountError.setForeground(Color.red);
                        withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                        return;
                    }
                    else {
                        accountChargeTextFiled.setText("$" + String.format(Locale.US, "%.2f", calculatedCharg));
                        moneyBalance -= calculatedCharg;
                        chargAmountError.setText("Enter amount:Transaction completed");
                        amountMoney.setText("Balance: $" + String.format(Locale.US, "%.2f", moneyBalance));
                        chargAmountError.setForeground(Color.green);
                        withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.green, 1));
                    }
                }
            }
        //---------------------------------------------------------------------------------events in exchange button END
    }
}