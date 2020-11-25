package Tests;

import Tests.models.Question;
import Tests.service.AnswerService;
import Tests.service.QuestionService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuestionService questionService = new QuestionService();
        AnswerService answerService = new AnswerService();
//        List<Question> questions = questionService.findAllQuestions();
//        System.out.println(questions.toString());
    }
}
