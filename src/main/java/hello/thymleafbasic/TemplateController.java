package hello.thymleafbasic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/fragment")
    public String fragment() {

        return "template/fragment/fragmentMain";
    }


    @GetMapping("/layout")
    public String layout() {

        return "template/layout/layoutMain";
    }


    @GetMapping("/layoutExtend")
    public String layoutExtend() {

        return "template/layoutExtend/layoutExtendMain";
    }

}
