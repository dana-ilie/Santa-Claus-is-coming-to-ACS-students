package visitors;

import database.Database;
import interfaces.IChild;

public interface ChildVisitor {
    void visit (final IChild child);
    void visit(final  IChild child, Database database);
}
