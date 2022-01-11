package writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.Database;
import interfaces.IChild;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    private final FileWriter file;

    public Writer(final String path) throws IOException {
        this.file = new FileWriter(path);
    }

    /**
     * @param database the database
     * @throws IOException exception
     */
    public void writeFile(final Database database) throws IOException {
        AnnualChildren annualChildren = new AnnualChildren();
        for (List<IChild> childrenList : database.getResultsList()) {
            Children children = new Children(childrenList);
            annualChildren.getAnnualChildren().add(children);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, annualChildren);
    }

}
