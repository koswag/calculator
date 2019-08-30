package GUI.Buttons;

import GUI.MainPanel;

import java.awt.GridLayout;

import javax.swing.JButton;

public class NumberPanel extends ButtonPanel {
    private static final long serialVersionUID = 1L;

    public NumberPanel(MainPanel parent) {
        super(parent);
    }

    @Override
    protected void createButtons() {
        setLayout(new GridLayout(3, 3));
        buttons = new JButton[][]{
                {new JButton("7"), new JButton("8"), new JButton("9")},
                {new JButton("4"), new JButton("5"), new JButton("6")},
                {new JButton("1"), new JButton("2"), new JButton("3")}
        };
    }
}