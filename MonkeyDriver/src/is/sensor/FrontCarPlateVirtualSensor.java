package is.sensor;


import is.is.message.Message;
import is.is.message.PlateMessage;
import is.bus.Bus;

public class FrontCarPlateVirtualSensor implements VirtualSensor {

    private final Bus bus;
    private String frontCarPlate;

    public FrontCarPlateVirtualSensor(Bus bus) {
        this.bus = bus;
    }

    @Override
    public Message sendMessageToBus() {

        Message message = new PlateMessage(frontCarPlate);
        bus.send(message);
        return message;
    }

    @Override
    public void receiveMessage(Message message) {

    }
}