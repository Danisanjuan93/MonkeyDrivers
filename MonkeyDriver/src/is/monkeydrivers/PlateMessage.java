package is.monkeydrivers;

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
