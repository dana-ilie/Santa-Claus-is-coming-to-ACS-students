package factories;

import common.Constants;
import entities.Baby;
import entities.Kid;
import entities.Teen;
import entities.YoungAdult;
import interfaces.IChild;

import java.util.List;

public final class IChildFactory {
    private static IChildFactory childFactory = null;

    /**
     * @return singleton factory
     */
    public static IChildFactory getIChildFactory() {
        if (childFactory == null) {
            childFactory = new IChildFactory();
        }
        return childFactory;
    }

    /**
     * @param id child id
     * @param lastName child last name
     * @param firstName child first name
     * @param age child age
     * @param city child where the city is from
     * @param niceScore child nice score
     * @param giftsPreferences child gifts preferences
     * @return a child instance
     */
    public IChild createChild(final Integer id, final String lastName,
                                     final String firstName, final Integer age,
                                     final String city, final Double niceScore,
                                     final List<String> giftsPreferences) {
        if (age < Constants.BABY_AGE_LIMIT) {
            return new Baby(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        } else if (age < Constants.KID_AGE_LIMIT) {
            return new Kid(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        } else if (age <= Constants.TEEN_AGE_LIMIT) {
            return new Teen(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        } else {
            return new YoungAdult(id, lastName, firstName, age, city, niceScore, giftsPreferences);
        }
    }
}
