package is.sensor;

import is.bus.Bus;
import is.is.message.Message;
import is.is.message.SpeedMessage;

public class SpeedSensor implements Sensor {
    private final Bus bus;
    private float speed;

    public SpeedSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public Message sendMessageToBus() {
        Message message = new SpeedMessage(speed);
        bus.send(message);
        return message;
    }
}
