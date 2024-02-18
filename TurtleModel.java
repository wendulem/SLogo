public class TurtleModel {
    private int x, y; // Turtle's position
    private double angle; // Turtle's orientation in degrees

    public TurtleModel() {
        this.x = 0;
        this.y = 0;
        this.angle = 0.0;
    }

    public void forward(int distance) {
        // Update position based on current angle
        x += (int) (distance * Math.cos(Math.toRadians(angle)));
        y += (int) (distance * Math.sin(Math.toRadians(angle)));
        notifyObservers(); // Notify the view (observer) about the change
    }

    public void right(int degrees) {
        angle += degrees;
        angle %= 360;
        notifyObservers(); // Notify the view (observer) about the change
    }

    // Observer pattern to notify the view
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    // Getters for position and angle for the view to use
    public int getX() { return x; }
    public int getY() { return y; }
    public double getAngle() { return angle; }
}
