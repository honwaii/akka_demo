package com.honwaii.akka.actors;

import akka.actor.UntypedActor;
import com.honwaii.akka.messaes.CustomerInfo;

public class CustomerActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof CustomerInfo) {
            System.out.println("received customer info is --> " + message);
        } else {
            System.out.println("unsupported message.");
        }
    }
}
