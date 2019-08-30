package Build;

import GUI.IOPanel;
import GUI.MainPanel;

import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.*;

public class IOBuilder implements Builder{

    private IOPanel panel;

    public IOBuilder(){
        panel = new IOPanel();
    }

    @Override
    public IOBuilder setParent(MainPanel parent){
        panel.setParent(parent);
        return this;
    }

    @Override
    public IOBuilder setLayout(LayoutManager mgr){
        panel.setLayout(mgr);
        return this;
    }

    @Override
    public IOBuilder createSubPanels() {
        createInput();
        createOutput();
        return this;
    }

    private void createInput(){
        JTextArea in = new JTextArea();
        in.setBorder(BorderFactory.createEtchedBorder());
        in.setFont(new Font("", Font.BOLD, 30));
        panel.setInput(in);
    }

    private void createOutput(){
        JTextArea out = new JTextArea();
        out.setBorder(BorderFactory.createEtchedBorder());
        out.setFont(new Font("", Font.BOLD, 30));
        out.setEditable(false);
        panel.setOutput(out);
    }

    @Override
    public IOPanel build(){
        return panel;
    }
}