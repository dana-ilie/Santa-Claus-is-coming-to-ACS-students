package visitors;

import entities.City;
import interfaces.CityVisitor;
import interfaces.IChild;

import java.util.Comparator;

public class NiceScoreCityVisitor implements CityVisitor {
    /**
     * @param city the city to be visited
     */
    @Override
    public void visit(final City city) {
        double niceScoreCity;
        city.getChildrenFromCity().sort(Comparator.comparingInt(IChild::getId));

        Double sum = 0.0;
        for (IChild child : city.getChildrenFromCity()) {
            sum += child.getAverageScore();
        }
        niceScoreCity = sum / city.getChildrenFromCity().size();
        city.setNiceScoreCity(niceScoreCity);
    }
}
