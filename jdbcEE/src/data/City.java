package data;

public class City {
    private String district;
    private int population;

    public City(String district, int population) {
        this.district = district;
        this.population = population;
    }

    public City() {
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
