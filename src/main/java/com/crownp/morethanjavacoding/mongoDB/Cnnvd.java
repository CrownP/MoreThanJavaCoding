package com.crownp.morethanjavacoding.mongoDB;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @Author qgp
 * @Date 2019/11/25 9:36
 **/
@Data
@Document(collection = "test")
public class Cnnvd implements Serializable {
    /**
     * 使用CNNVD的数字编号作为数据库主键id
     */
    private String _id;

    /**
     * 漏洞名称
     */
    private String name;

    /**
     * cvvnd编号
     */
    private String cnnvd;

    /**
     * CVE编号
     */
    private String cve;

    /**
     * 危害等级
     */
    private String degree;

    /**
     * 漏洞类型
     */
    private String bug_type;

    /**
     * 威胁类型
     */
    private String threat_type;

    /**
     * 漏洞简介
     */
    private List<String> brief;

    /**
     * 漏洞公告
     */
    private List<String> notice;

    /**
     * 参考网址
     */
    private List<String> refer_site;

    /**
     * 补丁链接
     */
    private String patch_link;
}

