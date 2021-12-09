import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;

public class Api_test {

    String baseURI = "https://api.github.com";
    String token = "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";

    @Test
    public void createNewRepo() {
        String nameBody = "{\n" +
                "    \"name\": \"CreateTestRepo\"}";
        given()
                .headers("Authorization", "Bearer " + token)
                .and()
                .body(nameBody)
                .when()
                .post(baseURI + "/user/repos")
                .then()
                .statusCode(201);
                .time(lessThan(5000L));
    }

    @Test
    public void getRepoList() {
        given()
                .headers("Authorization", "Bearer " + token)
                .when()
                .get(baseURI + "/user/repos")
                .then()
                .body("name[0]", equalTo("CreateTestRepo"))
                .statusCode(200);
                .time(lessThan(5000L));
    }
    @Test
    public void deleteCreatedRepo()  {
        given()
                .headers("Authorization", "Bearer " + token)
                .when()
                .delete(baseURI + "/repos/bekiraycibin/CreateTestRepo")
                .then()
                .statusCode(204);
    }
}
