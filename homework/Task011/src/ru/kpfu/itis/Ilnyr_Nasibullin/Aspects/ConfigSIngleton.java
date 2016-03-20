package ru.kpfu.itis.Ilnyr_Nasibullin.Aspects;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;

/**
 * Created by Ilnyr on 10.10.2015.
 */
public class ConfigSIngleton {
    private static Configuration config;

    public static Configuration getConfig(ServletContext sc) {
        if (config == null) {
            config = new Configuration(Configuration.VERSION_2_3_22);
            config.setServletContextForTemplateLoading(sc, "/templates");
            config.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);

        }
        return config;
    }


}
