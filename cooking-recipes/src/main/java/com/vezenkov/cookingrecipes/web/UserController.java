package com.vezenkov.cookingrecipes.web;

import com.vezenkov.cookingrecipes.entity.Gender;
import com.vezenkov.cookingrecipes.entity.User;
import com.vezenkov.cookingrecipes.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

@Controller
@Slf4j
public class UserController {
    public static final String UPLOADS_DIR = "tmp";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("path", "register-form");
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model, @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", null);
            model.addAttribute("user", user);

            return "register-form";
        }

        if (!file.isEmpty() && file.getOriginalFilename().length() > 0) {
            if (Pattern.matches("\\w+\\.(jpg|png)", file.getOriginalFilename())) {
                handleMultipartFile(file);
                user.setImageUrl(file.getOriginalFilename());
            } else {
                model.addAttribute("fileError", "Submit picture [.jpg | .png]");
                return "register-form";
            }
        } else {
            if (user.getGender() == Gender.MALE) {
                user.setImageUrl("default-male-2.jpg");
            } else if (user.getGender() == Gender.FEMALE) {
                user.setImageUrl("default-female-2.jpg");
            } else {
                user.setImageUrl("default-other.jpg");
            }
        }

        log.debug("Registering user: {}", user);

        return "redirect:/login";
    }

    private void handleMultipartFile(MultipartFile file) {
        String name = file.getOriginalFilename();
        long size = file.getSize();
        log.info("File {}, size {}", name, size);

        try {
            File currentDir = new File(UPLOADS_DIR);

            if (!currentDir.exists()) {
                currentDir.mkdirs();
            }

            String path = currentDir.getAbsolutePath() + "/" + file.getOriginalFilename();
            path = new File(path).getAbsolutePath();
            log.info(path);

            File f = new File(path);
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
