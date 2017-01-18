package is.monkeydrivers;

public class DistanceMessage implements Message {
    private float distance;

    public DistanceMessage(float distance) {
        this.distance = distance;
    }

    @Override
    public String type() {
        return "distance";
    }

    public float getDistance() {
        return distance;
    }
}
