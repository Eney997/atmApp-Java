import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //events table
        // Create mainJFrame
        JFrame appFrame = new JFrame();
        //buttons for mainJFRAME
        JButton exitButton = new JButton("X");
        JButton minimizeButton = new JButton("_");
        //framesfor mainJFRAME
        JLabel appTopFrame = new JLabel();
        JLabel appBottomFrame = new JLabel();
        JPanel appleftFrame = new JPanel();
        JPanel appRightFrame = new JPanel();
        //makeing visible homeWindow,greetingWindow registrationWindow and userWindow
        HomeWindow homeWindow = new HomeWindow();
        GreetingPage greetingPage = new GreetingPage(homeWindow);
        RegistrationPage registrationPage = new RegistrationPage(homeWindow,greetingPage);
        UserPage userPage = new UserPage(homeWindow);

        //main JFRANE elements ,minimize maximize buttons,app colorfull frames and app movement

        //---------------------------------------------------------------------------------------IMAGES AND FRAMES START

        //------------------------------------------------topFrame address
        ImageIcon imageIcon1 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/topBorder.bmp")));
        // Scale the image to the desired size
        Image image = imageIcon1.getImage().getScaledInstance(900, 7, Image.SCALE_SMOOTH);
        appTopFrame = new JLabel();
        //makeing cp image sizes
        appTopFrame.setIcon(new ImageIcon(image));
        appTopFrame.setBounds(0, 0, 900, 7);

        //------------------------------------------------bottomFrame address
        ImageIcon imageIcon2 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/bottomBorder.bmp")));
        // Scale the image to the desired size
        Image image2 = imageIcon2.getImage().getScaledInstance(901, 7, Image.SCALE_SMOOTH);
        appBottomFrame = new JLabel();
        //makeing cp image sizes
        appBottomFrame.setIcon(new ImageIcon(image2));
        appBottomFrame.setBounds(-1, 493, 901, 7);

        //------------------------------------------------leftFrame
        appleftFrame.setLayout(null);
        appleftFrame.setBounds(0, 0, 1, 500);
        appleftFrame.setBackground(new Color(70,127,161));

        //------------------------------------------------rightFrame
        appRightFrame.setLayout(null);
        appRightFrame.setBounds(899, 0, 1, 500);
        appRightFrame.setBackground(new Color(70,127,161));

        //--------------------------------------creating line for top
        JPanel linePanel = new JPanel();
        linePanel.setLayout(null);
        linePanel.setBounds(9, 50, 882, 1);
        linePanel.setBackground(new Color(70,127,161));

        //-----------------------------------------------------------------------------------------IMAGES AND FRAMES END

        //-------------------------------------------------------------------MINIMIZE AND MAXIMIZE BUTTON ELEMENTS START
        //minimize button
        minimizeButton.setBounds(780, 7, 45, 35);
        minimizeButton.setFocusable(false);
        minimizeButton.addActionListener(exp->{
            appFrame.setState(JFrame.ICONIFIED);
        });
        minimizeButton.setBackground(new Color(12, 12, 12));
        minimizeButton.setFont(new Font("Arial", Font.BOLD, 16));
        minimizeButton.setForeground(new Color(250,50, 97));
        minimizeButton.setBorder(BorderFactory.createLineBorder(new Color(195,195,195), 1));

        //exitbutton
        exitButton.setBounds(830, 7, 45, 35);
        exitButton.setFocusable(false);
        exitButton.addActionListener(exp->{
            System.exit(0);
        });
        exitButton.setBackground(new Color(12, 12, 12));
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setForeground(new Color(250,50, 97));
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(195,195,195), 1));

        //---------------------------------------------------------------------MINIMIZE AND MAXIMIZE BUTTON ELEMENTS END

        //---------------------------------------------------------------------------------------------- APP MOVE  START
        final int[] mouseX = {0};
        final int[] mouseY = {0};

        appFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Capture initial mouse position
                mouseX[0] = e.getX();
                mouseY[0] = e.getY();
            }
        });
        //mousemovement - appMove
        appFrame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Check if dragging is within the top 50 pixels
                if (mouseY[0] <= 50) {
                    // Calculate new frame position
                    int x = appFrame.getX() + e.getX() - mouseX[0];
                    int y = appFrame.getY() + e.getY() - mouseY[0];
                    appFrame.setLocation(x, y);
                }
            }
        });

        //------------------------------------------------------------------------------------------------- APP MOVE END

        //----------------------------------------CREATING STYLES MAIN JFRAME AND ADDING DIFFERENT WINDOW ELEMENTS START

        //makeing registration window elements invisible to make visible on clickEvents
        registrationPage.digitNumText.setVisible(false);
        registrationPage.pinText.setVisible(false);
        registrationPage.cardDigits.setVisible(false);
        registrationPage.cardPin.setVisible(false);
        registrationPage.expMonthText.setVisible(false);
        registrationPage.expYearText.setVisible(false);
        registrationPage.expMonth.setVisible(false);
        registrationPage.expYear.setVisible(false);
        registrationPage.cvvCvcText.setVisible(false);
        registrationPage.cvvCvc.setVisible(false);
        registrationPage.password.setVisible(false);
        registrationPage.passwordText.setVisible(false);
        registrationPage.userNameText.setVisible(false);
        registrationPage.userName.setVisible(false);
        registrationPage.lastName.setVisible(false);
        registrationPage.lastNameText.setVisible(false);
        registrationPage.nameText.setVisible(false);
        registrationPage.name.setVisible(false);
        registrationPage.goBakcButton.setVisible(false);
        registrationPage.submitButton.setVisible(false);
        //makeing greeting window elements invisible to make visible on clickEvents
        greetingPage.greetingText.setVisible(false);
        greetingPage.mainMenuButton.setVisible(false);
        greetingPage.imageLable.setVisible(false);
        //makeing user window elements invisible to make visible on clickEvents
        userPage.withdrawalAmountExchange.setVisible(false);
        userPage.exchangeRate.setVisible(false);
        userPage.accountChargOnExchange.setVisible(false);
        userPage.exchangeRateTextFiled.setVisible(false);
        userPage.accountChargeTextFiled.setVisible(false);
        userPage.chargAmountError.setVisible(false);
        userPage.exchangeGoBackButton.setVisible(false);
        userPage.takeMoneyFromExchange.setVisible(false);
        userPage.inwithdrawButton.setVisible(false);
        userPage.pleasePutWithdrawMoney.setVisible(false);
        userPage.withdrawErrors.setVisible(false);
        userPage.withdrawMoenyInput.setVisible(false);
        userPage.inDepositButton.setVisible(false);
        userPage.pleasePutDepositeMoney.setVisible(false);
        userPage.depositErrors.setVisible(false);
        userPage.depositeMoenyInput.setVisible(false);
        userPage.amountMoney.setVisible(false);
        userPage.paymentImage.setVisible(false);
        userPage.hiUserName.setVisible(false);
        userPage.useService.setVisible(false);
        userPage.exchangeMoney.setVisible(false);
        userPage.withdrawMoney.setVisible(false);
        userPage.depositMoney.setVisible(false);
        userPage.exit.setVisible(false);
        userPage.enterPin.setVisible(false);
        userPage.submitPin.setVisible(false);
        userPage.longOut.setVisible(false);
        userPage.welCome.setVisible(false);
        userPage.enterPinText.setVisible(false);
        userPage.goBackFromAllService.setVisible(false);

        //userWindow elements add to main frame
        appFrame.add(userPage.withdrawalAmountExchange);
        appFrame.add(userPage.withdrawalAmountTextFiled);
        appFrame.add(userPage.exchangeRate);
        appFrame.add(userPage.accountChargOnExchange);
        appFrame.add(userPage.exchangeRateTextFiled);
        appFrame.add(userPage.accountChargeTextFiled);
        appFrame.add(userPage.chargAmountError);
        appFrame.add(userPage.exchangeGoBackButton);
        appFrame.add(userPage.takeMoneyFromExchange);
        appFrame.add(userPage.inwithdrawButton);
        appFrame.add(userPage.pleasePutWithdrawMoney);
        appFrame.add(userPage.withdrawErrors);
        appFrame.add(userPage.withdrawMoenyInput);
        appFrame.add(userPage.inDepositButton);
        appFrame.add(userPage.pleasePutDepositeMoney);
        appFrame.add(userPage.depositErrors);
        appFrame.add(userPage.depositeMoenyInput);
        appFrame.add(userPage.amountMoney);
        appFrame.add(userPage.paymentImage);
        appFrame.add(userPage.hiUserName);
        appFrame.add(userPage.useService);
        appFrame.add(userPage.exchangeMoney);
        appFrame.add(userPage.withdrawMoney);
        appFrame.add(userPage.depositMoney);
        appFrame.add(userPage.exit);
        appFrame.add(userPage.enterPin);
        appFrame.add(userPage.submitPin);
        appFrame.add(userPage.longOut);
        appFrame.add(userPage.welCome);
        appFrame.add(userPage.enterPinText);
        appFrame.add(userPage.goBackFromAllService);
        //greeting window elements add to main frame
        appFrame.add(greetingPage.greetingText);
        appFrame.add(greetingPage.mainMenuButton);
        appFrame.add(greetingPage.imageLable);
        //registration elements add to main frame
        appFrame.add(registrationPage.digitNumText);
        appFrame.add(registrationPage.pinText);
        appFrame.add(registrationPage.cardDigits);
        appFrame.add(registrationPage.cardPin);
        appFrame.add(registrationPage.expMonthText);
        appFrame.add(registrationPage.expYearText);
        appFrame.add(registrationPage.expMonth);
        appFrame.add(registrationPage.expYear);
        appFrame.add(registrationPage.cvvCvcText);
        appFrame.add(registrationPage.cvvCvc);
        appFrame.add(registrationPage.password);
        appFrame.add(registrationPage.passwordText);
        appFrame.add(registrationPage.userNameText);
        appFrame.add(registrationPage.userName);
        appFrame.add(registrationPage.lastName);
        appFrame.add(registrationPage.nameText);
        appFrame.add(registrationPage.name);
        appFrame.add(registrationPage.goBakcButton);
        appFrame.add(registrationPage.submitButton);
        appFrame.add(registrationPage.lastNameText);
        //homewindow elements add to main frame
        appFrame.add(homeWindow.registerButton);
        appFrame.add(homeWindow.mainWindowSText);
        appFrame.add(homeWindow.mainWindowFText);
        appFrame.add(homeWindow.passwordText);
        appFrame.add(homeWindow.userNameText);
        appFrame.add(homeWindow.atmImage);
        appFrame.add(homeWindow.loginButton);
        //style main app frame
        appFrame.add(appTopFrame);
        appFrame.add(appBottomFrame);
        appFrame.add(appleftFrame);
        appFrame.add(appRightFrame);
        appFrame.add(linePanel);
        appFrame.add(minimizeButton);
        appFrame.add(exitButton);
        appFrame.getContentPane().setBackground(new Color(12,12,12));
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setResizable(false);
        //here is without caption maker
        appFrame.setUndecorated(true);
        appFrame.setLayout(null);
        appFrame.setBounds(300,150,900,500);
        //rounded window
        appFrame.setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, 900, 500, 19, 19));
        //makeing registration window and userWindow elements visible after clicks
        homeWindow.setRegister(registrationPage);
        homeWindow.userPages(userPage);
        appFrame.setVisible(true);
        //----------------------------------------CREATING STYLES MAIN JFRAME AND ADDING DIFFERENT WINDOW ELEMENTS START
    }
}