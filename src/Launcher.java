import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends JFrame implements ActionListener {

    JButton launchButton;

    public Launcher() {
        this.setTitle("Screen-Saver");
        this.setSize(350, 150);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        launchButton = new JButton("Launch");
        launchButton.addActionListener(this);
        launchButton.setBounds(0, 0, this.getWidth() - 10, this.getHeight() - 35);
        this.add(launchButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == launchButton) {
            this.dispose();
            new Screen(600, 400, true, false, true);
        }
    }
}
