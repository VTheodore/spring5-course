package course.spring.jpatest.service.impl;

import course.spring.jpatest.dao.LabelRepository;
import course.spring.jpatest.entity.Label;
import course.spring.jpatest.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public List<Label> findAll() {
        return this.labelRepository.findAll();
    }
}
