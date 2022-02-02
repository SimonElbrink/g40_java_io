package se.lexicon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import se.lexicon.data.CarFactoryCodeGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Car implements Serializable {

    public static final String NO_BRAND = "No_Brand";
    public static final String NO_MODEL = "No_Model";
    public static final String NO_COLOR = "No_Color";
    public static final LocalDate NO_PRODUCTION_DATE = LocalDate.MIN;
    public static final TreeMap<LocalDate, String> DEFAULT_HISTORY = new TreeMap<>();


    private String id;
    private String brand;
    private String model;
    private String color;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate productionDate;
    private Map<LocalDate, String> serviceHistory;
    @JsonIgnore
    private transient String factoryCodeKey; // Should not be saved to any file.


    public Car() {
        this.id = null;
        this.brand = NO_BRAND;
        this.model = NO_MODEL;
        this.color = NO_COLOR;
        this.productionDate = NO_PRODUCTION_DATE;
        this.serviceHistory = DEFAULT_HISTORY;
    }

    public Car(String brand, String model, String color, LocalDate productionDate) {
        this();

        String[] keys = CarFactoryCodeGenerator.getINSTANCE().generateCodes(this);
        this.id = keys[0];
        this.factoryCodeKey = keys[1];

        setBrand(brand);
        setModel(model);
        setColor(color);
        setProductionDate(productionDate);

    }

    public Car(String brand, String model, String color, LocalDate productionDate, Map<LocalDate, String> serviceHistory) {
        this(brand, model, color, productionDate);
        setServiceHistory(serviceHistory);
    }



    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public Map<LocalDate, String> getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(Map<LocalDate, String> serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public String getFactoryCodeKey() {
        return factoryCodeKey;
    }

    public void setFactoryCodeKey(String factoryCodeKey) {
        this.factoryCodeKey = factoryCodeKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId()) && Objects.equals(getBrand(), car.getBrand()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getColor(), car.getColor()) && Objects.equals(getProductionDate(), car.getProductionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getColor(), getProductionDate());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", productionDate=" + productionDate +
                ", serviceHistory=" + serviceHistory +
                '}';
    }
}
