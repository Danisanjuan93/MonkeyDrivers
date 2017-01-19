package is.monkeydrivers;

public class DistanceMessage implements Message {
    private float distance;

    @Override
    public String type() {
        return "distance";
    }

    public DistanceMessage(float distance) {
        this.distance = distance;
    }


    public float getDistance() {
        return distance;
    }
}
