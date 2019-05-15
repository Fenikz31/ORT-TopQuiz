package model;

import java.util.List;

public class Question {
    private String Question;
    private List<String> ChoiceList;
    private int AnswerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        this.setQuestion(question);
        this.setChoiceList(choiceList);
        this.setAnswerIndex(answerIndex);
    }

}
