package cn.zut.edu.logcol.logcollecttion.bean;

public class LocationOneDay {
    String location;
    Long num;

    public LocationOneDay(String location, Long num) {
        this.location = location;
        this.num = num;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
