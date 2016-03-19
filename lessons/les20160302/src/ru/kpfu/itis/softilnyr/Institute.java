package ru.kpfu.itis.softilnyr;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by softi on 02.03.2016.
 */
abstract public class Institute {
    @Autowired
    protected Univer univer;

    protected String name;

    @Override
    public String toString() {
        return "Institute{" +
                "univer=" + univer +
                ", name='" + name + '\'' +
                '}';
    }
}
