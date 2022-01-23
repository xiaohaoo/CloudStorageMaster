import com.xiaohao.oss.OssProvider;
import com.xiaohao.oss.OssProviderBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xiaohao
 * @version 1.0
 * @date 2022/1/23 2:55 PM
 */
public class OssClientTest {
    @Test
    public void alibabaOssTest() throws IOException {
        final String endpoint = "endpoint";
        final String bucketName = "bucketName";
        final String accessKeyId = "accessKeyId";
        final String accessKeySecret = "accessKeySecret";
        OssProvider ossProvider = OssProviderBuilder.builder().accessKeyId(accessKeyId).endPoint(endpoint).accessKeySecret(accessKeySecret).build();
        InputStream inputStream = null;
        ossProvider.upload(bucketName, "AlibabaOssProvider", inputStream);
    }
}
