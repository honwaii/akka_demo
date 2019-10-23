package com.honwaii.akka.messages;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EventMsg {
    private String event;
}
