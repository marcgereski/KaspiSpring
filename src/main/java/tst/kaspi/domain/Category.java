package tst.kaspi.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> questions;

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
