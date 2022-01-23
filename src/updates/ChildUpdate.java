package updates;
import java.util.List;

public class ChildUpdate {
    private Integer id;
    private Double niceScore;
    private List<String> giftsPreferences;
    private String elf;

    public ChildUpdate(final Integer id, final Double niceScore,
                       final List<String> giftsPreferences,
                       final String elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.elf = elf;
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public final List<String> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final List<String> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public final String getElf() {
        return elf;
    }

    public final void setElf(final String elf) {
        this.elf = elf;
    }

}
