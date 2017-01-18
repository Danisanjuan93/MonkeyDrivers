package is.monkeydrivers;

public class SpeedMessage implements Message {
    private float speed;

    public SpeedMessage(float speed) {
        this.speed = speed;
    }

    @Override
    public String type() {
        return "speed";
    }

    public float getSpeed() {
        return speed;
    }
}