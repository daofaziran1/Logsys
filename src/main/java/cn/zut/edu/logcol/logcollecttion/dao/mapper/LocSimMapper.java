package cn.zut.edu.logcol.logcollecttion.dao.mapper;


import org.apache.ibatis.annotations.Mapper;

import cn.zut.edu.logcol.logcollecttion.bean.LocSim;

@Mapper
public interface LocSimMapper  {

    LocSim getloc(String sim);

}
