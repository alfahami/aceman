public class StayCard {

    private int idCard;
    private int idUser;
    private int idVille;
    private String cardNum;
    private int obtentionYear;
    private int expirationYear;
    private int pin;


    public StayCard(int idCard, int idUser, int idVille, String cardNum, int obtentionYear, int expirationYear, int pin) {
        this.idCard = idCard;
        this.idUser = idUser;
        this.idVille = idVille;
        this.cardNum = cardNum;
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

    public String getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public int getObtentionYear() {
        return this.obtentionYear;
    }

    public void setObtentionYear(int obtentionYear) {
        this.obtentionYear = obtentionYear;
    }

    public int getExpirationYear() {
        return this.expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getPin() {
        return this.pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String toString() {
        return "{" +
            " idCard='" + getIdCard() + "'" +
            ", idUser='" + getIdUser() + "'" +
            ", idVille='" + getIdVille() + "'" +
            ", cardNum='" + getCardNum() + "'" +
            ", obtentionYear='" + getObtentionYear() + "'" +
            ", expirationYear='" + getExpirationYear() + "'" +
            ", pin='" + getPin() + "'" +
            "}";
    }
}
