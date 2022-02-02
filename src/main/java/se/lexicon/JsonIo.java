package se.lexicon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.model.Car;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIo {

    private ObjectMapper objectMapper;

    public JsonIo() {

        objectMapper = new ObjectMapper(); //  creating the Mapper.
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // "Prettier" Json
//        objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());// Register JSR310, for java Time API (Java v.8)
    }


    public void serializeToJson(List<Car> carList, File source){
        try{
            objectMapper.writeValue(source, carList);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    public List<Car> deserializeFromJson(File source){
        List<Car> cars = new ArrayList<>();
        try{
            cars = objectMapper.readValue(source, new TypeReference<List<Car>>(){});
        }catch (IOException exception){
            exception.printStackTrace();
        }

        return cars;
    }



}
