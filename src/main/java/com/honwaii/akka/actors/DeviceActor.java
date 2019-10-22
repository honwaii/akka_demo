package com.honwaii.akka.actors;

import akka.actor.UntypedActor;
import com.honwaii.akka.messaes.DeviceAttr;

public class DeviceActor extends UntypedActor {
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof DeviceAttr) {
            System.out.println("received device attributes:");
        }
    }
}
