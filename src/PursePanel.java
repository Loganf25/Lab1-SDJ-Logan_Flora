//Purse Panel Class - Holds gui portion of the purse, which displays images of denominations instead of words
import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();
    public PursePanel() {
        this.setPreferredSize(new Dimension(800, 500));
        this.setBackground(Color.BLUE);
    }


    //I could not figure out how to add the purse to this class, so this is how I did it
    void setPurse(Purse purse) {
        this.purse = purse;
    }

    //Code for displaying the purse in picture format instead of words in the register class
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (purse != null) {
            double left = purse.getValue();
            int x = 10; // Initial x-coordinate
            int y = 20; // Initial y-coordinate

            // Enhanced for loop to iterate through the denominations
            for (Denomination curr : Denomination.denominations) {
                int count = 0;
                while(left >= curr.amt()) {
                    left -= curr.amt();
                    count++;
                    //Just a different way to make up for the "fake math," especially after a cent left
                    left = Math.round(left * 100.00) / 100.00;
                }

                // Draw the images for the denomination
                //Found this way to resize the images
                for (int i = 0; i < count; i++) {
                    // Load the image from the file path and print whilst also sizing it
                    //Does lower image quality for me though
                    Image image = new ImageIcon(curr.img()).getImage();
                    g.drawImage(image, x, y, 100, 50, this);

                        // Update x-coordinate for the next image so that they are displayed next to each other
                        //Rather than on top of another
                        x += 110;
                        if (x > getWidth() - 60) {
                            x = 10;
                            y += 55;
                        }
                }
            }
        }

    }
}
