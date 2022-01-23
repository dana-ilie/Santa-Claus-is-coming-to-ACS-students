package strategies;

import database.Database;
import interfaces.ChildrenSortStrategy;
import interfaces.IChild;

import java.util.Comparator;

public class IdSort implements ChildrenSortStrategy {
    @Override
    public void sortChildren(Database database) {
        database.getChildren().sort(Comparator.comparingInt(IChild::getId));
    }
}
