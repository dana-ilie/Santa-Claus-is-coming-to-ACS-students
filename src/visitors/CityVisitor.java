package visitors;

import entities.City;

public interface CityVisitor {
    void visit(City city);
}
