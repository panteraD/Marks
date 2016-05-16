package com.chernenkov.marks.web;

import com.chernenkov.marks.domain.Group;
import com.chernenkov.marks.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
public class LoginController {

    @Autowired(required = true)
    private GroupService groupService;

//    TODO:move to common class
    public static final String REDIRECT_URL = "/marks/management";
    public static final String MANAGEMENT_URL = "/management";
    public static final String DEPLOYMENT_URL = "/marks";

    @Autowired
    private AuthenticationTrustResolver resolver;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView redirectToPage() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (resolver.isAnonymous(authentication)){
//            view.setUrl(DEPLOYMENT_URL + "/login"); //if user is not authenticated redirect to login page
            modelAndView.setViewName("loginPage");
        }

        else {
            modelAndView.setViewName("management");
//            view.setUrl(DEPLOYMENT_URL + MANAGEMENT_URL);
//            ((UserDetails)authentication.getPrincipal()).getUsername() get auth login
        }

        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLoginPage(@RequestParam(value = "error", required = false) String error,
                                      @RequestParam(value = "logout", required = false) String logout,
                                      HttpServletResponse response) throws IOException {

        ModelAndView model = new ModelAndView();

        if (error != null) {
            model.addObject("error", "Access denied");
        }
        if (logout != null) {
            model.addObject("message", "Logged out successfully");
        }

        model.setViewName("loginPage");

        return model;
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public RedirectView redirectToYourPage() {
        RedirectView view = new RedirectView();
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String userName = ((UserDetails) principal).getUsername();
        view.setUrl("inside redirect to your page");
        return view;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:login?logout";
    }


    //my
    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ModelAndView showGroupPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Group> groupList = groupService.getGroupList();
        modelAndView.addObject("groups", groupList);
        modelAndView.setViewName("group");

        return modelAndView;
    }





    public String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

}
