package com.luoyu.common.module.sequence.impl;

import com.luoyu.common.module.sequence.ISequenceGenerator;

import java.io.Serializable;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 待解决问题：时间回拨问题
 * 最大支持：同一毫秒下获取100个唯一id，超过100个会等待下一毫秒。
 * @author wangzb
 * @since 1.8
 */
public class DateSequence implements ISequenceGenerator, Serializable {

    private static final long serialVersionUID = 9043693628119790496L;

    public int boostPower = 2;

    public static final AtomicLong SEQUENCE_TMP_ID = new AtomicLong(0);

    private final int expendRatio = (int) Math.pow(10, boostPower);

    private static volatile long lastTimestamp = System.currentTimeMillis();

    private static final String DATE_FORMAT_STR = "yyyyMMddHHmmssSSS";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT_STR);

    public ZoneOffset zoneOffset = ZoneOffset.of("+8");

    private static volatile DateSequence instance = null;

    private DateSequence () {
        if (Objects.nonNull(instance)) {
            throw new RuntimeException("instance is exists.....");
        }
    }

    public static DateSequence getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (DateSequence.class) {
                if (Objects.isNull(instance)) {
                    instance = new DateSequence();
                }
            }
        }
        return instance;
    }

    /**
     * 返回生成的唯一id
     * @return long 唯一id
     */
    @Override
    public synchronized long get() {
       long timeMillis = System.currentTimeMillis();
       if (SEQUENCE_TMP_ID.get() < expendRatio) {
           //当前毫秒数下的序列数未耗尽
           if (lastTimestamp == timeMillis) {
               //同一毫秒下序列加1
               return Long.parseLong(new Date(timeMillis).toInstant().atOffset(zoneOffset).toLocalDateTime().format(DATE_TIME_FORMATTER)) * expendRatio + (SEQUENCE_TMP_ID.incrementAndGet());
           } else {
               //
               lastTimestamp = timeMillis;
               SEQUENCE_TMP_ID.set(0);
               return Long.parseLong(new Date(timeMillis).toInstant().atOffset(zoneOffset).toLocalDateTime().format(DATE_TIME_FORMATTER)) * expendRatio;
           }
       } else {
           //当前毫秒数下的序列数耗尽，需要等待下一毫秒
           while (true) {
               if ((timeMillis = System.currentTimeMillis()) > lastTimestamp) {
                   lastTimestamp = timeMillis;
                   break;
               }
           }
           SEQUENCE_TMP_ID.set(0);
           return Long.parseLong(new Date(timeMillis).toInstant().atOffset(zoneOffset).toLocalDateTime().format(DATE_TIME_FORMATTER)) * expendRatio;
       }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getInstance();
    }

    /**
     * 防止通过序列化破坏单例模式
     * @return Object
     */
    private Object readResolve () {
        return getInstance();
    }
}