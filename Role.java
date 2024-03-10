public class Role {
    private int idRole;
    private String name;
    private String session_start;
    private String session_end;


    public Role(int idRole, String name, String session_start, String session_end) {
        this.idRole = idRole;
        this.name = name;
        this.session_start = session_start;
        this.session_end = session_end;
    }

    public int getIdRole() {
        return this.idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSession_start() {
        return this.session_start;
    }

    public void setSession_start(String session_start) {
        this.session_start = session_start;
    }

    public String getSession_end() {
        return this.session_end;
    }

    public void setSession_end(String session_end) {
        this.session_end = session_end;
    }

    public String toString() {
        return "{" +
            " idRole='" + getIdRole() + "'" +
            ", name='" + getName() + "'" +
            ", session_start='" + getSession_start() + "'" +
            ", session_end='" + getSession_end() + "'" +
            "}";
    }

}
