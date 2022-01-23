package simulationflow;

import common.Constants;
import database.Database;
import entities.City;
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
         * calculate niceScoreCity
         */
        for (City city : database.getAllCities()) {
            city.calculateNiceScoreCity();
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
         * apply black and pink elf modifications
         */

        for (IChild child : database.getChildren()) {
            if (child.getElf().equals("black")) {
                Double budget = child.getAssignedBudget();
                budget = budget - budget * 30 / 100;
                child.setAssignedBudget(budget);
            } else if (child.getElf().equals("pink")) {
                Double budget = child.getAssignedBudget();
                budget = budget + budget * 30 / 100;
                child.setAssignedBudget(budget);
            }
        }

        /*
         * apply strategy
         */
        database.getSortStrategy().sortChildren(database);

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

                Gift cheapestFromCategory = new Gift("cheapest", Constants.MIN_PRICE,
                        "category", -1);
                Double minPrice = Constants.MIN_PRICE;
                boolean found = false;

                for (Gift santaGift : database.getSantaGiftsList()) {
                    if (santaGift.getCategory().equals(gPreference)) {
                        if (santaGift.getQuantity() > 0) {
                            found = true;
                            if (santaGift.getPrice() < minPrice) {
                                cheapestFromCategory = santaGift;
                                minPrice = santaGift.getPrice();
                            }
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
                        cheapestFromCategory.setQuantity(cheapestFromCategory.getQuantity() - 1);
                        child.getReceivedGifts().add(cheapestFromCategory);
                    }
                }
            }
        }

        /*
         * apply yellow elf modifications
         */
        for (IChild child : database.getChildren()) {
            if (child.getElf().equals("yellow")) {
                /*
                 * check if the child received a gift
                 */
                if (child.getReceivedGifts().size() == 0) {
                    String gPreference = child.getGiftsPreferences().get(0);
                    /*
                     * find the cheapest gift in santaGiftsList
                     * from gPreference category
                     */

                    Gift cheapestFromCategory = new Gift("cheapest", Constants.MIN_PRICE,
                            "category", -1);
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
                     * if a gift was found and is in stock
                     */
                    if (found && cheapestFromCategory.getQuantity() > 0) {
                        /*
                         * assign gift to child
                         */
                        cheapestFromCategory.setQuantity(cheapestFromCategory.getQuantity() - 1);
                        child.getReceivedGifts().add(cheapestFromCategory);
                    }
                }
            }
        }

    }
}
