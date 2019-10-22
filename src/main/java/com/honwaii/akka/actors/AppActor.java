package com.honwaii.akka.actors;

import akka.actor.UntypedActor;

public class AppActor extends UntypedActor {
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String) {
            System.out.println(message);
        }
    }
}
