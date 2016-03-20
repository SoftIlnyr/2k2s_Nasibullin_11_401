package ru.kpfu.itis.softilnyr.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by softi on 20.03.2016.
 */
@Controller
@RequestMapping("/{searcher:baidu|bing|yahoo|aol}/search")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String search(ModelMap model, @PathVariable String searcher) {
        return searcher;
    }
}
