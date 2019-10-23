package com.honwaii.akka.actors;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import com.honwaii.akka.messaes.DeviceAttr;

public class DeviceActor extends UntypedActor {
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof DeviceAttr) {
            System.out.println("received device attributes:" + message);
        }
    }

    public static Props creatProps() {
        return Props.create(new Creator<DeviceActor>() {
            @Override
            public DeviceActor create() throws Exception {
                return new DeviceActor();
            }
        });
    }
}
