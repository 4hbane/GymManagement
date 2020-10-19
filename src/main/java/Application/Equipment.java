package Application;
import Application.DBClass;


public class Equipment {
    String name;
    String description;


    int count;
    boolean working;

    public Equipment() {
        this.name = "";
        this.description = "";
        this.working = false;
    }

    public Equipment(int id, String name, String description, String image, boolean state) {
        this.name = name;
        this.description = description;
        this.working = state;
    }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isState() { return working; }
    public void setState(boolean state) { this.working = state; }


    @Override
    public String toString() {
        String s = this.name + ": " + this.count + " machines disponible.";
        return s;
    }
}
