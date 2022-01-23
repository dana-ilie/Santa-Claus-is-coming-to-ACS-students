package visitors;

import common.Constants;
import database.Database;
import entities.Gift;
import interfaces.IChild;

public class YellowElfChildVisitor implements ChildVisitor{
    @Override
    public void visit(IChild child, Database database) {
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

    @Override
    public void visit(IChild child) {
    }
}
