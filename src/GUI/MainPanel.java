package GUI;

import Build.Builder;
import Build.CalcBuilder;
import Build.Director;
import Build.IOBuilder;
import Handling.RequestHandler;
import State.Caretaker;
import State.Memento;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MainPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private RequestHandler handler = new RequestHandler();
    private Caretaker state = new Caretaker();
    private Director director = new Director(this);

    private JTextArea input,
            output;

    public MainPanel() {
        setLayout(new GridLayout(2, 1));

        buildIOPanel();
        buildCalculator();

        setupUndoHotKey();
    }


    private void buildCalculator() {
        Builder calcBuilder = new CalcBuilder();
        CalcPanel calc = (CalcPanel) director.construct(calcBuilder, new BorderLayout());

        add(calc);
    }

    private void buildIOPanel() {
        Builder ioBuilder = new IOBuilder();
        IOPanel io = (IOPanel) director.construct(ioBuilder, new GridLayout(2, 1));
        setIO(io);

        add(io);
    }

    private void setIO(IOPanel io) {
        input = io.getInput();
        output = io.getOutput();
    }


    private void setupUndoHotKey() {
        String UNDO = "Undo action key";
        setUndoAction(UNDO);
        mapUndoShortcut(UNDO);
    }

    private void setUndoAction(String key) {
        Action undoAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        };
        getActionMap().put(key, undoAction);
    }

    private void undo() {
        Memento prev = state.getState();
        input.setText(prev.getInput());
        output.setText(prev.getOutput());
    }

    private void mapUndoShortcut(String value) {
        InputMap[] inputMaps = new InputMap[]{
                getInputMap(JComponent.WHEN_FOCUSED),
                getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT),
                getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW),
        };

        for (InputMap i : inputMaps) {
            i.put(KeyStroke.getKeyStroke("control Z"), value);
        }
    }


    public void appendText(String str) {
        if (str.equals("C")) {
            save(input.getText(), output.getText());
            reset();
        } else {
            if (str.equals("="))
                evaluate();
            input.append(str);
        }
    }

    private void save(String input, String output) {
        state.setState(input, output);
    }

    private void reset() {
        input.setText("");
        output.setText("");
    }

    private void evaluate() {
        output.setText(
                handler.getResult(input.getText())
        );
    }
}