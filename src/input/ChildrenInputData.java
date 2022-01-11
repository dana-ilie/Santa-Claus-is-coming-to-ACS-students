package input;

import java.util.List;

public class ChildrenInputData {
    private Integer id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String city;
    private Double niceScore;
    private List<String> giftsPreferences;

    public ChildrenInputData(final Integer id, final String lastName,
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
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final Integer getAge() {
        return age;
    }

    public final void setAge(final Integer age) {
        this.age = age;
    }

    public final String getCity() {
        return city;
    }

    public final void setCity(final String city) {
        this.city = city;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public final List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @Override
    public final String toString() {
        return "ChildrenInputData{"
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
                + '}';
    }
}
