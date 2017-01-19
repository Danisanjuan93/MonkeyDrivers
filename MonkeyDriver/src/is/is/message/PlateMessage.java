package is.is.message;

import is.is.message.Message;

public class PlateMessage implements Message {
    private String plate;

    public PlateMessage(String plate) {
        this.plate = plate;
    }

    @Override
    public String type() {
        return "plate";
    }

    public String getPlate() {
        return plate;
    }
}
