import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GreetingPage {

    JButton mainMenuButton = new JButton("Home page");
    JLabel imageLable = new JLabel();
    JLabel greetingText = new JLabel();
    HomeWindow homeWindow;

    //--------------------------------------------------------------------------------ELEMENTS FOR GREETING WINDOW START
    GreetingPage(HomeWindow homeWindow)
    {
        this.homeWindow = homeWindow;

        greetingText.setText("Card Information Is Saved");
        greetingText.setBounds(470,60,350,200);
        greetingText.setFont(new Font("Arial", Font.BOLD, 24));
        greetingText.setForeground(Color.lightGray);

        //BUTTON CREATION TO RETURN MAIN WINDOW
        mainMenuButton.setBounds(570,210,100,35);
        mainMenuButton.setFocusable(false);
        mainMenuButton.addActionListener(exp->{//RETURN HOMEWINDOW FROM GREETING WINDOW
            homeWindow.loginButton.setVisible(true);
            homeWindow.registerButton.setVisible(true);
            homeWindow.mainWindowSText.setVisible(true);
            homeWindow.mainWindowFText.setVisible(true);
            homeWindow.userNameText.setVisible(true);
            homeWindow.passwordText.setVisible(true);
            homeWindow.atmImage.setVisible(true);

            greetingText.setVisible(false);
            mainMenuButton.setVisible(false);
            imageLable.setVisible(false);

        });
        mainMenuButton.setBackground(new Color(12, 12, 12));
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 16));
        mainMenuButton.setForeground(new Color(195,42,109));
        mainMenuButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //CARD image
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/card.png")));
        // Scale the image to the desired size
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageLable = new JLabel();
        //makeing cp image sizes
        imageLable.setIcon(new ImageIcon(image));
        imageLable.setBounds(100, 100, 200, 200);
    }
    //----------------------------------------------------------------------------------ELEMENTS FOR GREETING WINDOW END
}