package simulationflow;

import common.Constants;
import database.Database;
import entities.Gift;
import interfaces.IChild;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InitialRound {
    /**
     * @param database the database
     */
    public void executeInitialRound(final Database database) {
        database.getChildren().removeIf(x -> x.getAge() > Constants.TEEN_AGE_LIMIT);
        database.getChildren().sort(Comparator.comparingInt(IChild::getId));

        /*
         * calculate average score for each child
         */
        for (IChild child : database.getChildren()) {
            child.calculateAverageScore();
        }

        /*
         * calculate budget for each child
         */
        Double avgSum = 0.0;
        for (IChild child : database.getChildren()) {
            avgSum += child.getAverageScore();
        }

        for (IChild child : database.getChildren()) {
            Double budgetUnit = database.getSantaBudget() / avgSum;
            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
        }

        /*
         * assign presents
         */

        for (IChild child : database.getChildren()) {
            /*
             * reset received gifts
             */
            List<Gift> receivedGifts = new ArrayList<>();
            child.setReceivedGifts(receivedGifts);

            Double assignedBudget = child.getAssignedBudget();

            for (String gPreference : child.getGiftsPreferences()) {
                /*
                 * find the cheapest gift(within budget) in santaGiftsList
                 * from gPreference category
                 */

                Gift cheapestFromCategory = new Gift("cheapest", Constants.MIN_PRICE, "category");
                Double minPrice = Constants.MIN_PRICE;
                boolean found = false;

                for (Gift santaGift : database.getSantaGiftsList()) {
                    if (santaGift.getCategory().equals(gPreference)) {
                        found = true;
                        if (santaGift.getPrice() < minPrice) {
                            cheapestFromCategory = santaGift;
                            minPrice = santaGift.getPrice();
                        }
                    }
                }

                /*
                 * if a gift was found
                 */
                if (found) {
                    /*
                     * check if the gift is within budget
                     */
                    if (assignedBudget - cheapestFromCategory.getPrice() >= 0) {
                        /*
                         * assign gift to child
                         */
                        assignedBudget -= cheapestFromCategory.getPrice();
                        child.getReceivedGifts().add(cheapestFromCategory);
                    }
                }
            }
        }

    }
}
