package com.qc.goods.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OssClient {

    @Value("${oss.file.endpoint}")
    private String endpoint;

    @Value("${oss.file.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.file.accessKeySecret}")
    private String accessKeySecret;


    @Bean
    public OSSClient createOssClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);

    }
}
