package ru.kpfu.itis.softilnyr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by softi on 02.03.2016.
 */

@Component
public class Univer {

    @Value("KFU")
    private String name;
    //private String name = "KFU";

    @Override
    public String toString() {
        return "Univer{" +
                "name='" + name + '\'' +
                '}';
    }
}
