package com.xzh.basic.dao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@AllArgsConstructor
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号
     */
    private String number;

    /**
     * 尾号
     */
    private String end;

    /**
     * 类型(5，1，2，3）
     */
    private String topic;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    public PhoneNumber() {
    }

    public PhoneNumber(String number) {
        this.number = number;
    }

    public PhoneNumber(String number, String end, String topic) {
        this.number = number;
        this.end = end;
        this.topic = topic;
    }
}