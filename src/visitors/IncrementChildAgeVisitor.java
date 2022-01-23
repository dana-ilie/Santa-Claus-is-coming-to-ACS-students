package visitors;

import database.Database;
import interfaces.IChild;

public class IncrementChildAgeVisitor implements ChildVisitor {
    @Override
    public void visit(IChild child) {
        child.setAge(child.getAge() + 1);
    }

    @Override
    public void visit(IChild child, Database database) {
    }
}
