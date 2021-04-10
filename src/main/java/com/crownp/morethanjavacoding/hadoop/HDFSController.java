package com.crownp.morethanjavacoding.hadoop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @Description Hdfs接口
 * @Author qgp
 * @Date 2019/10/29 13:34
 **/
@RestController
public class HDFSController {

    @GetMapping("/test")
    public String test(){
        return "成功！";
    }

    @GetMapping("/getFile")
    public List getDir(@RequestParam String url) throws InterruptedException, IOException, URISyntaxException {
        return HdfsClient.getFile(url);
    }


}
