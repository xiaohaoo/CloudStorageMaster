/*
 * Copyright (c) 2022 xiaohao
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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
