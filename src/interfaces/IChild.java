package interfaces;

import entities.Gift;
import java.util.List;

public interface IChild {

    /**
     * @return child id
     */
    Integer getId();

    /**
     * @param id child id
     */
    void setId(Integer id);

    /**
     * @return child last name
     */
    String getLastName();

    /**
     * @param lastName child last name
     */
    void setLastName(String lastName);

    /**
     * @return child first name
     */
    String getFirstName();

    /**
     * @param firstName child first name
     */
    void setFirstName(String firstName);

    /**
     * @return child age
     */
    Integer getAge();

    /**
     * @param age child age
     */
    void setAge(Integer age);

    /**
     * @return child city
     */
    String getCity();

    /**
     * @param city child city
     */
    void setCity(String city);

    /**
     * @return child nice score
     */
    Double getNiceScore();

    /**
     * @param niceScore child nice score
     */
    void setNiceScore(Double niceScore);

    /**
     * @return child gifts preferences
     */
    List<String> getGiftsPreferences();

    /**
     * @param giftsPreferences child preferences
     */
    void setGiftsPreferences(List<String> giftsPreferences);

    /**
     * @return child average score
     */
    Double getAverageScore();

    /**
     * @return nice score history list
     */
    List<Double> getNiceScoreHistory();

    /**
     * @return child assigned budget
     */
    Double getAssignedBudget();

    /**
     * @return child received gifts list
     */
    List<Gift> getReceivedGifts();

    /**
     * @param assignedBudget child budget for gifts
     */
    void setAssignedBudget(Double assignedBudget);

    /**
     * calculates average score for a child
     */
    void calculateAverageScore();

    /**
     * @param averageScore child average score
     */
    void setAverageScore(Double averageScore);

    /**
     * @param niceScoreHistory nice score history list
     */
    void setNiceScoreHistory(List<Double> niceScoreHistory);

    /**
     * @param receivedGifts child received gifts list
     */
    void setReceivedGifts(List<Gift> receivedGifts);

    /**
     * @return nice score bonus
     */
    Double getNiceScoreBonus();

    /**
     * @param niceScoreBonus nice score bonus to be set
     */
    void setNiceScoreBonus(final Double niceScoreBonus);

    /**
     * @return type of elf
     */
    String getElf();

    /**
     * @param elf type of elf
     */
    void setElf(final String elf);

}
