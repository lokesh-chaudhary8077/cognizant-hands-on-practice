// The Command Interface
interface Command {
    void execute();
    void undo();
}

// The Receiver (The object that does the actual work)
class Light {
    public void turnOn() {
        System.out.println("The light is ON.");
    }
    public void turnOff() {
        System.out.println("The light is OFF.");
    }
}

// Concrete Command A (For turning light ON)
class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

// Concrete Command B (For turning light OFF)
class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// The Invoker (The Remote Control button)
class RemoteControl {
    private Command slot;
    private Command lastCommand; // For tracking history to support Undo

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        if (slot != null) {
            slot.execute();
            lastCommand = slot; // Save reference for undoing
        }
    }

    public void pressUndo() {
        if (lastCommand != null) {
            System.out.print("[UNDOING] -> ");
            lastCommand.undo();
        }
    }
}

// Client Code
public class CommandPatternExample {
    public static void main(String[] args) {
        // Setup the Receiver
        Light livingRoomLight = new Light();

        // Create the Command objects
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Setup the Invoker
        RemoteControl remote = new RemoteControl();

        // Test Action 1: Turning on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Test Action 2: Undoing the action
        remote.pressUndo();

        System.out.println("\n----------------------------------\n");

        // Test Action 3: Reconfiguring the same remote button to turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
        remote.pressUndo();
    }
}