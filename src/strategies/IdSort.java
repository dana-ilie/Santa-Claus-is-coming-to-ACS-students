package strategies;

import database.Database;
import interfaces.ChildrenSortStrategy;
import interfaces.IChild;

import java.util.Comparator;

public class IdSort implements ChildrenSortStrategy {
    /**
     * @param database the database
     */
    @Override
    public void sortChildren(final Database database) {
        database.getChildren().sort(Comparator.comparingInt(IChild::getId));
    }
}
