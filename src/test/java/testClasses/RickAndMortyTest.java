package testClasses;

import hooks.WebHooks;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pages.RestSteps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class RickAndMortyTest extends WebHooks {
    @Test
    public void test1(){
        new RestSteps()
                .getApi("https://jsonplaceholder.typicode.com/posts",200);
    }

    @Test
    public void test2() throws IOException {

//        JSONObject body = new JSONObject();
//        body.put("name", "morpheus");
//        body.put("job", "leader");

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/json/paren.json"))));

        new RestSteps()
                .postApi("https://reqres.in", "/api/users", body.toString(),201);


    }
}
