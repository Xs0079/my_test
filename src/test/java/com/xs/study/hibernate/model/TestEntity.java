package com.xs.study.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Xu Sheng on 2017/11/10.
 * 测试是否能成功创建表
 */
@Entity
@Table(name = "test", schema = "hibernate_test")
public class TestEntity {

    @Id
    private Long id;

    private String name;

    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
