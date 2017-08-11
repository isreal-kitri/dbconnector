package model;

public class NationalParkLoc {
    private long locNumber;
    private String locName;

    public NationalParkLoc(){

    }

    public NationalParkLoc(long locNumber, String locName) {
        this.locNumber = locNumber;
        this.locName = locName;
    }

    public long getLocNumber() {
        return locNumber;
    }

    public void setLocNumber(long locNumber) {
        this.locNumber = locNumber;
    }

    public String getLocName() {
        return locName;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    @Override
    public String toString() {
        return "NationalParkLoc{" +
                "locNumber=" + locNumber +
                ", locName='" + locName + '\'' +
                '}';
    }
}
