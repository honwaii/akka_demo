import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.honwaii.akka.actors.CustomerActor;
import com.honwaii.akka.actors.DeviceActor;
import com.honwaii.akka.messaes.CustomerInfo;
import com.honwaii.akka.messaes.DeviceAttr;

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
        customerActor.tell(cusInfo, ActorRef.noSender());
//        b. ask
        DeviceAttr devAttr = new DeviceAttr().setId(10001L).setDeviceType("IN3000").setDeviceName("手环");
        deviceActor.tell(devAttr, ActorRef.noSender());
    }
}
