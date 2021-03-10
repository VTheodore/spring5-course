package com.vezenkov.webmvc.web;

import com.vezenkov.webmvc.entity.Project;
import com.vezenkov.webmvc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectRepository) {
        this.projectService = projectRepository;
    }


    @GetMapping
    public String getPosts(Model model) {
        model.addAttribute("projects", this.projectService.getAllProjects());
        model.addAttribute("path", "projects");
        return "projects";
    }

    @GetMapping("/project-form")
    public String getProjectForm(Model model) {
        if (!model.containsAttribute("project")) {
            model.addAttribute("project", new Project());
        }

        model.addAttribute("path", "projects/project-form");
        return "project-form";
    }

    @PostMapping("/project-form")
    public String submitProjectForm(@Valid @ModelAttribute("project") Project project, BindingResult errors, RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            redirectAttributes.addAttribute("project", project);
            redirectAttributes.addAttribute("org.springframework.validation.BindingResult.project", errors);

            return "redirect:project-form";
        }

        this.projectService.addProject(project);
        return "redirect:/projects";
    }
}
