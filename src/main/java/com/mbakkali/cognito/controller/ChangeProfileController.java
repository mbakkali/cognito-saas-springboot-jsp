/** \file
 * 
 * Nov 10, 2018
 *
 * Copyright Ian Kaplan 2018
 *
 * @author Ian Kaplan, www.bearcave.com, iank@bearcave.com
 */
package com.mbakkali.cognito.controller;

import javax.servlet.http.HttpServletRequest;

import com.mbakkali.cognito.services.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.base.Strings;

@Controller
public class ChangeProfileController extends AuthenticationBase {

    @GetMapping("/change_profile")
    public ModelAndView changeProfile(ModelMap model, RedirectAttributes redirect, HttpServletRequest request) {
        String nextPage = "change_profile";
        UserInfo info = (UserInfo)request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null) {
            model.addAttribute("user_info", info);
        } else {
            nextPage = "index";
        }
        return new ModelAndView(nextPage, model);
    }
    
    /**
     * <p>
     * This is a demonstration for how to handle "profile" information. This consists of Cognito defined or custom
     * attributes. In this demo application the only value is the user's location. However, there could be many more
     * attributes (e.g., gender, relationship status, address, etc...).
     * </p>
     * @param tenant
     * @param redirect
     * @param request
     * @return
     */
    @PostMapping("/change_profile_form")
    public String changeProfileForm(@RequestParam("location") final String tenant,
                                    RedirectAttributes redirect, HttpServletRequest request) {
        String nextPage = "redirect:change_profile";
        UserInfo info = (UserInfo)request.getSession().getAttribute(USER_SESSION_ATTR);
        if (info != null) {
            if (Strings.isNullOrEmpty(tenant)) {
                redirect.addFlashAttribute("location_error", "Please add your tenant");
            } else {
                try {
                    // if the email address or location have changed, update the profile
                    if ((! info.getTenant().equals(tenant))) {
                        UserInfo newInfo = new UserInfo( info.getUserName(), info.getEmailAddr(), tenant);
                        authService.updateUserAttributes(newInfo);
                        // fetch the user information from the Cognito database so that the data in the database
                        // is displayed.
                        newInfo = authService.getUserInfo( info.getUserName());
                        request.getSession().setAttribute(USER_SESSION_ATTR, newInfo);
                    } 
                    nextPage = "redirect:application";
                } catch (Exception e) {
                    redirect.addFlashAttribute("location_error", e.getLocalizedMessage());
                }
            }
        } else {
            // Go back to the index page if the user isn't logged in. This avoids the case where
            // a post is sent when the user is not authenticated. 
            nextPage = "redirect:/";
        }
        return nextPage;
    }
}
