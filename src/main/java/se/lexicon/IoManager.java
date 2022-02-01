package se.lexicon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IoManager {


    public List<String> readLines(String path){
        try{
            return Files.lines(Paths.get(path))
                    .collect(Collectors.toList());
        }catch (IOException exception){
            throw new RuntimeException("Ops! something went wrong Reading file" + path, exception);
        }
    }


}
