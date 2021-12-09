package builder;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .firstName("Daria")
                .age(18)
                .occupation("UCU")
                .lastName("Kuzmina")
                .build();
        System.out.println(user);
    }
}