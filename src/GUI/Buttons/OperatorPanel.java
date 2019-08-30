package GUI.Buttons;

import GUI.MainPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

public class OperatorPanel extends ButtonPanel {
    private static final long serialVersionUID = 1L;

    public OperatorPanel(MainPanel parent) {
        super(parent);
    }

    @Override
    protected void createButtons() {
        setLayout(new GridLayout(4, 1));
        buttons = new JButton[][]{
                {new JButton("/")},
                {new JButton("*")},
                {new JButton("-")},
                {new JButton("+")}
        };
    }
}