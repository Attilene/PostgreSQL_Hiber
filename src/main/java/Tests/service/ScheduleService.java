package Tests.service;

import Tests.dao.ScheduleDao;
import Tests.models.Schedule;

import java.util.List;

public class ScheduleService {
    private final ScheduleDao scheduleDao = new ScheduleDao();

    public  ScheduleService() {}

    public void saveSchedule(Schedule schedule) { scheduleDao.save(schedule); }

    public void updateSchedule(Schedule schedule) { scheduleDao.update(schedule); }

    public void deleteSchedule(Schedule schedule) { scheduleDao.delete(schedule); }

    public List<Schedule> findAllSchedules() { return scheduleDao.findAll(); }

    public Schedule findSchedule(int id) { return scheduleDao.findScheduleById(id); }
}
