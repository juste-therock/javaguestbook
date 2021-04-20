package com.memphis.guestbook;
import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MessageController implements WebMvcConfigurer {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(Message message) {
        return "form";
    }

    @GetMapping("/list")
    public String list(Model model) {
        Iterable<Message> hello = messageRepository.findAll();
        model.addAttribute("messages",hello);
        return "list.html";
    }

    @PostMapping("/")
    public String checkMessageInfo(@Valid Message message, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        else {
            messageRepository.save(message);
            return "redirect:/results";}
    }
}
