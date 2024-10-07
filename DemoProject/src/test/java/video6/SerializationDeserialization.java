package video6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // imported not from rest assured . should be jackson
import org.testng.annotations.Test;

// POJO ->Serialization-> JSON Object ->Deserialization-> POJO

public class SerializationDeserialization {

    String jsonData;

    @Test(priority = 1)
    void convertPojoToJson() throws JsonProcessingException { // POJO to JSON (Serialization)

        Student studentPOJO = new Student();
        studentPOJO.setName("Scotty");
        studentPOJO.setLocation("France");
        studentPOJO.setPhone("89783463543");
        studentPOJO.setCourses(new String[] {"C++", "RestAPI"});

        ObjectMapper objectMapper = new ObjectMapper();
        String JSONData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentPOJO); // JSON will be return in the form of String
        System.out.println(JSONData);
        jsonData = JSONData;
    }

    @Test(priority = 2)
    void convertJsonToPojo() throws JsonProcessingException { // JSON to POJO (Deserialization)

        ObjectMapper objectMapper = new ObjectMapper();

        Student student = objectMapper.readValue(jsonData, Student.class); // creates Student object
        System.out.println(student.getName());
        System.out.println(student.getCourses()[0]);

    }


}
