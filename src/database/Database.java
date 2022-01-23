package database;

import entities.City;
import entities.Gift;
import factories.IChildFactory;
import factories.SortStrategyFactory;
import input.Input;
import input.ChildUpdateInputData;
import input.ChildrenInputData;
import input.SantaGiftsInputData;
import input.AnnualChangesInputData;
import interfaces.ChildrenSortStrategy;
import interfaces.IChild;
import org.checkerframework.checker.units.qual.C;
import updates.AnnualChange;
import updates.ChildUpdate;
import visitors.CityVisitor;
import visitors.NiceScoreCityVisitor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Database {
    private static Database database = null;
    private Integer numberOfYears;
    private Double santaBudget;
    private List<IChild> children;
    private List<Gift> santaGiftsList;
    private List<AnnualChange> annualChanges;
    private final List<List<IChild>> resultsList;
    private ChildrenSortStrategy sortStrategy;
    private List<City> allCities;

    private Database(final Input input) {
        IChildFactory childFactory = IChildFactory.getIChildFactory();
        children = new ArrayList<>();
        santaGiftsList = new ArrayList<>();
        annualChanges = new ArrayList<>();
        resultsList = new ArrayList<>();

        this.numberOfYears = input.getNumberOfYears();
        this.santaBudget = input.getSantaBudget();

        SortStrategyFactory factory = SortStrategyFactory.getSortStrategyFactory();
        this.sortStrategy = factory.createStrategy("id");

        for (ChildrenInputData child : input.getChildren()) {
            children.add(childFactory.createChild(child.getId(),
                    child.getLastName(), child.getFirstName(),
                    child.getAge(), child.getCity(), child.getNiceScore(),
                    child.getGiftsPreferences(), child.getNiceScoreBonus(),
                    child.getElf()));
        }

        for (IChild child : children) {
            child.getNiceScoreHistory().add(child.getNiceScore());
        }

        addChildrenToCities();

        for (SantaGiftsInputData gift : input.getSantaGiftsList()) {
            santaGiftsList.add(new Gift(gift.getProductName(),
                    gift.getPrice(), gift.getCategory(),
                    gift.getQuantity()));
        }

        for (AnnualChangesInputData change : input.getAnnualChanges()) {
            List<Gift> newGifts = new ArrayList<>();
            List<IChild> newChildren = new ArrayList<>();
            List<ChildUpdate> childrenUpdates = new ArrayList<>();

            for (SantaGiftsInputData gift : change.getNewGifts()) {
                newGifts.add(new Gift(gift.getProductName(),
                        gift.getPrice(), gift.getCategory(),
                        gift.getQuantity()));
            }

            for (ChildrenInputData child : change.getNewChildren()) {
                newChildren.add(childFactory.createChild(child.getId(),
                        child.getLastName(), child.getFirstName(),
                        child.getAge(), child.getCity(), child.getNiceScore(),
                        child.getGiftsPreferences(), child.getNiceScoreBonus(),
                        child.getElf()));
            }

            for (ChildUpdateInputData cUpdate : change.getChildrenUpdates()) {
                childrenUpdates.add(new ChildUpdate(cUpdate.getId(),
                        cUpdate.getNiceScore(), cUpdate.getGiftsPreferences(),
                        cUpdate.getElf()));
            }

            annualChanges.add(new AnnualChange(change.getNewSantaBudget(),
                    newGifts, newChildren, childrenUpdates, change.getStrategyType()));
        }
    }

    public void addChildrenToCities() {
        allCities = new ArrayList<>();
        for (IChild child : children) {
            addChildToCity(child);
        }
    }

    public void addChildToCity(IChild child) {
        boolean isInList = false;

        for (City city : allCities) {
            if (city.getName().equals(child.getCity())) {
                isInList = true;
                /*
                 * add child to childrenFromCity list
                 */
                city.getChildrenFromCity().add(child);
            }
        }

        if (!isInList) {
            /*
             * add city to cities list
             */
            allCities.add(new City(child.getCity()));
            for (City city : allCities) {
                if (city.getName().equals(child.getCity())) {
                    city.getChildrenFromCity().add(child);
                }
            }
        }

        CityVisitor niceScoreVisitor = new NiceScoreCityVisitor();
        for (City city : allCities) {
            city.accept(niceScoreVisitor);
        }

    }

    /**
     * @param input the input
     * @return singleton database
     */
    public static Database getDatabase(final Input input) {
        if (database == null) {
            database = new Database(input);
        }
        return database;
    }

    /**
     * @param index position where to add in the results list
     */
    public void addResults(final int index) {
        IChildFactory childFactory = IChildFactory.getIChildFactory();
        List<IChild> resultChildren = new ArrayList<>();

        for (IChild child : children) {
            addChild(childFactory, resultChildren, child);
        }
        resultChildren.sort(Comparator.comparingInt(IChild::getId));
        resultsList.add(index, resultChildren);
    }

    /**
     * @param childFactory child factory
     * @param resultChildren results children list
     * @param child child to be added to the list
     */
    public void addChild(final IChildFactory childFactory,
                         final List<IChild> resultChildren,
                         final IChild child) {
        List<Double> niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
        List<String> giftPreferences = new ArrayList<>(child.getGiftsPreferences());

        IChild copyChild = childFactory.createChild(child.getId(),
                child.getLastName(), child.getFirstName(),
                child.getAge(), child.getCity(), child.getNiceScore(),
                giftPreferences, child.getNiceScoreBonus(), child.getElf());
        copyChild.setAverageScore(child.getAverageScore());
        copyChild.setNiceScoreHistory(niceScoreHistory);
        copyChild.setAssignedBudget(child.getAssignedBudget());
        copyChild.setReceivedGifts(child.getReceivedGifts());
        copyChild.setNiceScoreBonus(child.getNiceScoreBonus());
        copyChild.setElf(child.getElf());

        resultChildren.add(copyChild);
    }

    @Override
    public String toString() {
        return "Database{"
                +
                "numberOfYears="
                + numberOfYears
                + ", santaBudget="
                + santaBudget
                + ", children="
                + children
                + ", santaGiftsList="
                + santaGiftsList
                + ", annualChanges="
                + annualChanges
                + ", resultsList="
                + resultsList
                + '}';
    }

    public List<City> getAllCities() {
        return allCities;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public List<IChild> getChildren() {
        return children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }

    public List<List<IChild>> getResultsList() {
        return resultsList;
    }

    public void setChildren(final List<IChild> children) {
        this.children = children;
    }

    public void setNumberOfYears(final Integer numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public void setSantaGiftsList(final List<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }

    public void setAnnualChanges(final List<AnnualChange> annualChanges) {
        this.annualChanges = annualChanges;
    }

    public ChildrenSortStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(ChildrenSortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    /**
     * resets the database for the next test input file
     */
    public void resetDatabase() {
        database = null;
    }
}
