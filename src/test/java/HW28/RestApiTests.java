package HW28;

import HW28.models.Employee;
import HW28.models.EmployeeResponse;
import HW28.models.PostEmployeeModel;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertEquals;


@Listeners(LogListener.class)
public class RestApiTests {

    @BeforeClass
    public void start() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }


    @Test
    public void getEmployeeTest() {
        given()
                .log().all()
                .when()
                .get("/employees")
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.id", hasItems("1", "2", "3"));
    }

    @Test
    public void getEmployeeNegativeTest() {
        given()
                .log().all()
                .when()
                .get("/employees")
                .then()
                .log().all()
                .statusCode(500)
                .assertThat()
                .body("status", equalTo("success"))
                .body("data.id", hasItems("1", "2", "3"));
    }

    @Test
    public void getEmployeeByIdTest() {
        Employee expextedEmployee = new Employee("Tiger Nixon", 32080, 61, "");
        EmployeeResponse expectedResponse = new EmployeeResponse("success", expextedEmployee, "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .when()
                .get("/employee/1")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);

    }

    @Test
    public void getEmployeeByIdTestNegative() {
        Employee expextedEmployee = new Employee("John Testovich", 000001, 50000, "");
        EmployeeResponse expectedResponse = new EmployeeResponse("success", expextedEmployee, "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .when()
                .get("/1")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);
    }

    @Test
    public void postEmployeeTest() {
        PostEmployeeModel employee = new PostEmployeeModel("test", "123", "23");
        EmployeeResponse expectedResponse = new EmployeeResponse("success", new Employee(), "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .with()
                .body(employee)
                .post("/create")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);
    }

    @Test
    public void postEmployeeNegativeTest() {
        PostEmployeeModel employee = new PostEmployeeModel("test", "123", "23");
        EmployeeResponse expectedResponse = new EmployeeResponse("success", new Employee(), "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .with()
                .body(employee)
                .post("wrong!")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);
    }

    @Test
    public void putEmployeeTest() {
        Map<String, String> request = new HashMap<>();
        request.put("id", "666");
        EmployeeResponse expectedResponse = new EmployeeResponse("success", new Employee(), "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .with()
                .body(request)
                .put("/update/21")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);
    }

    @Test
    public void putEmployeeNegativeTest() {
        Map<String, String> request = new HashMap<>();
        request.put("Wrong", "test");
        EmployeeResponse expectedResponse = new EmployeeResponse("successssss", new Employee(), "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .with()
                .body(request)
                .put("/update/21")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);
    }

    @Test
    public void deleteEmployeeIdTest() {
        Employee employee = new Employee(2);
        EmployeeResponse expectedResponse = new EmployeeResponse("success", employee, "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .delete("/delete/" + employee)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);
    }

    @Test
    public void deleteEmployeeIdNegativeTest() {
        Employee employee = new Employee(2);
        EmployeeResponse expectedResponse = new EmployeeResponse("success", employee, "Successfully! Record has been fetched.");
        EmployeeResponse response = given()
                .delete("/delete/" + employee)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(EmployeeResponse.class);
        assertEquals(response, expectedResponse);
    }
}