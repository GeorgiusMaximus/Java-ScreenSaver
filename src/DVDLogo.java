import javax.swing.*;
import java.util.Random;

public class DVDLogo extends JPanel {

    private ImageIcon image;
    private JLabel imageLabel;


    public DVDLogo(int posX, int posY) {

        this.setLayout(null);
        this.setOpaque(false);

        image = new ImageIcon(getClass().getResource("katze.png"));
        imageLabel = new JLabel(image);

        imageLabel.setBounds(posX, posY, image.getIconWidth(), image.getIconHeight());
        this.add(imageLabel);
        this.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

    }

}
