class Computer {
    // Required parameters
    private final String HDD;
    private final String RAM;
    
    // Optional parameters
    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    // Private constructor ensures the object can ONLY be made via the Builder
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Getters (No setters to maintain immutability)
    @Override
    public String toString() {
        return "Computer [RAM=" + RAM + ", HDD=" + HDD + 
               ", GraphicsCard=" + isGraphicsCardEnabled + 
               ", Bluetooth=" + isBluetoothEnabled + "]";
    }

    // Static Inner Builder Class
    public static class ComputerBuilder {
        private final String HDD;
        private final String RAM;
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;
        
        // Constructor forces the client to provide mandatory fields
        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        // Setter-like methods that return "this" for method chaining
        public ComputerBuilder setGraphicsCardEnabled(boolean isEnabled) {
            this.isGraphicsCardEnabled = isEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isEnabled) {
            this.isBluetoothEnabled = isEnabled;
            return this;
        }

        // The final method that puts it all together
        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.ComputerBuilder("2TB NVMe", "32GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        Computer officePC = new Computer.ComputerBuilder("500GB SSD", "8GB")
                .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}