public class TurtleView implements Observer {
    public void update(TurtleModel model) {
        // Method to redraw the turtle based on its new state
        System.out.println("Turtle moved to: (" + model.getX() + ", " + model.getY() + ") at angle: " + model.getAngle());
        // For a GUI, this method would redraw the turtle on the screen
    }
}
