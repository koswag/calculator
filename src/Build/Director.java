package Build;

import GUI.MainPanel;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public class Director{
    private MainPanel client;

    public Director(MainPanel c){
        this.client = c;
    }

    public JPanel construct(Builder builder, LayoutManager mgr){
        return builder.setParent(client)
                        .setLayout(mgr)
                        .createSubPanels()
                        .build();
    }
}