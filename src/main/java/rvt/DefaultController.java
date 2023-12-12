package rvt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

    
   @GetMapping(value = "/")
    String index(@RequestParam(name="name", required=false, defaultValue="null") String name, Model model) {
        return "index";
    }

    @GetMapping(value = '/about')
    ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView('about');

        String name = "Marsels";
        String surname = "Ziediņš";
        String age = "17";
        String group = "DP2-1";

        modelAndView.addObject("age", age);
        modelAndView.addObject("name", name);
        modelAndView.addObject("surname", surname);
        modelAndView.addObject("group", group);

        return modelAndView;




    }




}

