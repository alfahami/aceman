public class FacultyInstitute {
    private int idFacultyInstitute;
    private int idCity;
    private String nameFacInst;
    private Formation[] formations;


    public FacultyInstitute(String nameFacInst, Formation[] formations) {
        
        this.nameFacInst = nameFacInst;
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
