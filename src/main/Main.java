package main;

import checker.Checker;
import common.Constants;
import database.Database;
import factories.SortStrategyFactory;
import input.Input;
import input.InputLoader;
import interfaces.ChildrenSortStrategy;
import simulationflow.InitialRound;
import simulationflow.StandardRound;
import writer.Writer;
import java.io.IOException;

public final class Main {
    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {

        for (int testNr = 22; testNr <= Constants.TESTS_NUMBER; testNr++) {
            String inputPath = "tests/test" + testNr + ".json";
            String outputPath = "output/out_" + testNr + ".json";

            InputLoader inputLoader = new InputLoader(inputPath);
            Input input = inputLoader.readData();

            Database database = Database.getDatabase(input);
            InitialRound initialRound = new InitialRound();
            StandardRound standardRound = new StandardRound();

            ChildrenSortStrategy strategy = SortStrategyFactory.getSortStrategyFactory()
                    .createStrategy("id");
            database.setSortStrategy(strategy);

            initialRound.executeInitialRound(database);
            database.addResults(0);

            for (int i = 0; i < database.getNumberOfYears(); i++) {
                standardRound.executeStandardRound(database, database.getAnnualChanges().get(i));
                database.addResults(i + 1);
            }

            Writer fileWriter = new Writer(outputPath);
            fileWriter.writeFile(database);

            database.resetDatabase();
        }

        Checker.calculateScore();
    }
}
