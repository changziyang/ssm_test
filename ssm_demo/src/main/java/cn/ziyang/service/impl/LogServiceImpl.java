package cn.ziyang.service.impl;

import cn.ziyang.domain.Log;
import cn.ziyang.mapper.LogMapper;
import cn.ziyang.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public void save(Log log) {
        logMapper.save(log);
    }
}
