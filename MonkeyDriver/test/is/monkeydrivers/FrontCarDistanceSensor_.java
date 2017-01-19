package is.monkeydrivers;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.*;

public class FrontCarDistanceSensor_ {
    private Bus bus;

    @Before
    public void setUp() throws Exception {
        bus = mock(Bus.class);
    }

    @Test
    public void should_set_message_to_bus_when_device_returns_distance() throws Exception {
        Subscriber subscriberDistance = mock(Subscriber.class);
        bus.subscribe(subscriberDistance,"distance");
        DistanceDevice distanceDevice = mock(DistanceDevice.class);
        FrontCarDistanceSensor frontCarDistanceSensor = new FrontCarDistanceSensor(bus, distanceDevice);
        when(distanceDevice.getDistance()).thenReturn(10f);
        frontCarDistanceSensor.askDeviceForNewValue();
        frontCarDistanceSensor.sendMessageToBus();
        sleep(5000);
        verify(distanceDevice,times(1)).getDistance();
        verify(bus,times(1)).send(any(DistanceMessage.class));
    }

    @Test
    public void should_set_message_to_bus_when_device_returns_minus_one() throws Exception {

        Subscriber subscriberDistance = mock(Subscriber.class);
        bus.subscribe(subscriberDistance,"distance");
        DistanceDevice distanceDevice = mock(DistanceDevice.class);
        FrontCarDistanceSensor frontCarDistanceSensor = new FrontCarDistanceSensor(bus, distanceDevice);
        frontCarDistanceSensor.sendMessageToBus();
        when(distanceDevice.getDistance()).thenReturn(-1f);
        frontCarDistanceSensor.askDeviceForNewValue();
        Message message = frontCarDistanceSensor.sendMessageToBus();
        verify(subscriberDistance,times(0)).receiveMessage(message);
    }
    @Test
    public void should_not_set_message_to_bus_when_speed_returns_minus_one() throws Exception {

        Subscriber subscriberSpeed= mock(Subscriber.class);
        bus.subscribe(subscriberSpeed,"speed");
        SpeedMessage speed = mock(SpeedMessage.class);
        FrontCarSpeedVirtualSensor frontCarSpeedVirtualSensor = new FrontCarSpeedVirtualSensor(bus);
        frontCarSpeedVirtualSensor.sendMessageToBus();
        when(speed.getSpeed()).thenReturn(-1f);
        Message messageSpeed = frontCarSpeedVirtualSensor.sendMessageToBus();
        verify(subscriberSpeed,times(0)).receiveMessage(messageSpeed);
    }
    @Test
    public void should_not_set_message_to_bus_when_speed_returns_speed() throws Exception {

        Subscriber subscriberSpeed= mock(Subscriber.class);
        bus.subscribe(subscriberSpeed,"speed");
        SpeedMessage speed = mock(SpeedMessage.class);
        FrontCarSpeedVirtualSensor frontCarSpeedVirtualSensor = new FrontCarSpeedVirtualSensor(bus);
        Message message= frontCarSpeedVirtualSensor.sendMessageToBus();
        frontCarSpeedVirtualSensor.receiveMessage(message);
        sleep(5000);
        verify(speed,times(1)).getSpeed();
        verify(bus,times(1)).send(any(SpeedMessage.class));

    }
}
