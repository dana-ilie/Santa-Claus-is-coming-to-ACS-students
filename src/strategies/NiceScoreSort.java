package strategies;

import database.Database;
import interfaces.ChildrenSortStrategy;

public class NiceScoreSort implements ChildrenSortStrategy {
    /**
     * @param database the database
     */
    @Override
    public void sortChildren(final Database database) {
        database.getChildren().sort((o1, o2) -> {
            if (Double.compare(o2.getAverageScore(), o1.getAverageScore()) != 0) {
                return Double.compare(o2.getAverageScore(), o1.getAverageScore());
            }
            return o1.getId() - o2.getId();
        });
    }
}
