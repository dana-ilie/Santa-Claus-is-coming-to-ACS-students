package entities;

import interfaces.IChild;
import interfaces.CityVisitor;

import java.util.ArrayList;
import java.util.List;

public class City {
    private final String name;
    private Double niceScoreCity;
    private final List<IChild> childrenFromCity;

    public City(final String name) {
        this.name = name;
        this.niceScoreCity = 0.0;
        childrenFromCity = new ArrayList<>();
    }

    /**
     * @param visitor city visitor
     */
    public void accept(final CityVisitor visitor) {
        visitor.visit(this);
    }

    public final String getName() {
        return name;
    }

    public final Double getNiceScoreCity() {
        return niceScoreCity;
    }

    public final List<IChild> getChildrenFromCity() {
        return childrenFromCity;
    }

    public final void setNiceScoreCity(final Double niceScoreCity) {
        this.niceScoreCity = niceScoreCity;
    }
}
