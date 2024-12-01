package main.java.es.unileon.prg2.patterns.Interface.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;

import es.unileon.prg2.calculator.model.CalculatorModel;
import es.unileon.prg2.calculator.view.CalculatorView;
import main.java.es.unileon.prg2.patterns.Interface.view.ElectoralView;

public class ElectoralController {

    private CalculatorModel model;
    private CalculatorView view;

    public ElectoralController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = new ElectoralView();
    }

    
}
