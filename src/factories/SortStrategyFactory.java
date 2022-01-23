package factories;

import interfaces.ChildrenSortStrategy;
import strategies.IdSort;
import strategies.NiceScoreCitySort;
import strategies.NiceScoreSort;

public class SortStrategyFactory {
    private static SortStrategyFactory sortStrategyFactory = null;

    /**
     * @return singleton factory
     */
    public static SortStrategyFactory getSortStrategyFactory() {
        if (sortStrategyFactory == null) {
            sortStrategyFactory = new SortStrategyFactory();
        }
        return sortStrategyFactory;
    }

    /**
     * @param strategyType type of strategy string
     * @return a sorting strategy
     */
    public ChildrenSortStrategy createStrategy(final String strategyType) {
        return switch (strategyType) {
            case "id" -> new IdSort();
            case "niceScoreCity" -> new NiceScoreCitySort();
            case "niceScore" -> new NiceScoreSort();
            default -> throw new IllegalArgumentException("Strategy type "
                    + strategyType + "not recognized");
        };
    }
}
