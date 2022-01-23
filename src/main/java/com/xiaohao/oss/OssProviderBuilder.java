package com.xiaohao.oss;

import com.xiaohao.oss.providers.AlibabaOssProvider;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xiaohao
 */
@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class OssProviderBuilder {
    private String accessKeyId;
    private String accessKeySecret;
    private String endPoint;

    public enum ProviderOption {
        ALIBABA,
    }

    public OssProviderBuilder(String accessKeyId, String accessKeySecret, String endPoint) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endPoint = endPoint.replaceAll("http[s]?://", "");
    }


    public static OssProviderBuilder builder() {
        return new OssProviderBuilder();
    }

    public OssProviderBuilder accessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public OssProviderBuilder accessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public OssProviderBuilder endPoint(String endPoint) {
        this.endPoint = endPoint;
        return this;
    }


    public OssProvider build(ProviderOption option) {
        if (ProviderOption.ALIBABA.equals(option)) {
            return new AlibabaOssProvider(this);
        }
        return new AlibabaOssProvider(this);
    }

    public OssProvider build() {
        return build(ProviderOption.ALIBABA);
    }


}