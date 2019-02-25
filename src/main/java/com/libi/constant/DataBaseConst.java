package com.libi.constant;

/**
 * @author libi
 */
public class DataBaseConst {
    /**
     * SqlSession相关配置
     */
    public static final String CONFIG_LOCATION = "classpath:config/myBatis-config.xml";
    public static final String MAPPER_LOCATION = "classpath:mapper/*.xml";
    public static final String ENTITY_PACKAGE = "com.libi.entity";

    /**
     * Multi-Part配置常量
     */
    public static final String FILE_LOCATION = "/";
    public static final int MAX_FILE_SIZE = 10 * 1024 * 1024;
    public static final int MAX_REQUEST_SIZE = 15 * 1024 * 1024;
    public static final int FILE_SIZE_THRESHOLD = 0;
}
