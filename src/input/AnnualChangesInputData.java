package input;
import java.util.List;

public class AnnualChangesInputData {
    private final Double newSantaBudget;
    private final List<SantaGiftsInputData> newGifts;
    private List<ChildrenInputData> newChildren;
    private List<ChildUpdateInputData> childrenUpdates;
    private String strategyType;

    public AnnualChangesInputData(final Double newSantaBudget,
                                  final List<SantaGiftsInputData> newGifts,
                                  final List<ChildrenInputData> newChildren,
                                  final List<ChildUpdateInputData> childrenUpdates,
                                  final String strategyType) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategyType = strategyType;
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

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
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
