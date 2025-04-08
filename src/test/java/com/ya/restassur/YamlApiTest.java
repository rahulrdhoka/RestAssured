package com.ya.restassur;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;

public class YamlApiTest {

    public static void main(String[] args) {
        // ✅ Open stream and parse directly (DON’T close early)
        Yaml yaml = new Yaml();

        try (InputStream inputStream = YamlApiTest.class
                .getClassLoader()
                .getResourceAsStream("testdata.yaml")) {

            if (inputStream == null) {
                System.err.println("❌ Failed to load YAML file");
                return;
            }

            YamlData data = yaml.loadAs(inputStream, YamlData.class);

            for (TestCase test : data.tests) {
                String url = data.base_url + test.endpoint;
                System.out.println("▶ Running: " + test.name);

                Response response = RestAssured.request(test.method, url);
                int status = response.getStatusCode();

                System.out.println("Status Code: " + status + " | Expected: " + test.expected_status);
                assert status == test.expected_status : "❌ Test Failed: " + test.name;
                System.out.println("✅ Passed\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
