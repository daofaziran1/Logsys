package cn.zut.edu.logcol.logcollecttion.bean;
import cn.zut.edu.logcol.logcollecttion.dao.MysqlUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TotalOneDay {
    Date date;
    LocationOneDay[] locationOneDays;
    Long sum;
    public TotalOneDay(){}
    public TotalOneDay(LocationOneDay[] locationOneDays) {
        this.locationOneDays = locationOneDays;
        sum=0L;
        for(LocationOneDay l:locationOneDays){
            sum+=l.getNum();
        }
    }
    public TotalOneDay(HashMap<String,Long> hs,Date date){
        this.date=date;
        locationOneDays=new LocationOneDay[hs.size()];
        int i=0;
        long sum=0;
        for(Map.Entry<String,Long> l:hs.entrySet()){
            locationOneDays[i++]=new LocationOneDay(l.getKey(),l.getValue());
            sum+=l.getValue().longValue();
        }
        this.sum=sum;
    }
    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }
    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    public TotalOneDay(HashMap<String,Long> hs, MysqlUtil mysql, Date date){
        int i=0;
        long sum=0;
        HashMap<String,Long> hss=new HashMap<String,Long>();
        for(Map.Entry<String,Long> l:hs.entrySet()){
            String    loc=mysql.catchLoc(l.getKey());
            String sim=mysql.catchSim(loc);
            if(sim.equals("WG")){
                continue;
            }
            if(hss.containsKey(loc)){
                hss.put(loc,hss.get(loc)+l.getValue());
            }
            else hss.put(loc, l.getValue());
        }
        locationOneDays=new LocationOneDay[hss.size()];
        for(Map.Entry<String,Long> l:hss.entrySet()){
            locationOneDays[i++]=new LocationOneDay(l.getKey(), l.getValue().longValue());
            sum+=l.getValue();
        }
        this.sum=sum;
    }
    public LocationOneDay[] getLocationOneDays() {
        return locationOneDays;
    }

    public void setLocationOneDays(LocationOneDay[] locationOneDays) {
        this.locationOneDays = locationOneDays;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
