import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class RegistrationPage implements ActionListener {

    JButton goBakcButton  = new JButton("Go back");
    JButton submitButton  = new JButton("Submit");
    JTextField name = new JTextField();
    JTextField lastName = new JTextField();
    JTextField userName = new JTextField();
    JTextField password = new JTextField();
    JLabel nameText = new JLabel();
    JLabel lastNameText = new JLabel();
    JLabel userNameText = new JLabel();
    JLabel passwordText = new JLabel();
    JTextField cardDigits = new JTextField();
    JTextField expYear = new JTextField();
    JTextField expMonth = new JTextField();
    JTextField cvvCvc = new JTextField();
    JTextField cardPin = new JTextField();
    JLabel digitNumText = new JLabel();
    JLabel expYearText = new JLabel();
    JLabel  expMonthText = new JLabel();
    JLabel cvvCvcText = new JLabel();
    JLabel pinText = new JLabel();
    GreetingPage greetingPage;
    HomeWindow homeWindow;

    //--------------------------------------------------------------------------------REGISTRATION WINDOW ELEMENTS START
    RegistrationPage(HomeWindow homeWindow,GreetingPage greetingPage)
    {
        this.homeWindow = homeWindow;
        this.greetingPage = greetingPage;

        //GO BACK button
        goBakcButton.setBounds(710,325,100,50);
        goBakcButton.setFocusable(false);
        goBakcButton.addActionListener(exp->{
            digitNumText.setVisible(false);
            pinText.setVisible(false);
            cardDigits.setVisible(false);
            cardPin.setVisible(false);
            expMonthText.setVisible(false);
            expYearText.setVisible(false);
            expMonth.setVisible(false);
            expYear.setVisible(false);
            cvvCvcText.setVisible(false);
            cvvCvc.setVisible(false);
            password.setVisible(false);
            passwordText.setVisible(false);
            userNameText.setVisible(false);
            userName.setVisible(false);
            lastName.setVisible(false);
            lastNameText.setVisible(false);
            nameText.setVisible(false);
            name.setVisible(false);
            goBakcButton.setVisible(false);
            submitButton.setVisible(false);

            homeWindow.loginButton.setVisible(true);
            homeWindow.registerButton.setVisible(true);
            homeWindow.mainWindowSText.setVisible(true);
            homeWindow.mainWindowFText.setVisible(true);
            homeWindow.userNameText.setVisible(true);
            homeWindow.passwordText.setVisible(true);
            homeWindow.atmImage.setVisible(true);
        });
        goBakcButton.setBackground(new Color(12, 12, 12));
        goBakcButton.setFont(new Font("Arial", Font.BOLD, 16));
        goBakcButton.setForeground(new Color(195,42,109));
        goBakcButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //SUBMIT BUTTON
        submitButton.setBounds(595,325,100,50);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBackground(new Color(12, 12, 12));
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setForeground(new Color(195,42,109));
        submitButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //NAME INPUT
        name.setBounds(90,100,300,50);
        name.setBackground(new Color(12, 12, 12));
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setForeground(new Color(195, 195, 195));
        name.setCaretColor(new Color(195, 195, 195));
        name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //LASTNAME INPUT
        lastName.setBounds(90,174,300,50);
        lastName.setBackground(new Color(12, 12, 12));
        lastName.setFont(new Font("Arial", Font.PLAIN, 20));
        lastName.setForeground(new Color(195, 195, 195));
        lastName.setCaretColor(new Color(195, 195, 195));
        lastName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //USERNAME INPUT
        userName.setBounds(90,250,300,50);
        userName.setBackground(new Color(12, 12, 12));
        userName.setFont(new Font("Arial", Font.PLAIN, 20));
        userName.setForeground(new Color(195, 195, 195));
        userName.setCaretColor(new Color(195, 195, 195));
        userName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //PASSWORD INPUT
        password.setBounds(90,325,300,50);
        password.setBackground(new Color(12, 12, 12));
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setForeground(new Color(195, 195, 195));
        password.setCaretColor(new Color(195, 195, 195));
        password.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //hint name textFields 520
        nameText.setBounds(90,86,300,12);
        nameText.setText("Holder Name:");
        nameText.setFont(new Font("Arial", Font.PLAIN, 14));
        nameText.setForeground(Color.lightGray);

        //hint LastName textFields
        lastNameText.setBounds(90,160,300,12);
        lastNameText.setText("Holder Surname:");
        lastNameText.setFont(new Font("Arial", Font.PLAIN, 14));
        lastNameText.setForeground(Color.lightGray);

        //hint UserName textFields
        userNameText.setBounds(90,235,300,12);
        userNameText.setText("UserName:");
        userNameText.setFont(new Font("Arial", Font.PLAIN, 14));
        userNameText.setForeground(Color.lightGray);

        //hint Password textFields
        passwordText.setBounds(90,310,300,12);
        passwordText.setText("Password:");
        passwordText.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordText.setForeground(Color.lightGray);

        //-----------------------------------------------------------------------------------------------CARD INFO START
        cardDigits.setBounds(510,100,300,50);
        cardDigits.setBackground(new Color(12, 12, 12));
        cardDigits.setFont(new Font("Arial", Font.PLAIN, 20));
        cardDigits.setForeground(new Color(195, 195, 195));
        cardDigits.setCaretColor(new Color(195, 195, 195));
        cardDigits.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //LASTNAME INPUT
        cvvCvc.setBounds(510,174,70,50);
        cvvCvc.setBackground(new Color(12, 12, 12));
        cvvCvc.setFont(new Font("Arial", Font.PLAIN, 20));
        cvvCvc.setForeground(new Color(195, 195, 195));
        cvvCvc.setCaretColor(new Color(195, 195, 195));
        cvvCvc.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //USERNAME INPUT
        expYear.setBounds(590,174,70,50);
        expYear.setBackground(new Color(12, 12, 12));
        expYear.setFont(new Font("Arial", Font.PLAIN, 20));
        expYear.setForeground(new Color(195, 195, 195));
        expYear.setCaretColor(new Color(195, 195, 195));
        expYear.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //USERNAME INPUT
        expMonth.setBounds(670,174,70,50);
        expMonth.setBackground(new Color(12, 12, 12));
        expMonth.setFont(new Font("Arial", Font.PLAIN, 20));
        expMonth.setForeground(new Color(195, 195, 195));
        expMonth.setCaretColor(new Color(195, 195, 195));
        expMonth.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //PASSWORD INPUT
        cardPin.setBounds(510,250,300,50);
        cardPin.setBackground(new Color(12, 12, 12));
        cardPin.setFont(new Font("Arial", Font.PLAIN, 20));
        cardPin.setForeground(new Color(195, 195, 195));
        cardPin.setCaretColor(new Color(195, 195, 195));
        cardPin.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //hint name textFields
        digitNumText.setBounds(510,86,300,12);
        digitNumText.setText("Card 16 Digit:");
        digitNumText.setFont(new Font("Arial", Font.PLAIN, 14));
        digitNumText.setForeground(Color.lightGray);

        //hint LastName textFields
        cvvCvcText.setBounds(510,160,300,12);
        cvvCvcText.setText("CVV/CVC:");
        cvvCvcText.setFont(new Font("Arial", Font.PLAIN, 14));
        cvvCvcText.setForeground(Color.lightGray);

        //hint UserName textFields
        expYearText.setBounds(590,160,300,12);
        expYearText.setText("exp.Year:");
        expYearText.setFont(new Font("Arial", Font.PLAIN, 14));
        expYearText.setForeground(Color.lightGray);

        //hint UserName textFields
        expMonthText.setBounds(670,160,300,12);
        expMonthText.setText("exp.Month:");
        expMonthText.setFont(new Font("Arial", Font.PLAIN, 14));
        expMonthText.setForeground(Color.lightGray);

        //hint Password textFields
        pinText.setBounds(510,235,300,12);
        pinText.setText("Card Pin:");
        pinText.setFont(new Font("Arial", Font.PLAIN, 14));
        pinText.setForeground(Color.lightGray);

        //-------------------------------------------------------------------------------------------------CARD INFO END
    }
    //----------------------------------------------------------------------------------REGISTRATION WINDOW ELEMENTS END


    //------------------------------------------------------------------actions on click events ,Check validations START
    @Override
    public void actionPerformed(ActionEvent e) {

        //----------------------------------------------------------------------------submit BUTTON actionListener START
        if (e.getSource() == submitButton)
        {
            //take input values on variables
            String nameSet = name.getText();
            String lastnameSet = lastName.getText();
            String usernameSet = userName.getText();
            String passwordSet = password.getText();
            String digitSet = cardDigits.getText();
            String expMset = expMonth.getText();
            String expYset = expYear.getText();
            String cvvCvcSet = cvvCvc.getText();
            String pinSet = cardPin.getText();

            //-------------------------------------------------------------------------FORBID SPACE IN EVERY INPUT START
            if (ValidationClass.forbidSpace(nameSet) == 1) {
                name.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                nameText.setForeground(Color.red);
                nameText.setText("Holder Name:Space detected");
                return;
            }
            else {
                name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                nameText.setText("Holder Name:");
                nameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.forbidSpace(lastnameSet) == 1) {
                lastName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                lastNameText.setForeground(Color.red);
                lastNameText.setText("Holder Surname:Space detected");
                return;
            }
            else {
                lastName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                lastNameText.setText("Holder Surname:");
                lastNameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.forbidSpace(usernameSet) == 1) {
                userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                userNameText.setForeground(Color.red);
                userNameText.setText("UserName:Space detected");
                return;
            }
            else {
                userName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                userNameText.setText("UserName:");
                userNameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.forbidSpace(passwordSet) == 1) {
                password.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                passwordText.setForeground(Color.red);
                passwordText.setText("Password:Space detected");
                return;
            }
            else {
                password.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                passwordText.setText("Password:");
                passwordText.setForeground(Color.lightGray);
            }

            if (ValidationClass.forbidSpace(digitSet) == 1) {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                digitNumText.setForeground(Color.red);
                digitNumText.setText("Card 16 Digit:Space detected");
                return;
            }
            else {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                digitNumText.setText("Card 16 Digit:");
                digitNumText.setForeground(Color.lightGray);
            }

            if(ValidationClass.forbidSpace(cvvCvcSet) == 1)
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                cvvCvcText.setForeground(Color.red);
                cvvCvcText.setText("CVV/CVC:Space detected");
                expYearText.setText("");
                expMonthText.setText("");
                return;
            }
            else
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                cvvCvcText.setForeground(Color.lightGray);
                cvvCvcText.setText("CVV/CVC:");
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.forbidSpace(expYset) == 1)
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expYearText.setForeground(Color.red);
                expYearText.setText("exp.Year:Space detected");
                expMonthText.setText("");
                return;
            }
            else
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expYearText.setForeground(Color.lightGray);
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.forbidSpace(expMset) == 1)
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expMonthText.setForeground(Color.red);
                expMonthText.setText("exp.Month:Space detected");
                return;
            }
            else
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expMonthText.setForeground(Color.lightGray);
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.forbidSpace(pinSet) == 1)
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                pinText.setForeground(Color.red);
                pinText.setText("Card Pin:Space detected");
                return;
            }
            else
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                pinText.setForeground(Color.lightGray);
                pinText.setText("Card Pin:");
            }
            //---------------------------------------------------------------------------FORBID SPACE IN EVERY INPUT END

            //--------------------------------------------------CONDITIONS IF NAME AND CARD HOLDER CONTAINS NUMBER START
            if (ValidationClass.containsOnlyLetters(nameSet) == 1) {
                name.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                nameText.setForeground(Color.red);
                nameText.setText("Holder Name:Only letters are allowed");
                return;
            }
            else {
                name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                nameText.setText("Holder Name:");
                nameText.setForeground(Color.lightGray);
            }
            //----------------------------------------------------CONDITIONS IF NAME AND CARD HOLDER CONTAINS NUMBER END

            //--------------------------------------------------------------CONDITIONS IF LASTNAME CONTAINS NUMBER START
            if (ValidationClass.containsOnlyLetters(lastnameSet) == 1) {
                lastName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                lastNameText.setForeground(Color.red);
                lastNameText.setText("Holder Surname:Only letters are allowed");
                return;
            }
            else {
                lastName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                lastNameText.setText("Holder Surname:");
                lastNameText.setForeground(Color.lightGray);
            }
            //----------------------------------------------------------------CONDITIONS IF LASTNAME CONTAINS NUMBER END

            //--------------------------------------------------------------------CONDITIONS IF ANY INPUT IS EMPTY START
            if (ValidationClass.emptyInput(nameSet) == 1 && ValidationClass.emptyInput(digitSet) == 1) {
                name.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                nameText.setForeground(Color.red);
                nameText.setText("Holder Name:Empty input");
                return;
            }
            else {
                name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                nameText.setText("Holder Name:");
                nameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.emptyInput(lastnameSet) == 1) {
                lastName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                lastNameText.setForeground(Color.red);
                lastNameText.setText("Holder Surname:Empty input");
                return;
            }
            else {
                lastName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                lastNameText.setText("Holder Surname:");
                lastNameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.emptyInput(usernameSet) == 1) {
                userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                userNameText.setForeground(Color.red);
                userNameText.setText("UserName:Empty input");
                return;
            }
            else {
                userName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                userNameText.setText("UserName:");
                userNameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.emptyInput(passwordSet) == 1) {
                password.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                passwordText.setForeground(Color.red);
                passwordText.setText("Password:Empty input");
                return;
            }
            else {
                password.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                passwordText.setText("Password:");
                passwordText.setForeground(Color.lightGray);
            }

            if(ValidationClass.emptyInput(digitSet) == 1)
            {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                digitNumText.setForeground(Color.red);
                digitNumText.setText("Card 16 Digit:Empty input");
                return;
            }
            else
            {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                digitNumText.setForeground(Color.lightGray);
                digitNumText.setText("Card 16 Digit:");
            }

            if(ValidationClass.emptyInput(cvvCvcSet) == 1)
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                cvvCvcText.setForeground(Color.red);
                cvvCvcText.setText("CVV/CVC:Empty input");
                expYearText.setText("");
                expMonthText.setText("");
                return;
            }
            else
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                cvvCvcText.setForeground(Color.lightGray);
                cvvCvcText.setText("CVV/CVC:");
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.emptyInput(expYset) == 1)
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expYearText.setForeground(Color.red);
                expYearText.setText("exp.Year:Empty input");
                expMonthText.setText("");
                return;
            }
            else
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expYearText.setForeground(Color.lightGray);
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.emptyInput(expMset) == 1)
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expMonthText.setForeground(Color.red);
                expMonthText.setText("exp.Month:Empty input");
                return;
            }
            else
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expMonthText.setForeground(Color.lightGray);
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.emptyInput(pinSet) == 1)
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                pinText.setForeground(Color.red);
                pinText.setText("Card Pin:Empty input");
                return;
            }
            else
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                pinText.setForeground(Color.lightGray);
                pinText.setText("Card Pin:");
            }
            //----------------------------------------------------------------------CONDITIONS IF ANY INPUT IS EMPTY END

            //-------------------------------------CONDITIONS FOR NAME AND LASTNAME IF FIRST LETTER IS NOT CAPITAL START
            if (ValidationClass.capitalLetterFirst(nameSet) == 1) {
                name.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                nameText.setForeground(Color.red);
                nameText.setText("Holder Name:The first letter must be capital");
                return;
            }
            else {
                name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                nameText.setText("Holder Name:");
                nameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.capitalLetterFirst(lastnameSet) == 1) {
                lastName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                lastNameText.setForeground(Color.red);
                lastNameText.setText("Holder Surname:The first letter must be capital");
                return;
            }
            else {
                lastName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                lastNameText.setText("Holder Surname:");
                lastNameText.setForeground(Color.lightGray);
            }
            //---------------------------------------CONDITIONS FOR NAME AND LASTNAME IF FIRST LETTER IS NOT CAPITAL END

            //--------------------------------DO NOT ALLOWS UPPERCASE AFTER FIRS LETTER IN NAME AND LASTNAME INPUT START
            if (ValidationClass.fullStringCantBeCapital(nameSet) == 1) {
                name.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                nameText.setForeground(Color.red);
                nameText.setText("Holder Name:Only first letter must be capital");
                return;
            }
            else {
                name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                nameText.setText("Holder Name:");
                nameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.fullStringCantBeCapital(lastnameSet) == 1) {
                lastName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                lastNameText.setForeground(Color.red);
                lastNameText.setText("Holder Surname:Only first letter must be capital");
                return;
            }
            else {
                lastName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                lastNameText.setText("Holder Surname:");
                lastNameText.setForeground(Color.lightGray);
            }
            //----------------------------------DO NOT ALLOWS UPPERCASE AFTER FIRS LETTER IN NAME AND LASTNAME INPUT END

            //------------------------------------------------------------MINIMUM LENGTH FOR USERNAME AND PASSWORD START

            if (ValidationClass.minimumLengthForUserName(usernameSet) == 1) {
                userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                userNameText.setForeground(Color.red);
                userNameText.setText("UserName:Minimum 7 character");
                return;
            }
            else {
                userName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                userNameText.setText("UserName:");
                userNameText.setForeground(Color.lightGray);
            }

            if (ValidationClass.minimumLengthForUserName(passwordSet) == 1) {
                password.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                passwordText.setForeground(Color.red);
                passwordText.setText("Password:Minimum 7 character");
                return;
            }
            else {
                password.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                passwordText.setText("Password:");
                passwordText.setForeground(Color.lightGray);
            }
            //--------------------------------------------------------------MINIMUM LENGTH FOR USERNAME AND PASSWORD END

            //---------------------------------------------------IN USERNAME USER CAN WRITE ONLY NUMBER AND LETTER START
            if (ValidationClass.userCanWriteOnlyNumAndLet(usernameSet) == 1) {
                userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                userNameText.setForeground(Color.red);
                userNameText.setText("UserName:Only numbers and letters");
                return;
            }
            else {
                userName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                userNameText.setText("UserName:");
                userNameText.setForeground(Color.lightGray);
            }
            //-----------------------------------------------------IN USERNAME USER CAN WRITE ONLY NUMBER AND LETTER END

            //---------------------------------------------------------------MATCH ERROR BETWEEN NAME AND LASTNAME STATR
            if (nameSet.equals(lastnameSet)) {
                name.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                nameText.setForeground(Color.red);
                nameText.setText("Holder Name:Similar first and last name");
                lastName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                lastNameText.setForeground(Color.red);
                lastNameText.setText("Holder Surname:Similar first and last name");
                return;
            }
            else {
                name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                nameText.setText("Holder Name:");
                nameText.setForeground(Color.lightGray);
                lastName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                lastNameText.setText("Holder Surname:");
                lastNameText.setForeground(Color.lightGray);
            }
            //-----------------------------------------------------------------MATCH ERROR BETWEEN NAME AND LASTNAME END

            //---------------------------------------------------------------MATCH ERROR BETWEEN NAME AND USERNAME START
            if (nameSet.equals(usernameSet)) {
                name.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                nameText.setForeground(Color.red);
                nameText.setText("Holder Name:Similar name and username");
                userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                userNameText.setForeground(Color.red);
                userNameText.setText("UserName:Similar username and name");
                return;
            }
            else {
                name.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                nameText.setText("Holder Name:");
                nameText.setForeground(Color.lightGray);
                userName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                userNameText.setText("UserName:");
                userNameText.setForeground(Color.lightGray);
            }
            //-----------------------------------------------------------------MATCH ERROR BETWEEN NAME AND USERNAME END

            //------------------------------------------------------------------------STRONG PASSWORD MUST CONTAIN START
            if (ValidationClass.passwordMust(passwordSet) == 1) {
                password.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                passwordText.setForeground(Color.red);
                passwordText.setText("Password:UppCase,numbers,and symbols");
                return;
            }
            else {
                password.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                passwordText.setForeground(Color.lightGray);
                passwordText.setText("Password:");
            }
            //--------------------------------------------------------------------------STRONG PASSWORD MUST CONTAIN END

            //----------------------------------------------------------------------------------------ONLY NUMBERS START
            if(!ValidationClass.containsOnlyNumbers(digitSet))
            {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                digitNumText.setForeground(Color.red);
                digitNumText.setText("Card 16 Digit:Only numbers.");
                return;
            }
            else
            {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                digitNumText.setForeground(Color.lightGray);
                digitNumText.setText("Card 16 Digit:");
            }

            if(!ValidationClass.containsOnlyNumbers(cvvCvcSet))
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                cvvCvcText.setForeground(Color.red);
                cvvCvcText.setText("CVV/CVC:Only numbers");
                expYearText.setText("");
                expMonthText.setText("");
                return;
            }
            else
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                cvvCvcText.setForeground(Color.lightGray);
                cvvCvcText.setText("CVV/CVC:");
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(!ValidationClass.containsOnlyNumbers(expYset))
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expYearText.setForeground(Color.red);
                expYearText.setText("exp.Year:Only numbers");
                expMonthText.setText("");
                return;
            }
            else
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expYearText.setForeground(Color.lightGray);
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(!ValidationClass.containsOnlyNumbers(expMset))
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expMonthText.setForeground(Color.red);
                expMonthText.setText("exp.Month:Only numbers");
                return;
            }
            else
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expMonthText.setForeground(Color.lightGray);
                expMonthText.setText("exp.Month:");
            }

            if(!ValidationClass.containsOnlyNumbers(pinSet))
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                pinText.setForeground(Color.red);
                pinText.setText("Card Pin:Only numbers");
                return;
            }
            else
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                pinText.setForeground(Color.lightGray);
                pinText.setText("Card Pin:");
            }
            //------------------------------------------------------------------------------------------ONLY NUMBERS END

            //--------------------------------------------------NUMBERS COUNT ON CARD INFO MAX AND MINIMUM NUMBERS START
            if(ValidationClass.minimumThre(cvvCvcSet) == 1)
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                cvvCvcText.setForeground(Color.red);
                cvvCvcText.setText("CVV/CVC:Should be 3 digit");
                expYearText.setText("");
                expMonthText.setText("");
                return;
            }
            else
            {
                cvvCvc.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                cvvCvcText.setForeground(Color.lightGray);
                cvvCvcText.setText("CVV/CVC:");
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.minimumTwo(expYset) == 1)
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expYearText.setForeground(Color.red);
                expYearText.setText("exp.Year:Should be 2 digit");
                expMonthText.setText("");
                return;
            }
            else
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expYearText.setForeground(Color.lightGray);
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.minimumTwo(expMset) == 1)
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expMonthText.setForeground(Color.red);
                expMonthText.setText("exp.Month:Should be 2 digit");
                return;
            }
            else
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expMonthText.setForeground(Color.lightGray);
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.minimumSixTeen(digitSet) == 1)
            {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                digitNumText.setForeground(Color.red);
                digitNumText.setText("Card 16 Digit:Should be 16 digit");
                return;
            }
            else
            {
                cardDigits.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                digitNumText.setForeground(Color.lightGray);
                digitNumText.setText("Card 16 Digit:");
            }

            if(ValidationClass.minimumSix(pinSet) == 1)
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                pinText.setForeground(Color.red);
                pinText.setText("Card Pin:Should be 6 digit");
                return;
            }
            else
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                pinText.setForeground(Color.lightGray);
                pinText.setText("Card Pin:");
            }

            if(ValidationClass.forbidFirstNumZero(pinSet) == 1)
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                pinText.setForeground(Color.red);
                pinText.setText("Card Pin:First number is zero");
                return;
            }
            else
            {
                cardPin.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                pinText.setForeground(Color.lightGray);
                pinText.setText("Card Pin:");
            }
            //----------------------------------------------------NUMBERS COUNT ON CARD INFO MAX AND MINIMUM NUMBERS END

            //-------------------------------------------------------------------------------YEAR AND MOTH COMPARE START
            if(ValidationClass.convertYear(expYset) == 1)
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expYearText.setForeground(Color.red);
                expYearText.setText("exp.Year:Expired card");
                expMonthText.setText("");
                return;
            }
            else
            {
                expYear.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expYearText.setForeground(Color.lightGray);
                expYearText.setText("exp.Year:");
                expMonthText.setText("exp.Month:");
            }

            if(ValidationClass.convertMonth(expMset) == 1)
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                expMonthText.setForeground(Color.red);
                expMonthText.setText("exp.Month:12 is last month");
                return;
            }
            else
            {
                expMonth.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
                expMonthText.setForeground(Color.lightGray);
                expMonthText.setText("exp.Month:");
            }
            //---------------------------------------------------------------------------------YEAR AND MOTH COMPARE END

            //--------------------------------------------------------------------------------------------MARIADB STARTS
            final String DB_URL = "jdbc:mariadb://127.0.0.1:3306";
            final String USER = "root";
            final String PASSWORD = "password";

            try(Connection connection = DriverManager.getConnection(DB_URL,USER,PASSWORD))
            {
                String createTableSQL = """ 
                CREATE TABLE IF NOT EXISTS accinfo
                    (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        first_name VARCHAR(100) NOT NULL,
                        last_name VARCHAR(100) NOT NULL,
                        username VARCHAR(100) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL,
                        card_digits BIGINT NOT NULL,
                        cvvcvc INT NOT NULL,
                        exp_year INT NOT NULL,
                        exp_month INT NOT NULL,
                        pin INT NOT NULL
                    )
                """;
                try(Statement stmt = connection.createStatement())
                {
                    stmt.executeUpdate(createTableSQL);
                }

                String checkUserSQL = "SELECT * FROM accinfo WHERE username = ? ";
                try(PreparedStatement checkStmt = connection.prepareStatement(checkUserSQL))
                {
                    checkStmt.setString(1,usernameSet);
                    try(ResultSet resultSet = checkStmt.executeQuery())
                    {
                        if (resultSet.next())
                        {
                            userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                            userNameText.setForeground(Color.red);
                            userNameText.setText("UserName:The username already exists");
                            return;
                        } else {
                            userName.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                            userNameText.setForeground(Color.LIGHT_GRAY);
                            userNameText.setText("UserName:");
                        }
                    }
                }

                String insertUserSQL = "INSERT INTO accinfo (first_name,last_name,username,password,card_digits,cvvcvc,exp_year,exp_month, pin) VALUES (?,?,?,?,?,?,?,?,?)";
                try(PreparedStatement insertStmt = connection.prepareStatement(insertUserSQL))
                {
                    insertStmt.setString(1,nameSet);
                    insertStmt.setString(2,lastnameSet);
                    insertStmt.setString(3,usernameSet);
                    insertStmt.setString(4,passwordSet);
                    insertStmt.setLong(5,Long.parseLong(digitSet));
                    insertStmt.setInt(6,Integer.parseInt(cvvCvcSet));
                    insertStmt.setInt(7,Integer.parseInt(expYset));
                    insertStmt.setInt(8,Integer.parseInt(expMset));
                    insertStmt.setInt(9,Integer.parseInt(pinSet));
                    insertStmt.executeUpdate();
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            //----------------------------------------------------------------------------------------------MARIADB ENDS

            //MAKE REGISTRATION WINDOW ELEMENTS INVISIBLE IF REG HAPPENS
            digitNumText.setVisible(false);
            pinText.setVisible(false);
            cardDigits.setVisible(false);
            cardPin.setVisible(false);
            expMonthText.setVisible(false);
            expYearText.setVisible(false);
            expMonth.setVisible(false);
            expYear.setVisible(false);
            cvvCvcText.setVisible(false);
            cvvCvc.setVisible(false);
            password.setVisible(false);
            passwordText.setVisible(false);
            userNameText.setVisible(false);
            userName.setVisible(false);
            lastName.setVisible(false);
            lastNameText.setVisible(false);
            nameText.setVisible(false);
            name.setVisible(false);
            goBakcButton.setVisible(false);
            submitButton.setVisible(false);
            //makeing registration window inputs empty if user registers suc
            name.setText("");
            lastName.setText("");
            userName.setText("");
            password.setText("");
            cardDigits.setText("");
            expYear.setText("");
            expMonth.setText("");
            cvvCvc.setText("");
            cardPin.setText("");
            //MAKEING GREETING WINDOW ELEMENTS VISIBLE IF REG HAPPENS
            greetingPage.greetingText.setVisible(true);
            greetingPage.mainMenuButton.setVisible(true);
            greetingPage.imageLable.setVisible(true);
        }
        //------------------------------------------------------------------------------submit BUTTON actionListener END
    }
}
//------------------------------------------------------------------------actions on click events ,Check validations END