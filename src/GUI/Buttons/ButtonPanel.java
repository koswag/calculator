package GUI.Buttons;

import GUI.MainPanel;

import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ButtonPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    protected JButton[][] buttons;

    protected abstract void createButtons();

    public ButtonPanel(MainPanel parent) {
        createButtons();
        addButtons(parent);
    }

    private void addButtons(MainPanel parent) {
        for (JButton[] buttons : buttons)
            for (JButton button : buttons) {
                String buttonText = button.getText();
                button.addActionListener(e -> parent.appendText(buttonText));
                add(button);
            }
    }
}