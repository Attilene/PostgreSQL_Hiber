package Tests.service;

import Tests.dao.SubjectDao;
import Tests.models.Subject;

import java.util.List;

public class SubjectService {
    private final SubjectDao subjectDao = new SubjectDao();

    public SubjectService() {}

    public void saveSubject(Subject subject) { subjectDao.save(subject); }

    public void updateSubject(Subject subject) { subjectDao.update(subject); }

    public void deleteSubject(Subject subject) { subjectDao.delete(subject); }

    public List<Subject> findAllSubjects() { return subjectDao.findAll(); }

    public Subject findSubject(int id) { return subjectDao.findSubjectById(id); }
}
