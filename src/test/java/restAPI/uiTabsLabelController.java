package restAPI;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.junit.jupiter.api.*;
import io.restassured.RestAssured;


public class uiTabsLabelController {
  String baseURL = "http://192.168.30.181:4040/backend/rest";

  @Test
  public void getAllTabsLabels() {
    JSONObject bodyOfPost = new JSONObject();
    bodyOfPost.put("id", 0);
    bodyOfPost.put("label", "Тест API");
    System.out.println(bodyOfPost);

    new RestAssured()
            .given().log().all()
            .when()
            .contentType(ContentType.JSON)
            .body(bodyOfPost)
            .post(baseURL + "/ui/tab-label")
            .then()
            .statusCode(200);
  }
}
