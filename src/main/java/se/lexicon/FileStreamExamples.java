package se.lexicon;

import java.io.*;
import java.util.Arrays;

public class FileStreamExamples {

    public static void main(String[] args) {

        File source = new File("source_folder/Lighthouse.jpg");
        File destination = new File("destination_folder/Lighthouse-copy.jpg");

        copy(source, destination);

        source = new File("source_folder/Exceptions.pdf");
        destination = new File("destination_folder/Exceptions-copy.pdf");

        copyBuffered(source, destination);

    }


    public static void copy(File source, File destination){

        FileInputStream in = null;
        FileOutputStream out = null;

        try { // Try block because FileInput/OutStream throw _checked_ Exceptions. Need to handle.

            in = new FileInputStream(source);
            out = new FileOutputStream(destination);

            int b;
            while ( (b = in.read()) != -1 ){
                out.write(b);

                System.out.println("Writing:" + b);
            }

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        } finally {
            try{
                out.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

            try{
                in.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

    }


    public static void copyBuffered(File source, File destination){
       try(
               BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
               BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
       ){
           //Write to file.
           byte[] buffer = new byte[1024];
           int bytesRead = 0;
           while((bytesRead = in.read(buffer)) > 0){
               out.write(buffer,0, bytesRead);
               out.flush();
               System.out.println("Writing: " + Arrays.toString(buffer));
           }

       }catch (FileNotFoundException exception){
           exception.printStackTrace();
       }catch (IOException exception){
           exception.printStackTrace();
       }

    }

}
