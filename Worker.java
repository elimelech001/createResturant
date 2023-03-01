import java.time.LocalDate;

public class Worker extends Person {
    String name;
    int TZ;
    String DOB;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTZ() {
        return TZ;
    }

    public void setTZ(int tZ) {
        TZ = tZ;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String dOB) {
        DOB = dOB;
    }

    @Override
    public String toString() {
        return "Worker [name=" + name + ", TZ=" + TZ + ", DOB=" + DOB + "]";
    }
}
