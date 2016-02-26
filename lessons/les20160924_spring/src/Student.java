import java.util.List;
import java.util.Map;

/**
 * Created by softi on 24.02.2016.
 */
public class Student {
    private String name;
    private Institute institute;
    private static int n = 0;
    private List<Lesson> lessons;
    private Map<String, Lesson> schedule;

    public Student(String name, Institute institute) {
        this.name = name;
        this.institute = institute;
        this.n++;
    }

    public void goToLessons() {
        for (Lesson lesson : lessons) {
            System.out.println(name + " is on " + lesson.getName());
        }
    }

    public void printSchedule() {
        System.out.println(name +"'s schedule:");
        for (String key : schedule.keySet()) {
            System.out.println(key + ": " + schedule.get(key));
        }
    }

    public void wakeUp() {
        System.out.println(name + " is not sleeping.");
    }

    public void goAsleep() {
        System.out.println(name + " went asleep.");
    }

    public Student() {
        this("", null);
    }

    public static int getN() {
        return n;
    }

    public String getName() {
        return name;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public String toString() {
        return "Student of " + this.institute + ": " + this.name;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setSchedule(Map<String, Lesson> schedule) {
        this.schedule = schedule;
    }
}
