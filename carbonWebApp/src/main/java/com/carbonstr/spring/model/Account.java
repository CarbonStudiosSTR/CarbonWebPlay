package com.carbonstr.spring.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @SequenceGenerator(name = "account_seq", sequenceName = "account_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    private int id;
    private String name;
    private String email;
    private String password;
    @Column(name = "create_date")
    private Date creationDate;
    @Column(name = "security_question")
    private String securityQuestion;
    @Column(name = "security_answer")
    private String securityAnswer;
    private boolean active;
    private boolean premium;

    @OneToMany(mappedBy = "id")
    private Set<Character> characters;

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
