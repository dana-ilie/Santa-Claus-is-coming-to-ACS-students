package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import interfaces.IChild;

import java.util.ArrayList;
import java.util.List;

public class YoungAdult implements IChild {
    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String city;
    @JsonIgnore
    private Double niceScore;
    private List<String> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;

    public YoungAdult(final Integer id, final String lastName,
                      final String firstName, final Integer age,
                      final String city, final Double niceScore,
                      final List<String> giftsPreferences) {
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
    }

    /**
     * calculates average score for a young adult
     */
    @Override
    public void calculateAverageScore() {
        this.averageScore = -1.0;
    }

    @Override
    public final String toString() {
        return "YoungAdult{"
                + "id="
                + id
                + ", lastName='"
                + lastName
                + '\''
                + ", firstName='"
                + firstName
                + '\''
                + ", age="
                + age
                + ", city='"
                + city
                + '\''
                + ", niceScore="
                + niceScore
                + ", giftsPreferences="
                + giftsPreferences
                + ", averageScore="
                + averageScore
                + ", niceScoreHistory="
                + niceScoreHistory
                + ", assignedBudget="
                + assignedBudget
                + ", receivedGifts="
                + receivedGifts
                + '}';
    }

    @Override
    public final Integer getId() {
        return id;
    }

    @Override
    public final void setId(final Integer id) {
        this.id = id;
    }

    @Override
    public final String getLastName() {
        return lastName;
    }

    @Override
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public final String getFirstName() {
        return firstName;
    }

    @Override
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @Override
    public final Integer getAge() {
        return age;
    }

    @Override
    public final void setAge(final Integer age) {
        this.age = age;
    }

    @Override
    public final String getCity() {
        return city;
    }

    @Override
    public final void setCity(final String city) {
        this.city = city;
    }

    @Override
    public final Double getNiceScore() {
        return niceScore;
    }

    @Override
    public final void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    @Override
    public final List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    @Override
    public final void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @Override
    public final Double getAverageScore() {
        return averageScore;
    }

    @Override
    public final List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    @Override
    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    @Override
    public final List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    @Override
    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    @Override
    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public final void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    @Override
    public final void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
