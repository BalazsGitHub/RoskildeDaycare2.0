package com.teletearbies.roskildedaycare.controller;

import com.teletearbies.roskildedaycare.entity.Children;
import com.teletearbies.roskildedaycare.service.ChildrenNotFoundException;
import com.teletearbies.roskildedaycare.service.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URL;
import java.util.List;

@Controller
public class ChildrenController {
    @Autowired
    private ChildrenService childrenService;


    @RequestMapping("/childrenList")
    public String displayChildrenList(Model model) {
        List<Children> listChildren = childrenService.getAllChildren();
        model.addAttribute("listChildren", listChildren);
        return "manage_children";
    }

    @RequestMapping("/children/add")
    public String addChildren(Model model) {
        model.addAttribute("children", new Children());
        return "children_form";
    }

    @PostMapping("/children/save")
    public String saveChildren(Children children, RedirectAttributes redirectAttributes) {
        childrenService.saveChildren(children);
        redirectAttributes.addFlashAttribute("message", "Child info saved!");
        return "redirect:/childrenList";
    }

    @RequestMapping("/admin")
    public String backToMainMenu() {
        return "admin_dashboard";
    }

    @RequestMapping("/children/edit/{id}")
    public String editChildren(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {

        try {
            Children children = childrenService.getChildren(id);
            model.addAttribute("children", children);
            return "children_form"; //Maybe not good

        } catch (ChildrenNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit user (ID: " + id + ")");
            return "redirect:/childrenList"; //Maybe not good
        }
    }

    @RequestMapping("/children/delete/{id}")
    public String deleteChildren(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            childrenService.deleteChildren(id);
            redirectAttributes.addFlashAttribute("message", "Child was deleted!");
        } catch (ChildrenNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/childrenList";
    }
}
