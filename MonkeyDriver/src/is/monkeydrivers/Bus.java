package is.monkeydrivers;

public interface Bus {
    void subscribe(Subscriber subscriber, String types);
    void send(Message message);

}
