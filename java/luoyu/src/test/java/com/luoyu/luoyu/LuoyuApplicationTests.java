package com.luoyu.luoyu;

import com.luoyu.common.pojo.system.SDict;
import com.luoyu.system.mapper.SDictMappper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

@SpringBootTest
public class LuoyuApplicationTests {

    private static Logger _logger = LoggerFactory.getLogger(LuoyuApplicationTests.class);
    @Autowired
    SDictMappper dictMappper;

    @Test
    void contextLoads() {
        List<SDict> list = dictMappper.selectList(null);
        if (CollectionUtils.isEmpty(list)) {
            _logger.warn("无数据");
        } else {
            for (SDict sDict : list) {
                _logger.info(sDict.toString());
            }
        }
    }

}
