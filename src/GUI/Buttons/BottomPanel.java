package GUI.Buttons;

import GUI.MainPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

public class BottomPanel extends ButtonPanel {
    private static final long serialVersionUID = 1L;

    public BottomPanel(MainPanel parent) {
        super(parent);
    }

    @Override
    protected void createButtons() {
        setLayout(new GridLayout(1, 4));
        buttons = new JButton[][]{
                {new JButton("0"), new JButton("C"), new JButton("."), new JButton("=")}
        };
    }
}