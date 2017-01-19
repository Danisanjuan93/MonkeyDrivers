package is.bus;

import is.is.message.Message;
import is.monkeydrivers.Subscriber;

public interface Bus {
    void subscribe(Subscriber subscriber, String types);
    void send(Message message);

}
