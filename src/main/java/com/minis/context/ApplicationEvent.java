package com.minis.context;

import java.util.EventObject;

public class ApplicationEvent extends EventObject {

    private static final long serialVersionUID = 0L;

    /**
     * Constructs a prototypical Event.
     *
     * @param args0 The object on which the Event initially occurred.
     * @throws IllegalArgumentException if args0 is null.
     */
    public ApplicationEvent(Object args0) {
        super(args0);
    }
}
