package schemafirst.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonFilter {

    private String firstNameStartsWith;
    private int ageFrom;
    private int ageTo;
    private String city;

    @JsonProperty("firstNameStartsWith")
    public String getFirstNameStartsWith() {
        return firstNameStartsWith;
    }

    public void setFirstNameStartsWith(String firstNameStartsWith) {
        this.firstNameStartsWith = firstNameStartsWith;
    }

    @JsonProperty("ageFrom")
    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    @JsonProperty("ageTo")
    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
