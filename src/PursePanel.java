import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();
    public PursePanel() {
        this.setPreferredSize(new Dimension(800, 500));
        this.setBackground(Color.BLUE);
    }


    void setPurse(Purse purse) {
        this.purse = purse;
    }
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
                    left = Math.round(left * 100.00) / 100.00;
                }

                // Draw the images for the denomination
                for (int i = 0; i < count; i++) {
                    // Load the image from the file path and print
                    Image image = new ImageIcon(curr.img()).getImage();
                    g.drawImage(image, x, y, 100, 50, this);

                        // Update x-coordinate for the next image
                        x += 110;
                        if (x > getWidth() - 60) { // Check if the x-coordinate exceeds the panel width
                            x = 10; // Reset x to start a new row
                            y += 55; // Move to the next row
                        }
                }
            }
        }

    }
}
