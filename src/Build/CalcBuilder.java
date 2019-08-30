package Build;

import GUI.*;
import GUI.Buttons.BottomPanel;
import GUI.Buttons.NumberPanel;
import GUI.Buttons.OperatorPanel;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

public class CalcBuilder implements Builder{

    private CalcPanel panel;

    public CalcBuilder(){
        panel = new CalcPanel();
    }

    @Override
    public CalcBuilder setParent(MainPanel parent){
        panel.setParent(parent);
        return this;
    }

    @Override
    public CalcBuilder setLayout(LayoutManager mgr){
        panel.setLayout(mgr);
        return this;
    }

    @Override
    public CalcBuilder createSubPanels() {
        createNumberPanel();
        createOperatorPanel();
        createBottomPanel();
        return this;
    }

    @Override
    public CalcPanel build(){
        return panel;
    }

    private void createNumberPanel(){
        panel.add(new NumberPanel(panel.getParent()), BorderLayout.CENTER);
    }

    private void createOperatorPanel(){
        panel.add(new OperatorPanel(panel.getParent()), BorderLayout.LINE_END);
    }

    private void createBottomPanel(){
        panel.add(new BottomPanel(panel.getParent()), BorderLayout.PAGE_END);
    }
}