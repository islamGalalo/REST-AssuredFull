import java.util.Arrays;

public class POJO_PostReq {
    String name;
    String location;
    String courses ;
    String phone;



    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getCourses() {
        return new String[]{courses};
    }

    public void setCourses(String[] courses) {
        this.courses = Arrays.toString(courses);
    }



}
