package strategies;

import database.Database;
import entities.City;
import interfaces.ChildrenSortStrategy;
import interfaces.IChild;

import java.util.ArrayList;
import java.util.List;


public class NiceScoreCitySort implements ChildrenSortStrategy {
    /**
     * @param database the database
     */
    @Override
    public void sortChildren(final Database database) {
        database.getAllCities().sort((o1, o2) -> {
            if (Double.compare(o2.getNiceScoreCity(), o1.getNiceScoreCity()) != 0) {
                return Double.compare(o2.getNiceScoreCity(), o1.getNiceScoreCity());
            }
            return o1.getName().compareTo(o2.getName());
        });

        List<IChild> sortedChildren = new ArrayList<>();

        for (City city : database.getAllCities()) {
            sortedChildren.addAll(city.getChildrenFromCity());
        }
        database.setChildren(sortedChildren);
    }
}
