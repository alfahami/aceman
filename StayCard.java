public class StayCard {

    private int idCard;
    private int idMember;
    private int idCity;
    private String cardNum;
    private String pattern;
    private String obtentionDate;
    private String expirationDate;
    private int pin;

    public StayCard(){

    }


    public StayCard(int idCard, int idMember, int idCity, String cardNum, String obtentionDate, String expirationDate, int pin, String pattern) {
        this.idCard = idCard;
        this.idMember = idMember;
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

    public int getidMember() {
        return this.idMember;
    }

    public void setidMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIdCity() {
        return this.idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
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
            ", idMember='" + getidMember() + "'" +
            ", idCity='" + getIdCity() + "'" +
            ", cardNum='" + getCardNum() + "'" +
            ", obtentionDate='" + getobtentionDate() + "'" +
            ", expirationDate='" + getExpirationYear() + "'" +
            ", pin='" + getPin() + "'" +
            "}";
    }
}
