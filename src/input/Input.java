package input;
import java.util.List;

public class Input {
    private final Integer numberOfYears;
    private final Double santaBudget;
    private final List<ChildrenInputData> children;
    private final List<SantaGiftsInputData> santaGiftsList;
    private final List<AnnualChangesInputData> annualChanges;

    public Input(final Integer numberOfYears,
                 final Double santaBudget,
                 final List<ChildrenInputData> children,
                 final List<SantaGiftsInputData> santaGiftsList,
                 final List<AnnualChangesInputData> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.children = children;
        this.santaGiftsList = santaGiftsList;
        this.annualChanges = annualChanges;
    }

    public final Integer getNumberOfYears() {
        return numberOfYears;
    }

    public final Double getSantaBudget() {
        return santaBudget;
    }

    public final List<ChildrenInputData> getChildren() {
        return children;
    }

    public final List<SantaGiftsInputData> getSantaGiftsList() {
        return santaGiftsList;
    }

    public final List<AnnualChangesInputData> getAnnualChanges() {
        return annualChanges;
    }

    @Override
    public final String toString() {
        return "Input{"
                + "numberOfYears="
                + numberOfYears
                + ", santaBudget="
                + santaBudget
                + ", children="
                + children
                + ", santaGiftsList="
                + santaGiftsList
                + ", annualChanges="
                + annualChanges
                + '}';
    }
}
