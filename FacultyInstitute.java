public class FacultyInstitute {
    private int idFacultyInstitute;
    private int idCity;
    private String nameFacInst;
    private Formation[] formations;

    
    public FacultyInstitute(int id, String nameFacInst, Formation[] formations, int idCity) {
        this.idCity = idCity;
        this.nameFacInst = nameFacInst;
        this.formations = new Formation[formations.length];
        for (int i = 0; i < formations.length; i++) {
            this.formations[i] = formations[i];
            this.formations[i].setIdFormation(i+1);
        }
    }

    public FacultyInstitute(FacultyInstitute source) {
        this.idCity = source.idCity;
        this.nameFacInst = source.nameFacInst;
        this.formations = new Formation[source.formations.length];
        for (int i = 0; i < formations.length; i++) {
            this.formations[i] = source.formations[i];
            this.formations[i].setIdFormation(i+1);
        }
    }

    public int getIdFacultyInstitute() {
        return this.idFacultyInstitute;
    }

    public void setIdFacultyInstitute(int idFacultyInstitute) {
        this.idFacultyInstitute = idFacultyInstitute;
    }

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameFacInst() {
        return this.nameFacInst;
    }

    public void setNameFacInst(String nameFacInst) {
        this.nameFacInst = nameFacInst;
    }    
}
