/**
 * Created by softi on 24.02.2016.
 */
public class ProfInstitute implements Institute {
    private String name;

    public ProfInstitute(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Professional Institute " + this.name;
    }

    @Override
    public String toString() {
        return "ProfInstitute{" +
                "name='" + name + '\'' +
                '}';
    }
}
