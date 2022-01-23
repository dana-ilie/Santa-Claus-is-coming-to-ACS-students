package builders;

import com.fasterxml.jackson.annotation.JsonIgnore;
import entities.Gift;
import interfaces.IChild;

import java.util.ArrayList;
import java.util.List;

public class ChildBuilder {
    private Integer id; // mandatory
    private String lastName; // mandatory
    private String firstName; // mandatory
    private Integer age; // mandatory
    private String city; // mandatory
    private Double niceScore; // mandatory
    private List<String> giftsPreferences; // mandatory
    private Double averageScore; // mandatory
    private List<Double> niceScoreHistory; // mandatory
    private Double assignedBudget; // mandatory
    private List<Gift> receivedGifts; // mandatory
    private Double niceScoreBonus; // optional
    private String elf; // mandatory

    public ChildBuilder(final Integer id, final String lastName,
                final String firstName, final Integer age,
                final String city, final Double niceScore,
                final List<String> giftsPreferences,
                final String elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
        this.niceScoreBonus = 0.0;
        this.elf = elf;
    }

    public ChildBuilder addNiceScoreBonus(Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public String getElf() {
        return elf;
    }
}
