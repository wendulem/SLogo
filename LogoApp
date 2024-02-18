public class LogoApp {
    public static void main(String[] args) {
        TurtleModel model = new TurtleModel();
        TurtleView view = new TurtleView();
        LogoController controller = new LogoController(model, view);

        String logoCommands = "REPEAT 5 [FORWARD 100 RIGHT 144]";
        controller.executeCommands(logoCommands);
        // The view automatically updates to show the turtle's movements
    }
}
