import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends JFrame implements ActionListener, ChangeListener {


    private final int WIDTH = 400;
    private final int HEIGHT = 525;
    private boolean resizeable = false;
    private boolean fullScreen = false;
    private boolean immersive = false;



    private JButton launchButton;
    private JCheckBox isResizable;
    private JCheckBox isFullScreen;
    private JCheckBox isImmersive;
    public static JSlider speedSlider;

    private JLabel speedLabel;



    public Launcher() {

        this.setTitle("Launcher");
        this.setSize(WIDTH, HEIGHT);
        GridLayout gl = new GridLayout();
        gl.setColumns(1);
        gl.setRows(6);
        this.setLayout(gl);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.BOLD, 30);


        String launchButtonTitle = "Launch";
        launchButton = new JButton(launchButtonTitle);
        launchButton.setFont(font);
        launchButton.addActionListener(this);
        this.add(launchButton);

        isResizable = new JCheckBox("resizable ");
        isResizable.setFont(font);
        isResizable.setHorizontalAlignment(SwingConstants.CENTER);
        isResizable.addActionListener(this);
        this.add(isResizable);

        isFullScreen = new JCheckBox("fullscreen ");
        isFullScreen.setFont(font);
        isFullScreen.setHorizontalAlignment(SwingConstants.CENTER);
        isFullScreen.addActionListener(this);
        this.add(isFullScreen);

        isImmersive = new JCheckBox("immersive ");
        isImmersive.setFont(font);
        isImmersive.setHorizontalAlignment(SwingConstants.CENTER);
        isImmersive.addActionListener(this);
        this.add(isImmersive);

        speedLabel = new JLabel("speed: ");
        speedLabel.setFont(font);
        speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(speedLabel);

        speedSlider = new JSlider(0, 50, 5);
        speedSlider.setPaintTicks(true);
        speedSlider.setMinorTickSpacing(5);
        speedSlider.setPaintTrack(true);
        speedSlider.setMajorTickSpacing(10);
        speedSlider.setPaintLabels(true);
        this.add(speedSlider);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resizeable = isResizable.isSelected();
        fullScreen = isFullScreen.isSelected();
        immersive = isImmersive.isSelected();

        if (e.getSource() == launchButton) {
            int speed = speedSlider.getValue();
            new Screen(600, 400, resizeable, fullScreen, immersive, speed);
            this.dispose();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
