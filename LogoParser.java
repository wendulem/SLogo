import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class LogoParser {
    public List<LogoCommand> parse(String input) {
        List<LogoCommand> commands = new ArrayList<>();
        String[] tokens = input.split(" ");
        Stack<String> tokenStack = new Stack<>();
        for (String token : tokens) {
            tokenStack.push(token);
        }

        while (!tokenStack.isEmpty()) {
            String token = tokenStack.pop();
            switch (token) {
                case "FORWARD":
                    int distance = Integer.parseInt(tokenStack.pop());
                    commands.add(new ForwardCommand(distance));
                    break;
                case "RIGHT":
                    int degrees = Integer.parseInt(tokenStack.pop());
                    commands.add(new RightCommand(degrees));
                    break;
                case "REPEAT":
                    int times = Integer.parseInt(tokenStack.pop());
                    // Assuming the next token is "["
                    tokenStack.pop(); // Remove "[" from stack
                    List<LogoCommand> repeatCommands = new ArrayList<>();
                    String nextToken;
                    while (!(nextToken = tokenStack.pop()).equals("]")) {
                        // This simplistic approach assumes all commands inside REPEAT are well-formed and end with a "]".
                        // For a more robust implementation, you would need a more sophisticated method to correctly match "[" and "]" pairs.
                        repeatCommands.addAll(parse(nextToken)); // Recursively parse the commands inside REPEAT
                    }
                    commands.add(new RepeatCommand(times, repeatCommands));
                    break;
                // Add cases for other commands as needed
            }
        }

        return commands;
    }
}
