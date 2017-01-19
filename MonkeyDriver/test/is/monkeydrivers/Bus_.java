package is.monkeydrivers;

import is.bus.Bus;
import is.bus.SimpleBus;
import is.is.message.Message;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class Bus_ {
    private Bus bus;

    @Before
    public void setUp() throws Exception {
        bus = new SimpleBus();
    }

    @Test
    public void should_send_messages_associated_to_subscriber() throws Exception {
        Subscriber subscriberFoo = mock(Subscriber.class);
        Message foo = mock(Message.class);
        doReturn("foo").when(foo).type();
        bus.subscribe(subscriberFoo,"foo");
        bus.send(foo);
        verify(subscriberFoo, times(1)).receiveMessage(foo);
    }

    @Test
    public void should_send_only_the_messages_associated_to_all_subscribers() throws Exception {
        Subscriber subscriberFoo = mock(Subscriber.class);
        Subscriber subscriberFii = mock(Subscriber.class);

        Message foo = mock(Message.class);
        doReturn("foo").when(foo).type();
        Message fii = mock(Message.class);
        doReturn("fii").when(fii).type();

        bus.subscribe(subscriberFoo, "foo");
        bus.subscribe(subscriberFii, "fii");
        bus.send(foo);
        bus.send(fii);

        verify(subscriberFoo, times(0)).receiveMessage(fii);
        verify(subscriberFii, times(0)).receiveMessage(foo);
    }

    @Test
    public void should_send_a_message_to_all_subscribers() {
        Message foo = mock(Message.class);
        doReturn("foo").when(foo).type();
        Subscriber subscriber1 = mock(Subscriber.class);
        Subscriber subscriber2 = mock(Subscriber.class);

        bus.subscribe(subscriber1, "foo");
        bus.subscribe(subscriber2, "foo");
        bus.send(foo);

        verify(subscriber1, times(1)).receiveMessage(foo);
        verify(subscriber2, times(1)).receiveMessage(foo);




    }
}
