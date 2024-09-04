//Main Change Class for running the gui portion of the project
import java.awt.*;
import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Register and Purse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(800, 800));
        frame.setBackground(Color.white);
        frame.getContentPane().add(new RegisterPanel());

        frame.pack();
        frame.setVisible(true);
    }
}
