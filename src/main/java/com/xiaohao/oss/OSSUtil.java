package com.xiaohao.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.InputStream;

public class OSSUtil {
    private static String ACCESS_KEY_ID = "";
    private static String ACCESS_KEY_SECRET = "";
    private static String END_POINT = "";
    private static String END_POINT_PARSE = "";


    /**
     * 只需初始化一次
     *
     * @param accessKeyId     key
     * @param accessKeySecret secret
     * @param endpoint        地域
     */
    public static void init(String accessKeyId, String accessKeySecret, String endpoint) {
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
        END_POINT = endpoint;
        END_POINT_PARSE = END_POINT.replace("https://", "");
    }

    /**
     * 上传
     *
     * @param bucketName
     * @param key
     * @param inputStream
     * @return
     */
    public static String upload(String bucketName, String key, InputStream inputStream) {
        OSS ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream);
        ossClient.putObject(putObjectRequest);
        ossClient.shutdown();
        return String.format("https://%s.%s", bucketName, END_POINT_PARSE);
    }
}
