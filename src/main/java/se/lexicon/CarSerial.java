package se.lexicon;

import se.lexicon.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarSerial {


    public void serializeList(List<Car> cars, File destination){

        try(ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(destination))){
            write.writeObject(cars);

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }


    public List<Car> deserializeCars(File source){

        List<Car> cars = new ArrayList<>();

        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream(source))){

           cars = (List<Car>) read.readObject();

        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        return cars;

    }


}
