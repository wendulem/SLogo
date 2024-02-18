public class TurtleView implements Observer {
    @Override
    public void update(Object arg) {
        if (arg instanceof TurtleModel) {
            TurtleModel model = (TurtleModel) arg;
            // Update the view using the model's state
            System.out.println("Turtle position changed to: (" + model.getX() + ", " + model.getY() + ")");
        }
    }
}
