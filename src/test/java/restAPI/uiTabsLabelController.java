package restAPI;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class uiTabsLabelController {
  String baseURL = "http://192.168.30.181:4040/backend/rest";
  String labelName = "Тест API";
  String labelId;

  @Test
  public void postOneTabLabel() {
    HashMap<String, String> bodyOfPost = new HashMap<>();
    bodyOfPost.put("id", "0");
    bodyOfPost.put("label", labelName);

    new RestAssured()
            .given().log().all()
            .when()
            .contentType(ContentType.JSON)
            .body(bodyOfPost)
            .post(baseURL + "/ui/tab-label")
            .then()
            .statusCode(200);
    getAllTabsLabels();
//    deleteOneTabLabel();
  }

  public String getAllTabsLabels() {
    String response = get(baseURL + "/ui/tab-label")
            .then()
            .statusCode(200)
            .body("label", hasItem(labelName))
            .extract()
            .asString();
    System.out.println(response);
    return response;
  }

  public  void deleteOneTabLabel(){
    new RestAssured()
            .given().log().all()
            .when()
            .delete(baseURL + "/ui/tab-label" + labelId)
            .then()
            .statusCode(200);
  }
}
