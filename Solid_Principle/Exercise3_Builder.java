class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;
    private final boolean hasWifi;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.hasWifi = builder.hasWifi;
    }

    public void showDetails() {
        System.out.println("CPU     : " + cpu);
        System.out.println("RAM     : " + ram);
        System.out.println("Storage : " + storage);
        System.out.println("GPU     : " + (gpu == null ? "Integrated" : gpu));
        System.out.println("WiFi    : " + (hasWifi ? "Yes" : "No"));
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private boolean hasWifi;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32 GB")
                .setStorage("1 TB SSD")
                .setGPU("NVIDIA RTX 4080")
                .setWifi(true)
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8 GB")
                .setStorage("256 GB SSD")
                .build();

        System.out.println("Gaming PC:");
        gamingPC.showDetails();

        System.out.println("\nOffice PC:");
        officePC.showDetails();
    }
}