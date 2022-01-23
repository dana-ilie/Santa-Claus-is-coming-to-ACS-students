package visitors;

import common.Constants;
import database.Database;
import interfaces.ChildVisitor;
import interfaces.IChild;

public class BlackElfChildVisitor implements ChildVisitor {
    /**
     * @param child the child to be visited
     */
    @Override
    public void visit(final IChild child) {
        Double budget = child.getAssignedBudget();
        budget = budget - budget * Constants.BLACK_ELF_BUDGET / Constants.ONE_HUNDRED;
        child.setAssignedBudget(budget);
    }

    /**
     * @param child    the child to be visited
     * @param database the database
     */
    @Override
    public void visit(final IChild child, final Database database) {
        System.out.println("BlackElfChildVisitor");
    }
}
