package src.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String birthDay;

    public User(int id, String username, String password, String birthDay) {
        this.id = id;
        this.username = username;
        this.password =  password;
        this.birthDay = birthDay;
    }

    public User(String username, String password, String birthDay) {
        this.username = username;
        this.password =  password;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
