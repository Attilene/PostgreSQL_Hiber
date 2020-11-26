package Tests.service;

import Tests.dao.QuestionDao;
import Tests.models.Question;

import java.util.List;

public class QuestionService {
    private final QuestionDao questionDao = new QuestionDao();

    public QuestionService() {}

    public void saveQuestion(Question question) { questionDao.save(question); }

    public void updateQuestion(Question question) { questionDao.update(question); }

    public void deleteQuestion(Question question) { questionDao.delete(question); }

    public List<Question> findAllQuestions() { return questionDao.findAll(); }

    public Question findQuestion(int id) { return questionDao.findQuestionById(id); }
}
