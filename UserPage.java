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
    ImageIcon imageIcon3 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/payments.png")));
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
        withdrawalAmountExchange.setBounds(240,150,150,20);
        withdrawalAmountExchange.setFont(new Font("Arial", Font.BOLD, 16));
        withdrawalAmountExchange.setForeground(Color.lightGray);
        withdrawalAmountExchange.setVisible(false);

        exchangeRate.setText("Exchange Rate");
        exchangeRate.setBounds(240,207,140,30);
        exchangeRate.setFont(new Font("Arial", Font.BOLD, 16));
        exchangeRate.setForeground(Color.lightGray);
        exchangeRate.setVisible(false);

        accountChargOnExchange.setText("Account Charge");
        accountChargOnExchange.setBounds(240,267,150,30);
        accountChargOnExchange.setFont(new Font("Arial", Font.BOLD, 16));
        accountChargOnExchange.setForeground(Color.lightGray);
        accountChargOnExchange.setVisible(false);

        withdrawalAmountTextFiled.setBounds(460, 140, 250, 50);
        withdrawalAmountTextFiled.setBackground(new Color(12, 12, 12));
        withdrawalAmountTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        withdrawalAmountTextFiled.setForeground(new Color(195, 195, 195));
        withdrawalAmountTextFiled.setCaretColor(new Color(195, 195, 195));
        withdrawalAmountTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        withdrawalAmountTextFiled.setVisible(false);

        exchangeRateTextFiled.setBounds(460, 200, 250, 50);
        exchangeRateTextFiled.setBackground(new Color(12, 12, 12));
        exchangeRateTextFiled.setFont(new Font("Arial", Font.PLAIN, 16));
        exchangeRateTextFiled.setForeground(new Color(195, 195, 195));
        exchangeRateTextFiled.setCaretColor(new Color(195, 195, 195));
        exchangeRateTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        exchangeRateTextFiled.setEditable(false);
        exchangeRateTextFiled.setVisible(false);

        accountChargeTextFiled.setBounds(460, 260, 250, 50);
        accountChargeTextFiled.setBackground(new Color(12, 12, 12));
        accountChargeTextFiled.setFont(new Font("Arial", Font.PLAIN, 20));
        accountChargeTextFiled.setForeground(new Color(195, 195, 195));
        accountChargeTextFiled.setCaretColor(new Color(195, 195, 195));
        accountChargeTextFiled.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        accountChargeTextFiled.setEditable(false);
        accountChargeTextFiled.setVisible(false);

        chargAmountError.setText("Enter amount:");
        chargAmountError.setBounds(460,120,300,20);
        chargAmountError.setFont(new Font("Arial", Font.BOLD, 13));
        chargAmountError.setForeground(Color.lightGray);
        chargAmountError.setVisible(false);


        exchangeGoBackButton.setBounds(610,330,100,50);
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

        takeMoneyFromExchange.setBounds(500,330,100,50);
        takeMoneyFromExchange.setFocusable(false);
        takeMoneyFromExchange.addActionListener(this);
        takeMoneyFromExchange.setBackground(new Color(12, 12, 12));
        takeMoneyFromExchange.setFont(new Font("Arial", Font.BOLD, 16));
        takeMoneyFromExchange.setForeground(new Color(195,42,109));
        takeMoneyFromExchange.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        takeMoneyFromExchange.setVisible(false);

        //-------------------------------------------------------------------------------------------EXCHANGE AMOUNT END

        //------------------------------------------------------------------------------------------WITHDRAW MONEY START
        inwithdrawButton.setBounds(400,230,100,50);
        inwithdrawButton.setFocusable(false);
        inwithdrawButton.addActionListener(this);
        inwithdrawButton.setBackground(new Color(12, 12, 12));
        inwithdrawButton.setFont(new Font("Arial", Font.BOLD, 16));
        inwithdrawButton.setForeground(new Color(195,42,109));
        inwithdrawButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        inwithdrawButton.setVisible(false);

        pleasePutWithdrawMoney.setText("Enter the withdrawal amount");
        pleasePutWithdrawMoney.setBounds(325,100,300,30);
        pleasePutWithdrawMoney.setFont(new Font("Arial", Font.BOLD, 20));
        pleasePutWithdrawMoney.setForeground(Color.lightGray);
        pleasePutWithdrawMoney.setVisible(false);

        withdrawErrors.setText("Enter amount:");
        withdrawErrors.setBounds(300,145,300,20);
        withdrawErrors.setFont(new Font("Arial", Font.BOLD, 14));
        withdrawErrors.setForeground(Color.lightGray);
        withdrawErrors.setVisible(false);

        withdrawMoenyInput.setBounds(300, 165, 300, 50);
        withdrawMoenyInput.setBackground(new Color(12, 12, 12));
        withdrawMoenyInput.setFont(new Font("Arial", Font.PLAIN, 20));
        withdrawMoenyInput.setForeground(new Color(195, 195, 195));
        withdrawMoenyInput.setCaretColor(new Color(195, 195, 195));
        withdrawMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        withdrawMoenyInput.setVisible(false);
        //---------------------------------------------------------------------------------------WITHDRAW MONEY MENU END

        //-------------------------------------------------------------------------------------DEPOSITE MONEY MENU STATR
        inDepositButton.setBounds(400,230,100,50);
        inDepositButton.setFocusable(false);
        inDepositButton.addActionListener(this);
        inDepositButton.setBackground(new Color(12, 12, 12));
        inDepositButton.setFont(new Font("Arial", Font.BOLD, 16));
        inDepositButton.setForeground(new Color(195,42,109));
        inDepositButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        inDepositButton.setVisible(false);

        pleasePutDepositeMoney.setText("Enter the deposit amount");
        pleasePutDepositeMoney.setBounds(325,100,300,30);
        pleasePutDepositeMoney.setFont(new Font("Arial", Font.BOLD, 20));
        pleasePutDepositeMoney.setForeground(Color.lightGray);
        pleasePutDepositeMoney.setVisible(false);

        depositErrors.setText("Enter amount:");
        depositErrors.setBounds(300,145,300,20);
        depositErrors.setFont(new Font("Arial", Font.BOLD, 14));
        depositErrors.setForeground(Color.lightGray);
        depositErrors.setVisible(false);

        depositeMoenyInput.setBounds(300, 165, 300, 50);
        depositeMoenyInput.setBackground(new Color(12, 12, 12));
        depositeMoenyInput.setFont(new Font("Arial", Font.PLAIN, 20));
        depositeMoenyInput.setForeground(new Color(195, 195, 195));
        depositeMoenyInput.setCaretColor(new Color(195, 195, 195));
        depositeMoenyInput.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        depositeMoenyInput.setVisible(false);
        //---------------------------------------------------------------------------------------DEPOSITE MONEY MENU END


        //---------------------------------------------------------------------------------------ATM MENU ELEMENTS START
        amountMoney.setText("Balance: $"+moneyBalance);
        amountMoney.setBounds(10,80,180,20);
        amountMoney.setFont(new Font("Arial", Font.BOLD, 16));
        amountMoney.setForeground(Color.lightGray);
        amountMoney.setVisible(false);

        // Scale the image to the desired size
        Image image3 = imageIcon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        paymentImage.setIcon(new ImageIcon(image3));
        paymentImage.setBounds(635, 123, 100, 100);
        paymentImage.setVisible(false);

        hiUserName.setBounds(10,60,100,20);
        hiUserName.setFont(new Font("Arial", Font.BOLD, 16));
        hiUserName.setForeground(Color.lightGray);
        hiUserName.setVisible(false);

        useService.setText("Please select a service");
        useService.setBounds(320,100,500,50);
        useService.setFont(new Font("Arial", Font.BOLD, 24));
        useService.setForeground(Color.lightGray);
        useService.setVisible(false);

        exchangeMoney.setBounds(460, 180, 170, 50);
        exchangeMoney.setFocusable(false);
        exchangeMoney.addActionListener(epxr ->{//show exchatnge button elements
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

        withdrawMoney.setBounds(270, 270, 170, 50);
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

        depositMoney.setBounds(270, 180, 170, 50);
        depositMoney.setFocusable(false);
        depositMoney.addActionListener(expr -> { //show deposit button elements
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

        exit.setBounds(460, 270, 170, 50);
        exit.setFocusable(false);
        exit.addActionListener(exp->{//exit from account
            homeWindow.loginButton.setVisible(true);
            homeWindow.registerButton.setVisible(true);
            homeWindow.mainWindowSText.setVisible(true);
            homeWindow.mainWindowFText.setVisible(true);
            homeWindow.userNameText.setVisible(true);
            homeWindow.passwordText.setVisible(true);
            homeWindow.atmImage.setVisible(true);
            homeWindow.mainWindowFText.setText("");
            homeWindow.mainWindowSText.setText("");
            enterPin.setText("");
            amountMoney.setText("Balance: $"+0.00);


            depositMoney.setVisible(false);
            exchangeMoney.setVisible(false);
            withdrawMoney.setVisible(false);
            paymentImage.setVisible(false);
            exit.setVisible(false);
            amountMoney.setVisible(false);
            hiUserName.setVisible(false);
            useService.setVisible(false);
        });
        exit.setBackground(new Color(12, 12, 12));
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setForeground(new Color(195, 42, 109));
        exit.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        exit.setVisible(false);

        //-----------------------------------------------------------------------------------------ATM MENU ELEMENTS END

        welCome.setText("Your card is in the ATM machine, please enter the PIN");
        welCome.setBounds(142,80,700,50);
        welCome.setFont(new Font("Arial", Font.BOLD, 24));
        welCome.setForeground(Color.lightGray);

        enterPin.setBounds(300, 165, 300, 50);
        enterPin.setBackground(new Color(12, 12, 12));
        enterPin.setFont(new Font("Arial", Font.PLAIN, 20));
        enterPin.setForeground(new Color(195, 195, 195));
        enterPin.setCaretColor(new Color(195, 195, 195));
        enterPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        enterPinText.setText("Enter pin:");
        enterPinText.setBounds(300,140,300,30);
        enterPinText.setFont(new Font("Arial", Font.BOLD, 14));
        enterPinText.setForeground(Color.lightGray);

        submitPin.setBounds(402,230,100,50);
        submitPin.setFocusable(false);
        submitPin.addActionListener(this);
        submitPin.setBackground(new Color(12, 12, 12));
        submitPin.setFont(new Font("Arial", Font.BOLD, 16));
        submitPin.setForeground(new Color(195,42,109));
        submitPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        longOut.setBounds(402,290,100,50);
        longOut.setFocusable(false);
        longOut.addActionListener(exp->{//long out from ping page
            enterPin.setVisible(false);
            submitPin.setVisible(false);
            longOut.setVisible(false);
            welCome.setVisible(false);
            enterPinText.setVisible(false);

            homeWindow.loginButton.setVisible(true);
            homeWindow.registerButton.setVisible(true);
            homeWindow.mainWindowSText.setVisible(true);
            homeWindow.mainWindowFText.setVisible(true);
            homeWindow.userNameText.setVisible(true);
            homeWindow.passwordText.setVisible(true);
            homeWindow.atmImage.setVisible(true);
            homeWindow.mainWindowFText.setText("");
            homeWindow.mainWindowSText.setText("");
            enterPin.setText("");
        });
        longOut.setBackground(new Color(12, 12, 12));
        longOut.setFont(new Font("Arial", Font.BOLD, 16));
        longOut.setForeground(new Color(195,42,109));
        longOut.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //-----------------------------------------------------------Go back from all service Button start (no exchange)
        goBackFromAllService.setBounds(400,290,100,50);
        goBackFromAllService.setFocusable(false);
        goBackFromAllService.addActionListener(expr -> {//LAMMBDA FOR SHARED GO BACK BUTTON FOR ALL SERVICESIN (no exchange)
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
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

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
    //getUSerNameFromHomeWindow
    public void updateUserName() {
        String takeUserName = homeWindow.mainWindowFText.getText();
        hiUserName.setText("Hi,"+takeUserName);
    }
}