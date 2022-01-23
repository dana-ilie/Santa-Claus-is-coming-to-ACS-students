package interfaces;

import entities.City;

public interface CityVisitor {
    /**
     * @param city the city to be visited
     */
    void visit(City city);
}
