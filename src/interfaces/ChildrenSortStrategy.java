package interfaces;

import database.Database;

public interface ChildrenSortStrategy {
    /**
     * @param database the database
     */
    void sortChildren(Database database);
}
