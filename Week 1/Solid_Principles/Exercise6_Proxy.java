interface Image {
    void display();
}

class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + fileName + " from remote server...");
    }

    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

class ProxyImage implements Image {
    private final String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

public class Exercise6_Proxy {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.png");
        Image image2 = new ProxyImage("photo2.png");

        System.out.println("Images created, nothing loaded yet.\n");

        System.out.println("First call to image1.display():");
        image1.display();

        System.out.println("\nSecond call to image1.display():");
        image1.display();

        System.out.println("\nFirst call to image2.display():");
        image2.display();
    }
}
