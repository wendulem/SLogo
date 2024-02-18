# Logo Interpreter Application

This Logo Interpreter application is designed to parse and execute Logo programming language commands, specifically for drawing operations controlled by a turtle graphics system. It leverages the Model-View-Controller (MVC) architectural pattern and incorporates an Observer pattern for efficient model-view updates.

## Overview

The application consists of several key components:

- **Model (`TurtleModel`)**: Represents the state and behavior of the turtle, including its position and orientation.
- **View (`TurtleView`)**: Displays the turtle's current state and any drawings produced as a result of executing Logo commands.
- **Controller (`LogoController`)**: Parses Logo commands and coordinates between the model and the view, updating the model based on commands and ensuring the view reflects these updates.
- **Commands**: A set of classes that implement the `LogoCommand` interface, each corresponding to a specific Logo command (e.g., `FORWARD`, `RIGHT`).

## Key Components

### Model

The `TurtleModel` is responsible for managing the turtle's state. It includes methods to move the turtle forward, rotate it, and other operations as defined by Logo commands. This class extends `ObservableModel` to support observer registration and notification.

### View

The `TurtleView` implements the `Observer` interface and updates the visual representation of the turtle whenever the model changes. It listens for updates from the `TurtleModel` and redraws the turtle and its path accordingly.

### Controller

The `LogoController` takes user input in the form of Logo commands, uses the `LogoParser` to convert these into executable command objects, and applies them to the `TurtleModel`. It acts as the intermediary between the view and the model.

### Commands

Each Logo command is represented by a class that implements the `LogoCommand` interface. These classes define the execution logic for each command:

- `ForwardCommand`: Moves the turtle forward.
- `RightCommand`: Rotates the turtle to the right.
- `RepeatCommand`: Executes a set of commands multiple times.

### Observer Pattern

The application uses a custom Observer pattern implementation for model-view communication:

- **`Observer` Interface**: Defines the `update` method for observers to implement.
- **`ObservableModel` Abstract Class**: Manages observer registration and notification.

## File Structure

- `TurtleModel.java`: Defines the turtle's behavior and state.
- `TurtleView.java`: Implements drawing logic for the turtle.
- `LogoController.java`: Parses and executes Logo commands.
- `LogoCommands.java`: Contains implementations of the `LogoCommand` interface.
- `Observer.java`: Defines the `Observer` interface for the Observer pattern.
- `ObservableModel.java`: Abstract class for observable objects.

## Usage

1. **Setup**: Initialize the `TurtleModel`, `TurtleView`, and `LogoController`.
2. **Execution**: Input Logo commands to the controller to see them executed and reflected in the view.

## Conclusion

This Logo Interpreter application demonstrates the use of MVC and Observer patterns in a Java application. It provides a flexible and maintainable structure for expanding functionality, such as adding new commands or enhancing the view's capabilities.
