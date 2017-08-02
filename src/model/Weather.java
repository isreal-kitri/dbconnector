package model;

/**
 * Created by danawacomputer on 2017-07-21.
 */
public class Weather {
    private int locNumber;
    private String locName;
    private String date;
    private double avgTemp;
    private double maxTemp;
    private double minTemp;
    private double avgHumidity;
    private double avgWind;
    private double avgRain;

    public Weather() {
    }

    public Weather(int locNumber, String locName, String date, double avgTemp, double maxTemp,
                   double minTemp, double avgHumidity, double avgWind, double avgRain) {
        this.locNumber = locNumber;
        this.locName = locName;
        this.date = date;
        this.avgTemp = avgTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.avgHumidity = avgHumidity;
        this.avgWind = avgWind;
        this.avgRain = avgRain;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public void setAvgTemp(double avgTemp) {
        this.avgTemp = avgTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getAvgHumidity() {
        return avgHumidity;
    }

    public void setAvgHumidity(double avgHumidity) {
        this.avgHumidity = avgHumidity;
    }

    public double getAvgWind() {
        return avgWind;
    }

    public void setAvgWind(double avgWind) {
        this.avgWind = avgWind;
    }

    public double getAvgRain() {
        return avgRain;
    }

    public void setAvgRain(double avgRain) {
        this.avgRain = avgRain;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "locNumber=" + locNumber +
                ", locName='" + locName + '\'' +
                ", date='" + date + '\'' +
                ", avgTemp=" + avgTemp +
                ", maxTemp=" + maxTemp +
                ", minTemp=" + minTemp +
                ", avgHumidity=" + avgHumidity +
                ", avgWind=" + avgWind +
                ", avgRain=" + avgRain +
                '}';
    }
}
