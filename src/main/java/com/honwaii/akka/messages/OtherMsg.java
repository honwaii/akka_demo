package com.honwaii.akka.messages;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public final class OtherMsg implements Other {
    private String msg;
}
