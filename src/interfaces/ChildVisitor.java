package interfaces;

import database.Database;

public interface ChildVisitor {
    /**
     * @param child the child to be visited
     */
    void visit(IChild child);

    /**
     * @param child the child to be visited
     * @param database the database
     */
    void visit(IChild child, Database database);
}
