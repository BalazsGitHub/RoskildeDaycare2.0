package com.teletearbies.roskildedaycare.controller;

import com.teletearbies.roskildedaycare.entity.Children;
import com.teletearbies.roskildedaycare.entity.WaitingList;
import com.teletearbies.roskildedaycare.service.ChildrenNotFoundException;
import com.teletearbies.roskildedaycare.service.ChildrenService;
import com.teletearbies.roskildedaycare.service.WaitingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WaitingListController {
    @Autowired
    private WaitingListService waitingListService;
    @Autowired
    private ChildrenService childrenService;

    @RequestMapping("/waitingList")
    public String displayWaitingList(Model model) {
        List<WaitingList> waitingList = waitingListService.getFullWaitingList();
        model.addAttribute("waitingList", waitingList);
        return "manage_waitinglist";
    }

    @RequestMapping("/waitingList/add")
    public String addChildrenToWaitingList(Model model) {
        model.addAttribute("waitingList", new WaitingList());
        return "waitinglist_form";
    }

    @PostMapping("/waitingList/save")
    public String saveChildrenToWaitingList(WaitingList waitingList, RedirectAttributes redirectAttributes) {
        waitingListService.saveWaitingList(waitingList);
        redirectAttributes.addFlashAttribute("message", "Child info saved to waiting list!");
        return "redirect:/waitingList";
    }

    @RequestMapping("/admin2")
    public String backToMainMenuFromWaitingList() {
        return "admin_dashboard";
    }


    @RequestMapping("/waitingList/transfer/{id}")
    public String transferWaitingList(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {

        try {
            WaitingList waitingList = waitingListService.getWaitingList(id);
            Children children = new Children(waitingList.getFirstName(), waitingList.getLastName(),
                    waitingList.getParentFirstName(), waitingList.getParentLastName(), waitingList.getAddress(), waitingList.getContactNumber());
            childrenService.saveChildren(children);
            redirectAttributes.addFlashAttribute("message", "Child info saved!");

            waitingListService.deleteChildrenFromWaitingList(id);
            redirectAttributes.addFlashAttribute("message", "Children id: " + id + " was transferred to active list!");

            return "redirect:/waitingList";

        } catch (ChildrenNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "transfer children (ID: " + id + ")");
            return "redirect:/waitingList";
        }
    }


    @RequestMapping("/waitingList/edit/{id}")
    public String editWaitingList(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {

        try {
            WaitingList waitingList = waitingListService.getWaitingList(id);
            model.addAttribute("waitingList", waitingList);
            return "waitinglist_form";

        } catch (ChildrenNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            model.addAttribute("pageTitle", "edit user (ID: " + id + ")");
            return "redirect:/waitingList";
        }
    }


    @RequestMapping("/waitingList/delete/{id}")
    public String deleteChildrenFromWaitingList(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            waitingListService.deleteChildrenFromWaitingList(id);
            redirectAttributes.addFlashAttribute("message", "Child was deleted from the waiting list!");
        } catch (ChildrenNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/waitingList";

    }
}
