package Tests.service;

import Tests.dao.StudentAnswerDao;
import Tests.models.StudentAnswer;

import java.util.List;

public class StudentAnswerService {
    private final StudentAnswerDao studentAnswerDao = new StudentAnswerDao();

    public StudentAnswerService() {}

    public void saveStudentAnswer(StudentAnswer studentAnswer) { studentAnswerDao.save(studentAnswer); }

    public void updateStudentAnswer(StudentAnswer studentAnswer) { studentAnswerDao.update(studentAnswer); }

    public void deleteStudentAnswer(StudentAnswer studentAnswer) { studentAnswerDao.delete(studentAnswer); }

    public List<StudentAnswer> findAllStudentAnswers() { return studentAnswerDao.findAll(); }

    public StudentAnswer findStudentAnswer(int id) { return studentAnswerDao.findStudentAnswerById(id); }
}
