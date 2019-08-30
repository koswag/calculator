package GUI;

import javax.swing.JFrame;

public class Window extends JFrame {
    private static final long serialVersionUID = 1L;

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
    }

    public void createUI() {
        add(new MainPanel());
        setVisible(true);
    }
}