public class StayCard {

    private int idCard;
    private int idUser;
    private int idVille;
    private String cardNum;
    private String pattern;
    private String obtentionDate;
    private String expirationDate;
    private int pin;


    public StayCard(String cardNum, String obtentionDate, String expirationDate, int pin, String pattern) {
        this.cardNum = cardNum;
        this.obtentionDate = obtentionDate;
        this.expirationDate = expirationDate;
        this.pin = pin;
        this.pattern = pattern;
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

    public String getobtentionDate() {
        return this.obtentionDate;
    }

    public void setobtentionDate(String obtentionDate) {
        this.obtentionDate = obtentionDate;
    }

    public String getExpirationYear() {
        return this.expirationDate;
    }

    public void setExpirationYear(String expirationDate) {
        this.expirationDate = expirationDate;
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
            ", obtentionDate='" + getobtentionDate() + "'" +
            ", expirationDate='" + getExpirationYear() + "'" +
            ", pin='" + getPin() + "'" +
            "}";
    }
}
