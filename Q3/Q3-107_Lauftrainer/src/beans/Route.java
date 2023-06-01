package beans;

public class Route {
    private String name;
    private double distance;

    public Route(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name;
    }
}
