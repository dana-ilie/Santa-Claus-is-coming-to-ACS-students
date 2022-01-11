package simulationflow;

import common.Constants;
import database.Database;
import entities.Gift;
import factories.IChildFactory;
import interfaces.IChild;
import updates.AnnualChange;
import updates.ChildUpdate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StandardRound {
    /**
     * @param database the database
     * @param update the update to be executed
     */
    public void executeStandardRound(final Database database,
                                     final AnnualChange update) {
        IChildFactory childFactory = IChildFactory.getIChildFactory();
        List<IChild> children = new ArrayList<>();

        for (IChild child : database.getChildren()) {
            /*
             * increment age and remove young adults
             */
            child.setAge(child.getAge() + 1);
        }
        database.getChildren().removeIf(x -> x.getAge() > Constants.TEEN_AGE_LIMIT);


        for (IChild child : database.getChildren()) {
            database.addChild(childFactory, children, child);
        }

        /*
         * sort children list by id
         */
        children.sort(Comparator.comparingInt(IChild::getId));
        database.setChildren(children);

        /*
         * execute updates
         */

        database.setSantaBudget(update.getNewSantaBudget());

        for (Gift newGift : update.getNewGifts()) {
            database.getSantaGiftsList().add(newGift);
        }

        for (IChild newChild : update.getNewChildren()) {
            if (newChild.getAge() <= Constants.TEEN_AGE_LIMIT) {
                newChild.getNiceScoreHistory().add(newChild.getNiceScore());
                database.getChildren().add(newChild);
            }
        }

        for (ChildUpdate cUpdate : update.getChildrenUpdates()) {
            /*
             * find the child to be updated
             */
            for (IChild child : database.getChildren()) {
                if (child.getId().equals(cUpdate.getId())) {
                    /*
                     * execute update on child
                     */
                    if (cUpdate.getNiceScore() != null) {
                        child.getNiceScoreHistory().add(cUpdate.getNiceScore());
                    }

                    /*
                     * delete old appearances of preferences
                     */

                    for (String newPreference : cUpdate.getGiftsPreferences()) {
                        child.getGiftsPreferences().removeIf(x -> x.equals(newPreference));
                    }
                    child.getGiftsPreferences().addAll(0, cUpdate.getGiftsPreferences());
                    int size = child.getGiftsPreferences().size();
                    for (int i = size - 1; i >= 0; i--) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (child.getGiftsPreferences().get(i)
                                    .equals(child.getGiftsPreferences().get(j))) {
                                child.getGiftsPreferences().remove(i);
                            }
                        }
                    }
                }
            }
        }

        InitialRound initialRound = new InitialRound();
        initialRound.executeInitialRound(database);


    }
}
