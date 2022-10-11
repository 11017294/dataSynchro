package com.chen.datasynchro.entity.master;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * Web访问记录表
 * </p>
 *
 * @author MaybeBin
 * @since 2022-08-30
 */
@Data
@TableName("T_WEB_VISIT")
public class MasterWebVisit extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.UUID)
    private String id;

    /**
     * 用户行为
     */
    @TableField("BEHAVIOR")
    private String behavior;

    /**
     * 模块名
     */
    @TableField("MODEL")
    private String model;

    /**
     * 方法请求花费的时间
     */
    @TableField("SPEND_TIME")
    private Long spendTime;

    /**
     * 用户id
     */
    @TableField("USER_ID")
    private String userId;

    /**
     * 用户身份证
     */
    @TableField("IDCARD")
    private String idcard;

    /**
     * 用户姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 用户手机号
     */
    @TableField("PERSON_PHONE")
    private String personPhone;

    /**
     * 用户ip
     */
    @TableField("IP")
    private String ip;

    /**
     * 操作系统
     */
    @TableField("OS")
    private String os;

    /**
     * 浏览器
     */
    @TableField("BROWSER")
    private String browser;

    /**
     * 请求参数
     */
    @TableField("REQUEST_PARAM")
    private String requestParam;

    /**
     * 更新时间
     */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 是否逻辑删除（1：是）
     */
    @TableField("IS_DELETE")
    @TableLogic
    private Integer isDelete;

}