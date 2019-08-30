package Build;

import GUI.MainPanel;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public interface Builder{
    JPanel build();

    Builder setParent(MainPanel parent);
    Builder setLayout(LayoutManager mgr);
    Builder createSubPanels();
}