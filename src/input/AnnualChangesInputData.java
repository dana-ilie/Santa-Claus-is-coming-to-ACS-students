package input;
import java.util.List;

public class AnnualChangesInputData {
    private final Double newSantaBudget;
    private final List<SantaGiftsInputData> newGifts;
    private List<ChildrenInputData> newChildren;
    private List<ChildUpdateInputData> childrenUpdates;

    public AnnualChangesInputData(final Double newSantaBudget,
                        final List<SantaGiftsInputData> newGifts,
                        final List<ChildrenInputData> newChildren,
                        final List<ChildUpdateInputData> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }



    public final Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public final List<SantaGiftsInputData> getNewGifts() {
        return newGifts;
    }

    public final List<ChildrenInputData> getNewChildren() {
        return newChildren;
    }

    public final void setNewChildren(final List<ChildrenInputData> newChildren) {
        this.newChildren = newChildren;
    }

    public final List<ChildUpdateInputData> getChildrenUpdates() {
        return childrenUpdates;
    }

    public final void setChildrenUpdates(final List<ChildUpdateInputData> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    @Override
    public final String toString() {
        return "AnnualChangesInputData{"
                + "newSantaBudget="
                + newSantaBudget
                + ", newGifts="
                + newGifts
                + ", newChildren="
                + newChildren
                + ", childrenUpdates="
                + childrenUpdates
                + '}';
    }
}
