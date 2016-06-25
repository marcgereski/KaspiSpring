package tst.kaspi.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ANSWERS")
public class Answer {
    @Id
    @Column(name = "ANSWER_ID")
    private Long answerId;

    @Column(name = "INFORMATION")
    private String information;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Answer() {
    }

    public Answer(String information, Date date, Question question, User user) {
        this.information = information;
        this.date = date;
        this.question = question;
        this.user = user;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
