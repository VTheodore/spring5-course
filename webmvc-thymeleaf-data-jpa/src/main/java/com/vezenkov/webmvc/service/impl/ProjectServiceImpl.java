package com.vezenkov.webmvc.service.impl;

import com.vezenkov.webmvc.dao.ProjectRepository;
import com.vezenkov.webmvc.entity.Project;
import com.vezenkov.webmvc.exception.NonExistingEntityException;
import com.vezenkov.webmvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Validated
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return this.projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        return this.projectRepository.findById(id)
                .orElseThrow(
                        () -> new NonExistingEntityException(
                                String.format("Project with ID='%d' does not exists", id)));
    }

    @Override
    @Transactional
    public Project addProject(@Valid Project project) {
        project.setId(null);
        return this.projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project updateProject(@Valid Project project) {
        this.getProjectById(project.getId());
        return this.projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project deleteProject(Long id) {
        Project toBeDeleted = this.getProjectById(id);
        this.projectRepository.deleteById(id);
        return toBeDeleted;
    }

    @Override
    public long getProjectsCount() {
        return this.projectRepository.count();
    }
}
