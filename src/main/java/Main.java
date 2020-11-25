import models.Auto;
import models.User;
import service.AutoService;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        AutoService autoService = new AutoService();
        User user = new User("Artem", 19);
        userService.saveUser(user);
//        System.out.println(user);
        Auto lamborghini = new Auto("Lamborghini", "yellow");
        user.addAuto(lamborghini);
        userService.updateUser(user);
        lamborghini.setColor("red");
        autoService.saveAuto(lamborghini);
        Auto nissan = new Auto("Nissan", "gray");
        user.addAuto(nissan);
        userService.updateUser(user);
//        autoService.saveAuto(nissan);
        nissan.setColor("blue");
        autoService.updateAuto(nissan);
        System.out.println(autoService.findUser(lamborghini.getUser().getId()).getName());
//        userService.updateUser(user);
//        user.setName("Dmitriy");
//        userService.updateUser(user);
//        System.out.println(user);
    }
}
