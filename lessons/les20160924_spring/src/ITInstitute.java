import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by softi on 24.02.2016.
 */
public class ITInstitute implements Institute {
    @Autowired
    private Univer univer;


    private String name;

    public ITInstitute(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "IT Institute " + this.name;
    }

    @Override
    public String toString() {
        return "ITInstitute{" +
                "name='" + name + '\'' +
                '}';
    }
}
