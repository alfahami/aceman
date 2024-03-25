public class City {
    private int idCity;
    private String name;
    private String region;

    private FacultyInstitute[] facs;

    public City(int idCity, String name, String region, FacultyInstitute[] facs) {
        this.idCity = idCity;
        this.name = name;
        this.region = region;
        this.facs = new FacultyInstitute[facs.length];
        for (int i = 0; i < facs.length; i++) {
            this.facs[i] = new FacultyInstitute(facs[i]);
            this.facs[i].setIdCity(i + 1);
        }
    }

    public City(City source) {
        this.idCity = source.idCity;
        this.name = source.name;
        this.region = source.region;
        this.facs = new FacultyInstitute[source.facs.length];
        for (int i = 0; i < facs.length; i++) {
            this.facs[i] = new FacultyInstitute(source.facs[i]);
            this.facs[i].setIdCity(i + 1);
        } 
    }

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public FacultyInstitute getFac(int i) {
        return new FacultyInstitute(this.facs[i]);
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

    public String[] getFacultyName() {
        String[] listFacs = new String[this.facs.length];
        for (int i = 0; i < this.facs.length; i++) {
            listFacs[i] = facs[i].getNameFacInst();
        }
        return listFacs;
    }

    public String toString() {
        return "{" +
                " idCity='" + getIdCity() + "'" +
                ", name='" + getName() + "'" +
                ", region='" + getRegion() + "'" +
                "}";
    }

    
}
