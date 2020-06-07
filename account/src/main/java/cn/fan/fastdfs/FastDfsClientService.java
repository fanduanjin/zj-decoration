package cn.fan.fastdfs;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */
@Component
public class FastDfsClientService {

    private final Logger logger = LoggerFactory.getLogger(FastDfsClientService.class);

    @Resource
    private FastFileStorageClient storageClient;

    @Value("${dfs.url}")
    private String dfsUrl;


    /**
     * 上传文件
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
        return getResAccessUrl(storePath);
    }

    private String getResAccessUrl(StorePath storePath) {
//        String fileUrl = dfsUrl
//                + ":" + dfsPort + "/" + storePath.getFullPath();

        String fileUrl =  "/" + storePath.getFullPath();
        return fileUrl;
    }

    /**
     * 将一段字符串生成一个文件上传
     * @param content 文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream,buff.length, fileExtension,null);
        return getResAccessUrl(storePath);
    }

    public String getDfsPath() {
        return dfsUrl;
    }



    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     * @return
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }

    public InputStream getFileInputStream(String fileUrl) {
        if(StringUtils.isEmpty(fileUrl)) {
            return null;
        }
        StorePath storePath = StorePath.parseFromUrl(fileUrl);
        InputStream result = storageClient.downloadFile(storePath.getGroup(),storePath.getPath(), null);
        return result;
    }
}
