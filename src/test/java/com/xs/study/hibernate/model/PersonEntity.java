package com.xs.study.hibernate.model;

import javax.persistence.*;

/**
 * Created by Xu Sheng on 2017/11/9.
 * person entity
 */
@Entity
@Table(name = "person", schema = "testDB")
public class PersonEntity {
    private Integer id;
    private String name;
    private Byte sex;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
