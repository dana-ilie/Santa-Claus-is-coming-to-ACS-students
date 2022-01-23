package updates;

import entities.Gift;
import interfaces.IChild;

import java.util.List;

public class AnnualChange {
    private Double newSantaBudget;
    private List<Gift> newGifts;
    private List<IChild> newChildren;
    private List<ChildUpdate> childrenUpdates;
    private final String strategyType;

    public AnnualChange(final Double newSantaBudget,
                        final List<Gift> newGifts,
                        final List<IChild> newChildren,
                        final List<ChildUpdate> childrenUpdates,
                        final String strategyType) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
        this.strategyType = strategyType;
    }

    @Override
    public final String toString() {
        return "AnnualChange{"
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

    public final Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public final void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public final List<Gift> getNewGifts() {
        return newGifts;
    }

    public final void setNewGifts(final List<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public final List<IChild> getNewChildren() {
        return newChildren;
    }

    public final void setNewChildren(final List<IChild> newChildren) {
        this.newChildren = newChildren;
    }

    public final List<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public final void setChildrenUpdates(final List<ChildUpdate> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }

    public final String getStrategyType() {
        return strategyType;
    }
}
