package Application;

public class Reclamation {

    String object;
    String text;

    public Reclamation() {
        object = "";
        text = "" ;
    }

    public Reclamation(String object, String text) {
        this.object = object;
        this.text = text;
    }

    public String getObject() { return object; }
    public void setObject(String object) { this.object = object; }


    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    @Override
    public String toString() {
        return "" + object+ ": " +  text;
    }
}
