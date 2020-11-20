import models.Auto;
import models.User;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User("Artem", 19);
        userService.saveUser(user);
        System.out.println(user);
        Auto ferrari = new Auto("Ferrari", "red");
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
        user.setName("Dmitriy");
        userService.updateUser(user);
        System.out.println(user);
    }
}
