package restAssured;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HttpMethod2 {
	
	@Test
	public void queryparamTest() 
	{
		Response resp = RestAssured.given()
				                   .param("userId", "1")
				                  // .param("title", "qui est esse")
				                   .when()
				                   .get("https://jsonplaceholder.typicode.com/posts");
		
		//System.out.println("response body : "+resp.body().asPrettyString());
		JsonPath path = new JsonPath(resp.body().asPrettyString());
		List<String> titles=path.get("title");
		for(String title :titles) 
		{
			System.out.println("Title :" +title);
		}
		Assert.assertEquals(titles.size(), 10);
		
		System.out.println("response statuscode : "+resp.statusCode());
		//assert
		Assert.assertEquals(resp.statusCode(), 200);
	}

}
