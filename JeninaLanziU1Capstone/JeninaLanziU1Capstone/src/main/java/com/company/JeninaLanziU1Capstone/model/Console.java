package com.company.JeninaLanziU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Console extends Item {

    @Size(min = 1, max = 50, message = "Model can be up to 50 chars long.")
    private String model;

    @Size(min = 1, max = 50, message = "Manufacturer can be up to 50 chars long.")
    private String manufacturer;

    @Size(min = 1, max = 20, message = "Memory amount can be up to 20 chars long.")
    private String memoryAmount;

    @Size(min = 1, max = 20, message = "Processor can be up to 20 chars long.")
    private String processor;


    // Getters, setters, equals, hashCode, toString
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Console console = (Console) o;
        return getModel().equals(console.getModel()) &&
                getManufacturer().equals(console.getManufacturer()) &&
                getMemoryAmount().equals(console.getMemoryAmount()) &&
                getProcessor().equals(console.getProcessor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor());
    }
}
