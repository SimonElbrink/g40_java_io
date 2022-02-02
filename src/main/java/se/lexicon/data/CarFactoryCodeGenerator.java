package se.lexicon.data;



import se.lexicon.model.Car;

import java.util.*;

public class CarFactoryCodeGenerator {

    private static CarFactoryCodeGenerator INSTANCE;

    public static CarFactoryCodeGenerator getINSTANCE() {
        if (INSTANCE == null) INSTANCE = new CarFactoryCodeGenerator(null);
        return INSTANCE;
    }

    private CarFactoryCodeGenerator(Map<String, List<String>> carCodeStorage) {
        if (carCodeStorage == null) carCodeStorage = new TreeMap<>();
        this.carCodeStorage = carCodeStorage;
    }

    //          Cars ID , List of Secrets
    private Map<String, List<String>> carCodeStorage;

    public String[] generateCodes(Car car){
        String id = UUID.randomUUID().toString();
        String codeGenerated =UUID.randomUUID().toString();

        carCodeStorage.put(id, new ArrayList<>(Arrays.asList(codeGenerated)));

        return new String[] {id,codeGenerated.toString()};
    }

//    private void storeSecret(String id, String secret) {
//        List<String> carCode = carCodeStorage.get(id);
//        carCode.add(secret);
//    }


}
