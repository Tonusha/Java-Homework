package homework.work9.main;

import homework.work9.entity.Receiver;
import homework.work9.service.ReceiverService;

import java.util.List;

/**
 * Created by miruk on 08.04.2015.
 */
public class ReceiveMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Receiver newReceiver = new Receiver(9, "Николаев Андрей");
        ReceiverService receiverService = new ReceiverService();
        receiverService.addReceiver(newReceiver);
        List<Receiver> receivers = receiverService.getReceivers();
        for (Receiver receiver : receivers)
        {
            System.out.println("receive = " + receiver);
        }
    }
}
