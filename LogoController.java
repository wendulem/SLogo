public class LogoController {
    private TurtleModel model;
    private TurtleView view;
    private LogoParser parser;

    public LogoController(TurtleModel model, TurtleView view) {
        this.model = model;
        this.view = view;
        this.parser = new LogoParser();
        
        // Register view as an observer of the model
        model.addObserver(view);
    }

    public void executeCommands(String logoCommands) {
        List<LogoCommand> commands = parser.parse(logoCommands);
        for (LogoCommand command : commands) {
            command.execute(model);
            // The model notifies the view automatically via the observer pattern after each command
        }
    }
}
