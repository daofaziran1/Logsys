package cn.zut.edu.logcol.logcollecttion.dao.mapper;

import cn.zut.edu.logcol.logcollecttion.bean.TotalOneDay;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;


import java.util.Date;
import java.util.HashMap;

public class LocRowMapper implements RowMapper<TotalOneDay> {
    @Override
    public TotalOneDay mapRow(Result result, int row) throws Exception {
        HashMap<String,Long> hs=new HashMap<>();
        for(Cell c: result.rawCells()){
            String str=new String(CellUtil.cloneQualifier(c));
            Long i=Long.valueOf(new String(CellUtil.cloneValue(c)));
            if(hs.containsKey(str)){
                hs.put(str,i+hs.get(str));
            }else{
                hs.put(str,i);
            }
        }
        return new TotalOneDay(hs,new Date());
    }
}
