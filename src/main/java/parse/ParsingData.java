package parse;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class ParsingData {

    public DataForTesting dataParse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        DataForTesting data = objectMapper.readValue(new File("src/main/resources/data.json"),
                DataForTesting.class);
        return data;
    }
}
