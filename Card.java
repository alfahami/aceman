public class Card {

    private int idCard;
    private int idMember;
    private int idCity;
    private String cardNum;
    private String pattern;
    private String obtentionDate;
    private String expirationDate;
    private int pin;

    public Card(int idCard, int idMember, int idCity, String cardNum, String obtentionDate, String expirationDate, int pin, String pattern) {
        this.idCard = idCard;
        this.idMember = idMember;
        this.cardNum = cardNum;
        this.obtentionDate = obtentionDate;
        this.expirationDate = expirationDate;
        this.pin = pin;
        this.pattern = pattern;
    }

    public Card(Card source){
        this.idCard = source.idCard;
        this.idMember = source.idMember;
        this.cardNum = source.cardNum;
        this.obtentionDate = source.obtentionDate;
        this.expirationDate = source.expirationDate;
        this.pin = source.pin;
        this.pattern = source.pattern;
    }

    public int getIdCard() {
        return this.idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
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

    public int getIdMember() {
        return this.idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getObtentionDate() {
        return this.obtentionDate;
    }

    public void setObtentionDate(String obtentionDate) {
        this.obtentionDate = obtentionDate;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
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
            ", idMember='" + getIdMember() + "'" +
            ", idCity='" + getIdCity() + "'" +
            ", cardNum='" + getCardNum() + "'" +
            ", obtentionDate='" + getobtentionDate() + "'" +
            ", expirationDate='" + getExpirationYear() + "'" +
            ", pin='" + getPin() + "'" +
            "}";
    }
}
