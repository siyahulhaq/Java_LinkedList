public class User {
    public String name;
    public String email;

    User (String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Email: "+email;
    }
}
