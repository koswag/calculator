package GUI;

import javax.swing.JPanel;

public class CalcPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private MainPanel parent;

    public void setParent(MainPanel parent) {
        this.parent = parent;
    }

    @Override
    public MainPanel getParent() {
        return parent;
    }
}