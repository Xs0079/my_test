package com.xs.study.spring.jdbc;

import com.xs.study.hibernate.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Xu Sheng on 2017/11/10.
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {

}
