package cn.zut.edu.logcol.logcollecttion.service.impl;

import cn.zut.edu.logcol.logcollecttion.bean.TotalOneDay;
import cn.zut.edu.logcol.logcollecttion.dao.mapper.LocRowMapper;
import cn.zut.edu.logcol.logcollecttion.service.LocService;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("LocService")
public class LocServiceImpl implements LocService {
    @Autowired private HbaseTemplate hbaseTemplate;

    public List<TotalOneDay> query(String strow,String edrow){
        Scan scan=new Scan();
        scan.withStartRow(Bytes.toBytes(strow));
        scan.withStopRow(Bytes.toBytes(edrow));
        scan.setCaching(20);
        scan.addFamily(Bytes.toBytes ("loc"));
        List<TotalOneDay> dtos=this.hbaseTemplate.find("test",scan,new LocRowMapper());
        return dtos;
    }

    public TotalOneDay query(String row){
        TotalOneDay loc=this.hbaseTemplate.get("test",row,new LocRowMapper());
        return loc;
    }
    public void saveOrUpdate(){
        List<Mutation> change=new ArrayList<>();
        Put put =new Put(Bytes.toBytes("666666"));
        put.addColumn(Bytes.toBytes("loc"),Bytes.toBytes("HA"),Bytes.toBytes("1000"));
        change.add(put);
        this.hbaseTemplate.saveOrUpdates("test",change);
    }
}
