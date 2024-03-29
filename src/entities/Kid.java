package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import common.Constants;
import database.Database;
import interfaces.IChild;
import interfaces.ChildVisitor;

import java.util.ArrayList;
import java.util.List;

public class Kid implements IChild {
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
    @JsonIgnore
    private Double niceScoreBonus;
    @JsonIgnore
    private String elf;

    public Kid(final Integer id, final String lastName,
               final String firstName, final Integer age,
               final String city, final Double niceScore,
               final List<String> giftsPreferences,
               final Double niceScoreBonus, final String elf) {
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
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
    }

    /**
     * calculates average score for a kid
     */
    @Override
    public void calculateAverageScore() {
        Double sum = 0.0;
        for (Double score : niceScoreHistory) {
            sum += score;
        }
        this.averageScore = sum / niceScoreHistory.size();
        this.averageScore += this.averageScore * niceScoreBonus / Constants.ONE_HUNDRED;
        if (this.averageScore > Constants.MAX_AVERAGE) {
            this.averageScore = Constants.MAX_AVERAGE;
        }
    }

    /**
     * @param visitor child visitor
     */
    @Override
    public void accept(final ChildVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * @param visitor  child visitor
     * @param database the database
     */
    @Override
    public void accept(final ChildVisitor visitor, final Database database) {
        visitor.visit(this, database);
    }

    @Override
    public final String toString() {
        return "Kid{"
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
                + ", niceScoreBonus="
                + niceScoreBonus
                + ", elf="
                + elf
                + '}';
    }

    @Override
    public final Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    @Override
    public final void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    @Override
    public final String getElf() {
        return elf;
    }

    @Override
    public final void setElf(final String elf) {
        this.elf = elf;
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
