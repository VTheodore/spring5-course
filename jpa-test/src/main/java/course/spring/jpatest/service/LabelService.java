package course.spring.jpatest.service;

import course.spring.jpatest.entity.Label;

import java.util.List;

public interface LabelService {
    List<Label> findAll();

    //TODO add other CRUD methods
}
