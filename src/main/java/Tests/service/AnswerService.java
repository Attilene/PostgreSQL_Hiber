package Tests.service;

import Tests.dao.AnswerDao;
import Tests.models.Answer;
import Tests.models.Question;

import java.util.List;

public class AnswerService {
    private final AnswerDao answerDao = new AnswerDao();

    public AnswerService() {}

    public Question findQuestion(int id) { return answerDao.findQuestionById(id); }

    public void saveAnswer(Answer answer) { answerDao.save(answer); }

    public void updateAnswer(Answer answer) { answerDao.update(answer); }

    public void deleteAnswer(Answer answer) { answerDao.delete(answer); }

    public List<Answer> findAllAnswers() { return answerDao.findAll(); }

    public Answer findAnswer(int id) { return answerDao.findAnswerById(id); }
}
