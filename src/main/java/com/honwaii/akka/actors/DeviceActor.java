package com.honwaii.akka.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import com.honwaii.akka.messages.CustomerInfo;
import com.honwaii.akka.messages.DeviceAttr;
import com.honwaii.akka.messages.EventMsg;
import com.honwaii.akka.messages.Other;
import org.w3c.dom.events.Event;

public class DeviceActor extends UntypedActor {

    private ActorRef forwardActor = getContext().actorOf(ForwardActor.creatProps());

    public void onReceive(Object message) throws Throwable, Throwable {
        if (message instanceof DeviceAttr) {
            System.out.println("received device attributes:" + message);
        } else if (message instanceof Other) {
            getSender().tell("unsupported msg-->" + message, getSelf());
        } else if (message instanceof CustomerInfo) {
            System.out.println("deviceActor forward msg  to forwardActor...");
            forwardActor.forward(message, getContext());
        } else if (message instanceof EventMsg) {
            ActorRef dev = getContext().actorOf(DeviceActor.creatProps(), "childDevice");
            System.out.println(dev);
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
