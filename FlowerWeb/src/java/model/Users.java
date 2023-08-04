package model;

public class Users {
    private int ID;
    private String name;
    private String email;
    private String password;
    private int role;

    // Constructors
    public Users() {
    }

    public Users(int ID, String name, String email, String password, int role) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" + "ID=" + ID + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + '}';
    }
}
