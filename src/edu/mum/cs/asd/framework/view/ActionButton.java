package edu.mum.cs.asd.framework.view;

import edu.mum.cs.asd.framework.controller.EventHandler;
import javax.swing.JButton;

public class ActionButton extends JButton {

    public EventHandler handler;

    public ActionButton(String text, EventHandler handler) {
        super(text);
        this.handler = handler;
    }

    public EventHandler getHandler() {
        return handler;
    }

    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }
}
