package strategies;

import database.Database;
import entities.City;
import factories.IChildFactory;
import interfaces.ChildrenSortStrategy;
import interfaces.IChild;

import java.util.ArrayList;
import java.util.List;


public class NiceScoreCitySort implements ChildrenSortStrategy {
    @Override
    public void sortChildren(Database database) {
        database.getAllCities().sort((o1, o2) -> {
            if (Double.compare(o2.getNiceScoreCity(), o1.getNiceScoreCity()) != 0) {
                return Double.compare(o2.getNiceScoreCity(), o1.getNiceScoreCity());
            }
            return o1.getName().compareTo(o2.getName());
        });

        List<IChild> sortedChildren = new ArrayList<>();

        for (City city : database.getAllCities()) {
            sortedChildren.addAll(city.getChildrenFromCity());
//            for (IChild child : city.getChildrenFromCity()) {
//                database.addChild(IChildFactory.getIChildFactory(), sortedChildren, child);
//            }
        }
        database.setChildren(sortedChildren);
    }
}
