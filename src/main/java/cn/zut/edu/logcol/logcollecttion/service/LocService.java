package cn.zut.edu.logcol.logcollecttion.service;

import cn.zut.edu.logcol.logcollecttion.bean.TotalOneDay;

import java.util.List;

public interface LocService {
    List<TotalOneDay> query(String strow, String edrow);
    TotalOneDay query(String row);
    void saveOrUpdate();
}
