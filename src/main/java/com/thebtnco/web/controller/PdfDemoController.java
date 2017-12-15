package com.thebtnco.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pdfDemo")
public class PdfDemoController {

    @GetMapping
    public String pdfDemo() {

        //noinspection SpringMVCViewInspection
        return "pdf-demo";
    }

    @PostMapping
    public String saveAsPdf() {

        return "redirect:pdf-demo";
    }


}