package com.luoyu.common.module;

import com.luoyu.common.module.sequence.ISequenceGenerator;
import com.luoyu.common.module.sequence.impl.DateSequence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangzb
 * @program: luoyu
 * @description 模块配置类
 * @create: 2021-05-05 20:28
 */
@Configuration
public class ModuleConfig {
    @Bean
    public ISequenceGenerator sequenceGenerator(){
        return DateSequence.getInstance();
    }

}
