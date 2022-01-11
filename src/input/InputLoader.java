package input;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputLoader {
    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * @return input instance
     */
    public Input readData() {
        JSONParser jsonParser = new JSONParser();
        int numberOfYears = 0;
        double santaBudget = 0.0;
        List<ChildrenInputData> children = new ArrayList<>();
        List<SantaGiftsInputData> santaGiftsList = new ArrayList<>();
        List<AnnualChangesInputData> annualChanges = new ArrayList<>();

        try {
            JSONObject jsonObject = (JSONObject) jsonParser
                    .parse(new FileReader(inputPath));

            numberOfYears = Integer.parseInt(jsonObject.get("numberOfYears").toString());
            santaBudget = ((Long) jsonObject.get("santaBudget")).doubleValue();

            JSONObject jsonInitialData = (JSONObject) jsonObject.get("initialData");
            JSONArray jsonChildren = (JSONArray) jsonInitialData.get("children");
            JSONArray jsonSantaGiftsList = (JSONArray) jsonInitialData.get("santaGiftsList");
            JSONArray jsonAnnualChanges = (JSONArray) jsonObject.get("annualChanges");

            if (jsonChildren != null) {
                for (Object jsonChild : jsonChildren) {
                    children.add(new ChildrenInputData(
                            Integer.parseInt(((JSONObject) jsonChild).get("id").toString()),
                            (String) ((JSONObject) jsonChild).get("lastName"),
                            (String) ((JSONObject) jsonChild).get("firstName"),
                            Integer.parseInt(((JSONObject) jsonChild).get("age").toString()),
                            (String) ((JSONObject) jsonChild).get("city"),
                            Double.parseDouble(((JSONObject) jsonChild).get("niceScore")
                                    .toString()),
                            Utils.convertJSONArray((JSONArray) ((JSONObject) jsonChild)
                                    .get("giftsPreferences"))
                    ));
                }
            } else {
                System.out.println("No children");
            }

            if (jsonSantaGiftsList != null) {
                for (Object jsonGift : jsonSantaGiftsList) {
                    santaGiftsList.add(new SantaGiftsInputData(
                            (String) ((JSONObject) jsonGift).get("productName"),
                            Double.parseDouble(((JSONObject) jsonGift).get("price").toString()),
                            (String) ((JSONObject) jsonGift).get("category")
                    ));
                }
            } else {
                System.out.println("No gifts");
            }

            if (jsonAnnualChanges != null) {
                for (Object jsonChange : jsonAnnualChanges) {
                    annualChanges.add(new AnnualChangesInputData(
                            Double.parseDouble(((JSONObject) jsonChange).get("newSantaBudget").
                                    toString()),
                            Utils.convertJSONGifts((JSONArray) ((JSONObject) jsonChange)
                                    .get("newGifts")),
                            Utils.convertJSONNewChildren((JSONArray) ((JSONObject) jsonChange)
                                    .get("newChildren")),
                            Utils.convertJSONChildrenUpdates((JSONArray) ((JSONObject) jsonChange)
                                    .get("childrenUpdates"))
                    ));
                }
            }

            if (jsonChildren == null) {
                children = null;
            }

            if (jsonSantaGiftsList == null) {
                santaGiftsList = null;
            }

            if (jsonAnnualChanges == null) {
                annualChanges = null;
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return new Input(numberOfYears, santaBudget, children, santaGiftsList, annualChanges);
    }

}
