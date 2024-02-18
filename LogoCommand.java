interface LogoCommand {
    void execute(TurtleModel model);
}

class ForwardCommand implements LogoCommand {
    private int distance;

    public ForwardCommand(int distance) {
        this.distance = distance;
    }

    @Override
    public void execute(TurtleModel model) {
        model.forward(distance);
    }
}

class RightCommand implements LogoCommand {
    private int degrees;

    public RightCommand(int degrees) {
        this.degrees = degrees;
    }

    @Override
    public void execute(TurtleModel model) {
        model.right(degrees);
    }
}

// Add more classes for other commands like LEFT, REPEAT, etc.

class RepeatCommand implements LogoCommand {
    private final int times;
    private final List<LogoCommand> commands;

    public RepeatCommand(int times, List<LogoCommand> commands) {
        this.times = times;
        this.commands = commands;
    }

    @Override
    public void execute(TurtleModel model) {
        for (int i = 0; i < times; i++) {
            for (LogoCommand command : commands) {
                command.execute(model);
            }
        }
    }
}
