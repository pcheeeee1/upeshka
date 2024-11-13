import java.awt.Graphics;

public class TFishSchool {
    private TFish head; // Указатель на первую рыбку в стае

    public TFishSchool() {
        this.head = null;
    }

    public void addFish(TFish fish) {
        fish.next = head;
        head = fish;
    }

    public void displaySchool(Graphics g) {
        TFish current = head;
        while (current != null) {
            current.draw(g);
            current = current.next;
        }
    }

    public void runSchool() {
        TFish current = head;
        while (current != null) {
            current.run();
            current = current.next;
        }
    }
}
