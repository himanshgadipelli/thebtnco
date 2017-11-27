package com.thebtnco.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bobby on 11/16/2017.
 */
@Controller
public class BaseController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

//    private static final String DEST = "D:/Test PDFs/";
//    private static final String DEST = "/home/ubuntu/new/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("msg", "home-page");
        logger.debug("Home page!");
        return "home-page";
    }

    //    @RequestMapping(value = "/resume", method = RequestMethod.GET)
//    public String resume(ModelMap model) {
//        model.addAttribute("msg", "resume");
//        logger.debug("resume Clicks : {}", ++clicks_counter);
//        return "resume";
//    }
//
//    @RequestMapping(value = "/aboutMe", method = RequestMethod.GET)
//    public String aboutMe(ModelMap model) {
//        model.addAttribute("msg", "about-me");
//        logger.debug("about-me Clicks : {}", ++clicks_counter);
//        return "about-me";
//    }
//
//    @RequestMapping(value = "/himansh", method = RequestMethod.GET)
//    public String himansh(ModelMap model) {
//        model.addAttribute("msg", "resume");
//        logger.debug("Himansh Clicks : {}", ++clicks_counter);
//        return "resume";
//    }

    @RequestMapping(value = "/aboutThisApp", method = RequestMethod.GET)
    public String aboutThisApp() {
        logger.debug("About this Web App");
        return "about-this-app";
    }

    @RequestMapping(value = "/plex", method = RequestMethod.GET)
    public String plex() {
        logger.debug("Plex");
        return "plex";
    }

    @RequestMapping(value = "/signPdfDemo", method = RequestMethod.GET)
    public String signPdfDemo() {
        logger.debug("PDF Form demo");
        return "sign-demo";
    }

}
