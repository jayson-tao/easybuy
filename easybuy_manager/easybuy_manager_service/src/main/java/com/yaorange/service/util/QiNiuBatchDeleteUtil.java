package com.yaorange.service.util;


import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

/**
 * 批量删除七牛云
 */
public class QiNiuBatchDeleteUtil {
    private static String accessKey = "k2YDTmYW2_N2yI4msjJfzkIo9aMROxeO36E-gxS-";
    private static String secretKey = "f7eXd2-m3XboiB6v3Mr9YlsoF1Esou-2k90CnloN";
    //七牛云仓库
    private static String bucketName = "javaqiniuyun";

    public static void batchDelete(String[] keys) {
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        Auth auth = Auth.create(accessKey, secretKey);
        Configuration config = new Configuration(Zone.autoZone());
        BucketManager bucketMgr = new BucketManager(auth, config);
        for (String key : keys) {
            try {
                //删除
                bucketMgr.delete(bucketName, key);
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }
    }


}
