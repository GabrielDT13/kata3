package software.ulpgc.control;

import software.ulpgc.model.Title;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader {
    private final File file;

    public TsvTitleReader(File file) {
        this.file = file;
    }

    public List<Title> read(String file){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            return readWith(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> readWith(BufferedReader reader) throws IOException {
        TsvTitleDeserializer deserializer = new TsvTitleDeserializer();
        List<Title> result = new ArrayList<>();

        while(true){
            String line = reader.readLine();
            if(line==null) break;
            Title title = deserializer.deserialize(line);
            result.add(title);
        }

        return result;
    }
}
