package se.lexicon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {


    public static void main(String[] args) {

        File source = new File("source_folder/text.txt");
//        String text = "Hello World Group 40";
//        write(source, text);
//
//
//        List<String> names = Arrays.asList(
//                "Fredrik Odin",
//                "Erik Svensson",
//                "Ulf Bengtsson",
//                "Fredrik Odin"
//        );
//
//        writeLines(source, names);


        List<String> textReturned = readLines(source);

        textReturned.forEach(System.out::println);


    }

    private static List<String> readLines(File source) {

        List<String> data = new ArrayList<>();

        try( BufferedReader reader = new BufferedReader(new FileReader(source)))
        {
            String line;
            while((line = reader.readLine()) != null ){
                data.add(line);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return data;
    }

    private static void writeLines(File source, List<String> names) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(source))){

            for (String toWrite: names) {
                writer.write(toWrite);
                writer.newLine();
                writer.flush();
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }


    }

    private static void write(File source, String text) {

        try(FileWriter in = new FileWriter(source)){

            in.write(text);

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
    
    
}
