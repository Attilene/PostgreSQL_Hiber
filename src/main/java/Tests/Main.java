package Tests;

import Tests.models.*;
import Tests.service.*;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        GroupService groupService = new GroupService();
        ScheduleService scheduleService = new ScheduleService();
        TestListService testListService = new TestListService();
        TestService testService = new TestService();
        Role role = roleService.findRole(2);
        System.out.println("Преподаватели:");
        for (User user: userService.findAllUsers())
            if (user.getRole().getRow_id() == role.getRow_id())
                System.out.println(user.getLast_name() + " " +  user.getFirst_name() + " " + user.getMiddle_name());
        Role role1 = roleService.findRole(1);
        System.out.println("Студенты:");
        for (User user: userService.findAllUsers())
            if (user.getRole().getRow_id() == role1.getRow_id())
                System.out.println(user.getLast_name() + " " + user.getFirst_name() + " " + user.getMiddle_name());
        System.out.println("Тесты для каждого студента:");
        for (User user: userService.findAllUsers()) {
            if (user.getRole().getRow_id() == role1.getRow_id()) {
                System.out.println(user.getLast_name() + " " + user.getFirst_name() + " " + user.getMiddle_name());
                System.out.println("Тесты:");
                for (Group group : groupService.findAllGroups()) {
                    if (user.getGroup().getRow_id() == group.getRow_id())
                        for (Schedule schedule : group.getSchedules()) {
                            if (schedule != null) {
                                System.out.println(schedule.getTest_list().getSubject().getName() + ": " + schedule.getTest_list().getName());
                            }
                        }
                }
            }
        }
        System.out.println("Результаты тестирования для каждого студента:");
        for (User user: userService.findAllUsers()) {
            if (user.getRole().getRow_id() == role1.getRow_id()) {
                System.out.println(user.getLast_name() + " " + user.getFirst_name() + " " + user.getMiddle_name());
                System.out.println("Тесты:");
                for (Group group : groupService.findAllGroups()) {
                    if (user.getGroup().getRow_id() == group.getRow_id())
                        for (Schedule schedule : group.getSchedules()) {
                            if (schedule != null) {
                                TestList testList = schedule.getTest_list();
                                Integer result = 0;
                                for (StudentAnswer studentAnswer: testList.getStudent_answers()) {
                                    if (studentAnswer.getUser().getRow_id() == user.getRow_id()) {
                                        Answer answer = studentAnswer.getAnswer();
                                        if (answer.getCorrect() && answer.getQuestion().getActive())
                                            result += answer.getQuestion().getScore();
                                    }
                                }
                                System.out.println(testList.getSubject().getName()
                                        + ": " + testList.getName() + "; Результат: " + result);
                            }
                        }
                }
            }
        }
    }
}
