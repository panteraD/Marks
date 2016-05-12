package com.chernenkov.marks.web;


import com.chernenkov.marks.domain.Group;
import com.chernenkov.marks.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andrey on 03.05.2016.
 */

@Controller
public class GroupController {
    private GroupService groupService;

    @Autowired(required = true)
    @Qualifier(value = "groupService")
    public void setGroupService(GroupService groupService){
        this.groupService = groupService;
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String listGroups(Model model){
        model.addAttribute("group", new Group());
        model.addAttribute("listGroups", this.groupService.getGroupList());
        return "group"; //ne view resolvers
    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("group") Group group){
        if(group.getId()==0){
            this.groupService.createGroup(group);
        } else {
            this.groupService.updateGroup(group);
        }
        return "redirect:/groups";
    }

    @RequestMapping("/remove/{id}")
    public String removeGroup(@PathVariable("id") int id){
        this.groupService.removeGroup(id);
        return "redirect:/groups";
    }

    @RequestMapping("/edit/{id}")
    public String editGroup(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", this.groupService.getGroup(id));
        model.addAttribute("listGroups", this.groupService.getGroupList());
        return "group";
    }

}
