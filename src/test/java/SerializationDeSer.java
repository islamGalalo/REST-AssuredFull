import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerializationDeSer {
    // using POJO Class
    @Test
    public void POJO2Json() throws JsonProcessingException {
        //serialization  pojo to json
        // deserialization json to pojo

        Student data = new Student(); //pojo class
        data.setName("scott");
        data.setLocation("ksa");
        data.setPhone("55316");
        String courseArr[] = {"C", "C++"};
        data.setCourse(courseArr);
        //convert java object to json object (serialization)
        ObjectMapper mapper = new ObjectMapper();
        String jsondata = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        System.out.println(jsondata);


    }

    @Test
    public void Json2pojo() throws JsonProcessingException {
        //serialization  pojo to json
        // deserialization json to pojo
        String jsondata = "{\"name\":\"scott\",\"location\":\"ksa\",\"phone\":\"55316\"}";

        // convert json data to pojo object
        ObjectMapper obj = new ObjectMapper();
        Student studata = obj.readValue(jsondata, Student.class);
        studata.getName();
        studata.getLocation();
        studata.getPhone();
        studata.getCourse();



    }
}
