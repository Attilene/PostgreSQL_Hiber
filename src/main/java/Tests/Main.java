package Tests;

import Tests.models.Group;
import Tests.models.Schedule;
import Tests.models.User;
import Tests.service.GroupService;
import Tests.service.ScheduleService;
import Tests.service.UserService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ScheduleService scheduleService = new ScheduleService();
        GroupService groupService = new GroupService();
//        User user = userService.findUser(1);
//        System.out.println(user.getLogin());
        for (Group group: groupService.findAllGroups())
            System.out.println(group.getName());
        for (Schedule schedule: scheduleService.findAllSchedules())
            System.out.println(schedule);
    }
}
