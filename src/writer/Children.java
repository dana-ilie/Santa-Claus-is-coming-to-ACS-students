package writer;

import com.fasterxml.jackson.annotation.JsonProperty;
import interfaces.IChild;

import java.util.List;

public class Children {
    @JsonProperty("children")
    private List<IChild> children;

    public Children(final List<IChild> children) {
        this.children = children;
    }

    @Override
    public final String toString() {
        return "children{"
                + "children="
                + children
                + '}';
    }
}
