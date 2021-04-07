package cn.cuit.exam.domain;

public class User {
    protected String username;
    protected String password;
    private char role;

    public User(String username, String password, char role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String passward) {
        this.username = username;
        this.password = passward;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
