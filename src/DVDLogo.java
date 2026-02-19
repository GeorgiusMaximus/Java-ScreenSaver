import javax.swing.*;
import java.awt.*;

public class DVDLogo extends JComponent {

    private Image image;

    private int dx;
    private int dy;
    private int speed;

    public DVDLogo() {
        image = new ImageIcon(getClass().getResource("katze.png")).getImage();
        this.setSize(image.getWidth(null), image.getHeight(null));
        this.dx = 1;
        this.dy = 1;
    }

    void startAnimation(JPanel container, int speed) {
        this.speed = speed;

        Timer timer = new Timer(10, e -> {

            int x = this.getX() + this.dx * speed;
            int y = this.getY() + this.dy * speed;

            if (x < 0 || x + this.getWidth() > container.getWidth()) {
                dx *= -1;
            }

            if (y < 0 || y + this.getHeight() > container.getHeight()) {
                dy *= -1;
            }

            this.setLocation(x, y);
        });

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
