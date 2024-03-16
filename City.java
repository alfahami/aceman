public class City {
    private int idCity;
    private int idFaculty;
    private String name;
    private String region;

    private FacultyInstitute[] facs;


    public City(int idCity, String name, String region, FacultyInstitute[] facs) {
        this.name = name;
        this.region = region;
        this.facs = new FacultyInstitute[facs.length];
        for (int i = 0; i < facs.length; i++) {
            this.facs[i] = facs[i];
            this.facs[i].setIdCity(i+1);
            
        }
    }
    
    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public int getIdFaculty() {
        return this.idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
    }

    public FacultyInstitute getFac(int i) {
        return this.facs[i];
    }

    public void setFac(int i, FacultyInstitute fac) {
        FacultyInstitute copy = new FacultyInstitute(fac);
        this.facs[i] = copy;
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
