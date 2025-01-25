import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GreetingPage implements ActionListener {

    JPanel greetpanel = new JPanel();
    RegistrationPage regWindow;
    JButton mainMenuButton = new JButton("Home page");
    JProgressBar progressBar = new JProgressBar();
    JLabel imageLable = new JLabel();
    JLabel greetingText = new JLabel();
    //UserPage userPage;
    HomeWindow homeWindow;

    GreetingPage(RegistrationPage registrationWindow,HomeWindow homeWindow)
    {
        this.regWindow = registrationWindow;
        this.homeWindow = homeWindow;

        //REGISTRATION TEXT
        greetingText.setText("Card Information Is Saved");
        greetingText.setBounds(470,10,350,200);
        greetingText.setFont(new Font("Arial", Font.BOLD, 24));
        greetingText.setForeground(Color.lightGray);

        //BUTTON CREATION TO RETURN MAIN WINDOW
        mainMenuButton.setBounds(570,160,100,35);
        mainMenuButton.setFocusable(false);
        mainMenuButton.addActionListener(this);
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
        imageLable.setBounds(100, 35, 200, 200);


        //add elements on greeting panel
        greetpanel.add(greetingText);
        greetpanel.add(imageLable);
        greetpanel.add(progressBar);
        greetpanel.add(mainMenuButton);
        greetpanel.setLayout(null);
        greetpanel.setBounds(20,50,850,400);
        greetpanel.setBackground(new Color(12,12,12));
    }

    //getPanel to move beatween windows
    public JPanel getPanel()
    {
        return greetpanel;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //return on main window
        if(e.getSource() == mainMenuButton)
        {
            // Get the parent container of the current panel
            Container parent = greetpanel.getParent();

            if (parent != null) {
                // Remove the RegistrationWindow panel from the parent
                parent.remove(greetpanel);

                // Call goBackToMain to reset the HomeWindow panel
                homeWindow.goBackToMain();

                // Add the HomeWindow panel back to the parent container
                parent.add(homeWindow.getPanel());

                // Revalidate and repaint the parent to refresh the UI
                parent.revalidate();
                parent.repaint();
            }
        }
    }
}