package com.honwaii.akka.messaes;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeviceAttr {
    private Long id;
    private String deviceType;
    private String deviceName;
}
