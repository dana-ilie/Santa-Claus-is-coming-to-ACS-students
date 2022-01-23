package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import common.Constants;
import database.Database;
import interfaces.IChild;
import visitors.ChildVisitor;

import java.util.ArrayList;
import java.util.List;

public class Baby implements IChild{
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

    public Baby(final Integer id, final String lastName,
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
     * calculates average score for a baby
     */
    @Override
    public void calculateAverageScore() {
        double avg = Constants.BABY_AVERAGE;
        avg += avg * niceScoreBonus / 100;
        if (avg > 10.0) {
            avg = 10.0;
        }
        this.averageScore = avg;

    }

    @Override
    public void accept(ChildVisitor visitor) {
        visitor.visit(this);
    }

    public void accept(ChildVisitor visitor, Database database) {
        visitor.visit(this, database);
    }

    @Override
    public final String toString() {
        return "Baby{"
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

    public final Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public final void setNiceScoreBonus(Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public final String getElf() {
        return elf;
    }

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
