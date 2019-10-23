package com.honwaii.akka.actors;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import com.honwaii.akka.messaes.CustomerInfo;

public class ForwardActor extends UntypedActor {
    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof String) {
            System.out.println(message);
        } else if (message instanceof CustomerInfo) {
            System.out.println("forwardActor received customer info from " + getSender() + ", msg -->" + message);

        }
    }

    public static Props creatProps() {
        return Props.create(new Creator<ForwardActor>() {
            @Override
            public ForwardActor create() throws Exception {
                return new ForwardActor();
            }
        });
    }
}
