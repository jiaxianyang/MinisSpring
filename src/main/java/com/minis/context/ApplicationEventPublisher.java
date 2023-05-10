package com.minis.context;

import com.apple.eawt.ApplicationEvent;

public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent applicationEvent);
}
