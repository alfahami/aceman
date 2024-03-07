public class StayCard {

    private int idCard;
    private int idUser;
    private int idVille;
    private String obtentionYear;
    private String expirationYear;
    private Long pin;


    public StayCard(int idCard, int idUser, int idVille, String obtentionYear, String expirationYear, Long pin) {
        this.idCard = idCard;
        this.idUser = idUser;
        this.idVille = idVille;
        this.obtentionYear = obtentionYear;
        this.expirationYear = expirationYear;
        this.pin = pin;
    }

    public int getIdCard() {
        return this.idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdVille() {
        return this.idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getObtentionYear() {
        return this.obtentionYear;
    }

    public void setObtentionYear(String obtentionYear) {
        this.obtentionYear = obtentionYear;
    }

    public String getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Long getPin() {
        return this.pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public String toString() {
        return "{" +
            " idCard='" + getIdCard() + "'" +
            ", idUser='" + getIdUser() + "'" +
            ", idVille='" + getIdVille() + "'" +
            ", obtentionYear='" + getObtentionYear() + "'" +
            ", expirationYear='" + getExpirationYear() + "'" +
            ", pin='" + getPin() + "'" +
            "}";
    }


}
