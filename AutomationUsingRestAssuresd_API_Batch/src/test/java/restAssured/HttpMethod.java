package restAssured;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HttpMethod {
	
	@Test
	public void getMethod() 
	{       // given :-pre-request param, auth,header,body etc
	Response resp = RestAssured.given()
			//when :-(http method ko call krne wale) action perform get put post patch delete etc
		           .when()
		           .get("https://jsonplaceholder.typicode.com/posts/1");
	//then:- tesponse verify - body,cookies,header,status code etc output check krna
	System.out.println("response body : "+resp.body().asPrettyString());
	//assert(expected and actual result)
	JsonPath path = new JsonPath(resp.body().asPrettyString());
	String title=path.get("title");
	Assert.assertEquals(title,"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
	
	System.out.println("response statuscode : "+resp.statusCode());
	//assert (expected and actual result)
	Assert.assertEquals(resp.statusCode(), 200);
	}
	
	/*Headers head = resp.headers();
	List<Header> hd =head.asList();
	for(Header h:hd) {
		System.out.println(h.getName()+" "+h.getValue());
	}
	
   System.out.println("response headers : "+resp.header("Date"));
	}
	*/
	
	
	
	
	@Test
	public void postMehtod() 
	{
		//given
		Map<String,String> header = new HashMap<String,String>();
		header.put("Content-type", "application/json");
		header.put("charset","UTF-8");
		
		Response resp = RestAssured.given()
		           .body("{\r\n"
		           		+ "    \"title\": \"Testing from postman\",\r\n"
		           		+ "    \"body\": \"testing\",\r\n"
		           		+ "    \"userId\": \"1\"\r\n"
		           		+ "  }")
		           .headers(header)
		           //when
		           .when()
		           .post("https://jsonplaceholder.typicode.com/posts");
        //then	   
		System.out.println("response body : "+resp.body().asPrettyString());
		System.out.println("response statuscode : "+resp.statusCode());      
	}
	
	@Test
	public void putMehtod() 
	{
		//given
		Map<String,String> header = new HashMap<String,String>();
		header.put("Content-type", "application/json");
		header.put("charset","UTF-8");
		
		Response resp = RestAssured.given()
		           .body("{\r\n"
		           		+ "    \"userId\": 1,\r\n"
		           		+ "    \"id\": 1,\r\n"
		           		+ "    \"title\": \"testing from post\",\r\n"
		           		+ "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n"
		           		+ "  }")
		           .headers(header)
		           //when
		           .when()
		           .put("https://jsonplaceholder.typicode.com/posts/1");
        //then	   
		System.out.println("response body : "+resp.body().asPrettyString());
		System.out.println("response statuscode : "+resp.statusCode());      
	}
	

	
	

}
