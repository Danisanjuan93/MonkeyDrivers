package is.bus;

import is.bus.Bus;
import is.is.message.Message;
import is.monkeydrivers.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBus implements Bus {

    private Map<String,List<Subscriber>> subscribers = new HashMap<>();


    @Override
    public void send(Message message) {
        if(!subscribers.containsKey(message.type()))return;
        subscriberWillReceiveMessage(message);
    }

    private void subscriberWillReceiveMessage(Message message) {
        for (Subscriber subscriber : subscribers.get(message.type())) {
            subscriber.receiveMessage(message);
        }
    }

    private List<Subscriber> subscribersOf(String type) {
        return subscribers.get(type);
    }
    @Override
    public void subscribe(Subscriber subscriber, String type) {
        if (!subscribers.containsKey(type)) subscribers.put(type, new ArrayList<>());
        subscribersOf(type).add(subscriber);
    }


}