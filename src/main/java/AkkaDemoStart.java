import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.honwaii.akka.actors.CustomerActor;
import com.honwaii.akka.actors.DeviceActor;
import com.honwaii.akka.messages.CustomerInfo;
import com.honwaii.akka.messages.EventMsg;


public class AkkaDemoStart {
    public static void main(String[] args) {
// 1. Actor创建
        ActorSystem system = ActorSystem.create("system");
//        a. 直接创建Acotr
        ActorRef customerActor = system.actorOf(Props.create(CustomerActor.class));
//        b. 工厂模式 -- Props/Creator : ActorSystem通过接受一个Props实例来创建Actor，而Props实例有两种方式可以创建：
//        i) 指定Actor的Class，如：Props.create(ActorDemo.class)(即a中形式)
//        ii) 指定一个Actor工厂，实现akka.japi.Creator接口，重写其create方法。（统一配置或创建摸个Actor）
        ActorRef deviceActor = system.actorOf(DeviceActor.creatProps(), "deviceActor");

//  2. 消息发送
//        a. tell
        CustomerInfo cusInfo = new CustomerInfo().setId(100001L).setName("Tom").setPhoneNum("15978876969");
//        customerActor.tell(cusInfo, ActorRef.noSender());
//        b. ask
/*        DeviceAttr devAttr = new DeviceAttr().setId(10001L).setDeviceType("IN3000").setDeviceName("手环");
        Other other = new OtherMsg().setMsg("Ask msg Test");
        Timeout timeout = new Timeout(Duration.create(2, "seconds"));
        Future<Object> future = Patterns.ask(deviceActor, other, timeout);
        future.onSuccess(new OnSuccess<Object>() {
            @Override
            public void onSuccess(Object result) {
                System.out.println("received result:" + result);
            }
        }, system.dispatcher());
        future.onFailure(new OnFailure() {
            @Override
            public void onFailure(Throwable failure) {
                System.out.println("执行失败-->" + failure);
            }
        }, system.dispatcher());*/
//        c.forward
        deviceActor.tell(cusInfo, ActorRef.noSender());

//      3. Actor的层级结构
        EventMsg eventMsg = new EventMsg();
        deviceActor.tell(eventMsg, ActorRef.noSender());

//      4. 配置dispatcher
        ActorRef devActorWithDisPatcher = system.actorOf(DeviceActor.creatProps().withDispatcher("forkjoin-dispatcher"), "devActorWithDisPatcher");

//      5. 邮箱
        ActorRef devActorWithMailBox = system.actorOf(DeviceActor.creatProps().withMailbox("self-mailbox"), "devActorWithMailBox");

//      6. 消息路由

    }
}
