package cn.fan.controller;

import cn.fan.core.web.HttpResult;
import cn.fan.fastdfs.FastDfsClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Date 2020/4/29
 * @Create By admin
 */
@RequestMapping("/api/common")
@RestController
public class CommonController {

    @Resource
    private FastDfsClientService dfsClient;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public HttpResult upload(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        String imgUrl = dfsClient.uploadFile(file);
        Map<String, Object> result = new HashMap();
        result.put("fileUrl", imgUrl);
        return HttpResult.SUCCESS_RESULT( result);
    }
}
