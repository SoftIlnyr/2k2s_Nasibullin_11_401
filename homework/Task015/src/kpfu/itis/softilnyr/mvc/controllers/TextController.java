package kpfu.itis.softilnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by softi on 20.03.2016.
 */
@Controller
@RequestMapping("/process")
public class TextController {
    @RequestMapping(method = RequestMethod.GET)
    public String symbPage(ModelMap model) {
        return "process";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String symbCount(ModelMap model, @RequestParam String text, @RequestParam String act) {
        switch (act) {
            case "Symbols":

                model.put("result", "This text has " + text.length() + " symbols");
                break;
            case "Words":
                int count = 0;
                Pattern pattern = Pattern.compile("(\\w )");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    count++;
                }
                model.put("result", "This text has " + count + " words");
                break;
            case "Sentences":
                count = 0;
                pattern = Pattern.compile("(\\w[.!?])");
                matcher = pattern.matcher(text);
                while (matcher.find()) {
                    count++;
                }
                model.put("result", "This text has " + count + " sentences");
                break;
            case "Articles":
                count = 0;
                pattern = Pattern.compile(".?\n");
                matcher = pattern.matcher(text);
                while (matcher.find()) {
                    count++;
                }
                model.put("result", "This text has " + count + " articles");
                break;
        }
        return "process";
    }


}
