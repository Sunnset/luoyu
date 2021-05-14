package com.luoyu.web;

import com.luoyu.common.entity.system.SDict;
import com.luoyu.common.module.sequence.ISequenceGenerator;
import com.luoyu.service.system.ISDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wangzb
 * @program: luoyu
 * @description
 * @create: 2021-05-05 20:48
 */
@RestController
public class TestController {
    @Autowired
    private ISequenceGenerator sequenceGenerator;

    @Autowired
    private ISDictService dictService;

    @GetMapping("/uuid")
    public String getUuid(){
        SDict sDict = new SDict();
        sDict.setUid(sequenceGenerator.get());
        sDict.setType(1);
        sDict.setCode("ROOT");
        sDict.setName("根节点");
        sDict.setContent("根节点");
        sDict.setRemark("备注");
        sDict.setPtnCode("");
        sDict.setOrderNum(1);
        sDict.setCreateTime(new Date());
        sDict.setUpdTime(sDict.getCreateTime());
        return "成功插入" + dictService.insert(sDict) + "条字典项数据";
    }

}
