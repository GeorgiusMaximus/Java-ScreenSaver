import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Screen extends JFrame implements KeyListener {

    private JPanel panel;
    private JPanel dvdPanel;
    private JLabel howToClose;
    private int howToCloseLifeTime = 3000;
    private DVDLogo dvd;
    private GridBagConstraints gbcMain;
    private int speed;

    public Screen(int width, int height, boolean resizeable, boolean fullScreen, boolean immersive, int speed) {

        this.setTitle("Screen");
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(resizeable);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
        this.speed = speed;
        if (fullScreen) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        if (immersive) {
            this.setUndecorated(true);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridBagLayout());
        showInfoMessage("Escape to Exit", howToCloseLifeTime);

        gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 1;
        gbcMain.weightx = 1.0;
        gbcMain.weighty = 1.0;
        gbcMain.fill = GridBagConstraints.BOTH;
        dvdPanel = new JPanel();
        dvdPanel.setBackground(Color.BLACK);
        dvdPanel.setLayout(null);
        dvd = new DVDLogo();
        dvdPanel.add(dvd);
        this.add(panel);
        this.setVisible(true);



    }

    private void showInfoMessage(String info, int milliSeconds) {
        howToClose = new JLabel(info);
        howToClose.setFont(new Font("Times New Roman", Font.BOLD, 50));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = (panel.getWidth()) / 2;
        gbc.gridy = (panel.getHeight()) / 2;
        howToClose.setLocation(gbc.gridx, gbc.gridy);
        howToClose.setVisible(true);
        panel.add(howToClose);

        Timer timer = new Timer(milliSeconds, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                howToClose.setVisible(false);
                panel.add(dvdPanel, gbcMain);
                dvd.startAnimation(dvdPanel, speed);
            }
        });

        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
            new Launcher();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
