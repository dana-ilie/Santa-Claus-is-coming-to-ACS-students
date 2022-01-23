package factories;

import interfaces.ChildrenSortStrategy;
import strategies.IdSort;
import strategies.NiceScoreCitySort;
import strategies.NiceScoreSort;

public class SortStrategyFactory {
    private static SortStrategyFactory sortStrategyFactory = null;

    public static SortStrategyFactory getSortStrategyFactory() {
        if (sortStrategyFactory == null) {
            sortStrategyFactory = new SortStrategyFactory();
        }
        return sortStrategyFactory;
    }

    public ChildrenSortStrategy createStrategy(String strategyType) {
        switch (strategyType) {
            case "id":
                return new IdSort();
            case "niceScoreCity":
                return new NiceScoreCitySort();
            case "niceScore":
                return new NiceScoreSort();
        }
        throw new IllegalArgumentException("Strategy type " + strategyType + "not recognized");
    }
}
