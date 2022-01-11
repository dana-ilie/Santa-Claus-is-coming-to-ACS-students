package writer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class AnnualChildren {
    @JsonProperty("annualChildren")
    private List<Children> annualChildren = new ArrayList<>();

    public final List<Children> getAnnualChildren() {
        return annualChildren;
    }

    @Override
    public final String toString() {
        return "annualChildren{"
                + "annualChildren="
                + annualChildren
                + '}';
    }
}
