package visitors;

import database.Database;
import interfaces.ChildVisitor;
import interfaces.IChild;

public class IncrementChildAgeVisitor implements ChildVisitor {
    /**
     * @param child the child to be visited
     */
    @Override
    public void visit(final IChild child) {
        child.setAge(child.getAge() + 1);
    }

    /**
     * @param child    the child to be visited
     * @param database the database
     */
    @Override
    public void visit(final IChild child, final Database database) {
        System.out.println("IncrementChildAgeVisitor");
    }
}
