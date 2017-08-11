package model;

public class NationalPark {

    private long locNumber;
    private String locName;
    private String location;
    private double altitude;
    private String top100Reason;
    private String mntInf;
    private String transport;

    public NationalPark() {
    }

    public NationalPark(long locNumber, String mountName, String location, double altitude, String top100Reason, String mntInf, String transport) {
        this.locNumber = locNumber;
        this.locName = mountName;
        this.location = location;
        this.altitude = altitude;
        this.top100Reason = top100Reason;
        this.mntInf = mntInf;
        this.transport = transport;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getTop100Reason() {
        return top100Reason;
    }

    public void setTop100Reason(String top100Reason) {
        this.top100Reason = top100Reason;
    }

    public String getMntInf() {
        return mntInf;
    }

    public void setMntInf(String mntInf) {
        this.mntInf = mntInf;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "NationalPark{" +
                "locNumber=" + locNumber +
                ", locName='" + locName + '\'' +
                ", location='" + location + '\'' +
                ", altitude=" + altitude +
                ", top100Reason='" + top100Reason + '\'' +
                ", mntInf='" + mntInf + '\'' +
                ", transport='" + transport + '\'' +
                '}';
    }
}
