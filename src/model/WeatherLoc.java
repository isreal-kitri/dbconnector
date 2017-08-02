package model;

/**
 * Created by danawacomputer on 2017-08-02.
 */
public class WeatherLoc {

    private int locNumber;
    private String locName;

    public WeatherLoc() {
    }

    public WeatherLoc(int locNumber, String locName) {
        this.locNumber = locNumber;
        this.locName = locName;
    }

    public int getLocNumber() {
        return locNumber;
    }

    public void setLocNumber(int locNumber) {
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
        return "WeatherLoc{" +
                "locNumber=" + locNumber +
                ", locName='" + locName + '\'' +
                '}';
    }
}
