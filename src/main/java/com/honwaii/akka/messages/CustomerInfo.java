package com.honwaii.akka.messages;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public final class CustomerInfo {
    private Long Id;
    private String Name;
    private String phoneNum;
}
