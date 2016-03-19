package ru.kpfu.itis.softilnyr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by softi on 02.03.2016.
 */
@Component
public class Student {
    @Value("Ilnyr")
    private String name;

    @Autowired
    @Qualifier("it")
    private Institute institute;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", institute=" + institute +
                '}';
    }
}
