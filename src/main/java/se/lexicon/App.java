package se.lexicon;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IoManager ioManager = new IoManager();

        List<String> list = ioManager.readLines("source_folder/Java Course Topics Summary.md");

        list.forEach(System.out::println);




    }
}
