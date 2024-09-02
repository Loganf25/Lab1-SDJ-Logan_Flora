import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register = new Register();
    private JTextField input = new JTextField();
    private PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        this.setPreferredSize(new Dimension(800, 800));
        this.setBackground(Color.black);
        input.setPreferredSize(new Dimension(200, 50));

        //Panel to display the input
        JPanel inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(400, 200));
        inputPanel.setBackground(Color.WHITE);
        input.addActionListener(new inputListener());
        //Label for input field
        inputPanel.add(new JLabel("Enter amount to get back change:"));
        inputPanel.add(input);
        this.add(inputPanel);
        this.add(changePanel);
    }
    private class inputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amount = Double.parseDouble(input.getText());
            Purse changeBack = register.makeChange(amount);
            changePanel.setPurse(changeBack);
            changePanel.repaint();
        }
    }

}
