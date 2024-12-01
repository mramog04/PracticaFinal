package main.java.es.unileon.prg2.patterns.Interface.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.BorderData;
import org.eclipse.swt.layout.BorderLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import main.java.es.unileon.prg2.patterns.Interface.controller.ElectoralController;

public class ElectoralView extends Shell{
    private Display display;
    private Shell shell;
    private ElectoralController controller;

    public ElectoralView(Display display, ElectoralController controller) {
        display = new Display();
        shell = new Shell(display); 
        
    }
}
