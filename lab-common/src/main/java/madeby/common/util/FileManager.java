package madeby.common.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
    private final String path;

    public FileManager(String filename) {
        this.path = filename;
    }

    public StringBuilder read() throws IOException {
        FileReader fileReader = new FileReader(this.path);
        StringBuilder json = new StringBuilder("");
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                json.append(line).append('\n');
            }
        }
        return json;
    }

    public void write(String json) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(path)) {
            printWriter.write(json);
        }
    }
}
