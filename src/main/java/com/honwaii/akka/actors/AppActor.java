package com.honwaii.akka.actors;

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;

public class AppActor extends UntypedActor {
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String) {
            System.out.println(message);
        }
    }

    public static Props creatProps() {
        return Props.create(new Creator<Actor>() {
            @Override
            public Actor create() throws Exception {
                return new AppActor();
            }
        });
    }
}
