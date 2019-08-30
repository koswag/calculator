package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class IOPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private JTextArea input,
            output;

    private MainPanel parent;

    public void setParent(MainPanel parent) {
        this.parent = parent;
    }

    public void setInput(JTextArea in) {
        add(in);
        this.input = in;
    }

    public JTextArea getInput() {
        return input;
    }

    public void setOutput(JTextArea out) {
        add(out);
        this.output = out;
    }

    public JTextArea getOutput() {
        return output;
    }
}