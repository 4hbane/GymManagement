package Application;


// Users Id is supposedly their email.


import javafx.scene.Scene;

public class User {
    private String email;
    private String name;
    private String password;
    private String phone;
    private String type;
    private boolean paid;
    private int ranking;

    public User() {
        this.email = "";
        this.name = "";
        this.password = "";
        this.phone = "";
        this.type = "Adherent";
        this.paid = false;
        this.ranking = 0;
    }

    public User(String first_name, String last_name, String password, String email, String phone) {
        this.email = email;
        this.name = first_name + " " + last_name;
        this.password = password;
        this.phone = phone;
        this.type = "Adherent";
        this.ranking = 0;
        this.paid = false;

    }

    public String toString() {
        return this.name;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean getPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }


    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
