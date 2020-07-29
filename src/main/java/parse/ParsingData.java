package parse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class ParsingData {

    public DataForTesting dataParse() {
        ObjectMapper objectMapper = new ObjectMapper();
        DataForTesting data = null;
        try {
            data = objectMapper.readValue(new File("src/main/resources/data.json"),
                    DataForTesting.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
