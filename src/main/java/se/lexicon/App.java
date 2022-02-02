package se.lexicon;

import se.lexicon.model.Car;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class App
{
    public static void main( String[] args )
    {

        Map<LocalDate,String> serviceHistory = new TreeMap<>();
        serviceHistory.put(LocalDate.parse("2000-01-01"), "Had a fantastic make over. preparing for a movie");
        serviceHistory.put(LocalDate.parse("2000-06-09"), "Car has be confirmed to be totally destroyed.");

        Car fordMustang = new Car("Ford", "Shelby", "Striped Gray and Black", LocalDate.parse("1970-04-01"), serviceHistory);

        Map<LocalDate,String> DB5Service = new TreeMap<>();
        DB5Service.put(LocalDate.parse("1964-01-01"), "large array of gadgets Was added to the car, including an ejector seat, machine guns, a smoke screen, and tyre slashers.");
        Car bondCarDB5 = new Car("Aston Martin", "DB5", "Gray", LocalDate.parse("1963-10-01"),DB5Service);

        System.out.println("Ford Factory code: " + fordMustang.getFactoryCodeKey());
        System.out.println("DB5 Factory code: " + bondCarDB5.getFactoryCodeKey());

        List<Car> carList = new ArrayList<>(Arrays.asList(fordMustang,bondCarDB5));

        File jsonFile = new File("destination_folder/cars.json");

        JsonIo jsonIo = new JsonIo();

        jsonIo.serializeToJson(carList,jsonFile);

        List<Car> carsFromJson = jsonIo.deserializeFromJson(jsonFile);
        carsFromJson.forEach(System.out::println);

    }
}
