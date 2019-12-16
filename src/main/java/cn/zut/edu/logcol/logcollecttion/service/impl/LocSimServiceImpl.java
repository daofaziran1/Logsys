package cn.zut.edu.logcol.logcollecttion.service.impl;

import cn.zut.edu.logcol.logcollecttion.service.LocSimService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zut.edu.logcol.logcollecttion.bean.*;
import cn.zut.edu.logcol.logcollecttion.dao.mapper.LocSimMapper;


@Service
public class LocSimServiceImpl implements LocSimService {
    @Autowired
    private LocSimMapper locSimMapper;

    @Override
    public LocSim getloc(String sim) {
        return locSimMapper.getloc(sim);
    }

}