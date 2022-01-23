package visitors;

import database.Database;
import interfaces.IChild;

public class PinkElfChildVisitor implements ChildVisitor{
    @Override
    public void visit(IChild child) {
        Double budget = child.getAssignedBudget();
        budget = budget + budget * 30 / 100;
        child.setAssignedBudget(budget);
    }

    @Override
    public void visit(IChild child, Database database) {
    }
}
