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

    //Insert necessary getters and setters

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public List<String> getChoiceList() {
        return ChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        ChoiceList = choiceList;
    }

    public int getAnswerIndex() {
        return AnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        AnswerIndex = answerIndex;
    }

    public String toString() {
        return "je suis une question";
    }
}
