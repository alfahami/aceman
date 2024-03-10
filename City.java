public class City {
    private int idCity;
    private String name;
    private String region;


    public City(String name, String region) {
        this.name = name;
        this.region = region;
    }

    
    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String toString() {
        return "{" +
            " idCity='" + getIdCity() + "'" +
            ", name='" + getName() + "'" +
            ", region='" + getRegion() + "'" +
            "}";
    }


}
