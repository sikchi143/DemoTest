package restAssured;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraAPIsAutomation {
	
	public String getSessionID() 
	{
		String sessionID=null;
		
		Response resp=RestAssured.given()
		           .body("{ \"username\": \"sikchi143\", \"password\": \"12345\" }")
		           .headers("Content-Type","application/json")
		           
		           .when()
		           .post("http://localhost:8080/rest/auth/1/session");
		//Then
		JsonPath jpath= new JsonPath(resp.body().asPrettyString());
		sessionID = jpath.get("session.value");
		return sessionID;
	}
	
	@Test
	public void getComment() 
	{
	Response resp=RestAssured.given()
		           .headers("Cookie","JSESSIONID="+getSessionID())
		           
		           .when()
		           .get("http://localhost:8080/rest/api/2/issue/DEMO-4");
		
	
		JsonPath jpath= new JsonPath(resp.body().asPrettyString());
		
		String summary= jpath.getString("fields.summary");
		Assert.assertEquals(summary,"Password Wrong...123");
		
		String emailadd=jpath.getString("fields.creator.emailAddress");
		Assert.assertEquals(emailadd,"sikchi143@gmail.com");
		
		Assert.assertEquals(resp.statusCode(),200);
		           
	}
	
	@Test
	public void addComment() 
	{
	Response resp=RestAssured.given()
			       .body("{\r\n"
			       		+ "    \"body\": \"This Comment Add From Eclipse\",\r\n"
			       		+ "    \"visibility\": {\r\n"
			       		+ "        \"type\": \"role\",\r\n"
			       		+ "        \"value\": \"Administrators\"\r\n"
			       		+ "    }\r\n"
			       		+ "}\r\n"
			       		+ "")
		           .headers("Cookie","JSESSIONID="+getSessionID())
		           .headers("Content-Type","application/json")
		           
		           .when()
		           .post("http://localhost:8080/rest/api/2/issue/DEMO-4/comment");
		
	
		JsonPath jpath= new JsonPath(resp.body().asPrettyString());
		
		String body= jpath.getString("body");
		Assert.assertEquals(body,"This Comment Add From Eclipse");
		
		Assert.assertEquals(resp.statusCode(),201);
		           
	
	}
	
	@Test
	public void getComment2() 
	{
	Response resp=RestAssured.given()
			       .headers("Cookie","JSESSIONID="+getSessionID())
		           .headers("Content-Type","application/json")
		           
		           .when()
		           .get("http://localhost:8080/rest/api/2/issue/DEMO-4/comment");
		
	
		JsonPath jpath= new JsonPath(resp.body().asPrettyString());
		
		String body= jpath.getString("comments[0].body");
		Assert.assertEquals(body,"This Comment Add From Eclipse");
		
		String emailadd= jpath.getString("comments[0].updateAuthor.visibility.type");
		Assert.assertEquals(emailadd,"role");
		
	    Assert.assertEquals(resp.statusCode(),200);
		           
 }
	
	@Test
	public void putComment2() 
	{
	Response resp=RestAssured.given()
			       .body("{\r\n"
			       		+ "    \"body\": \"This comment is added from eclips - updated\",\r\n"
			       		+ "    \"visibility\": {\r\n"
			       		+ "        \"type\": \"role\",\r\n"
			       		+ "        \"value\": \"Administrators\"\r\n"
			       		+ "    }\r\n"
			       		+ "} ")
			       .headers("Cookie","JSESSIONID="+getSessionID())
		           .headers("Content-Type","application/json")
		           
		           .when()
		           .put("http://localhost:8080/rest/api/2/issue/DEMO-4/comment/10109");
		
	
		JsonPath jpath= new JsonPath(resp.body().asPrettyString());
		
		String body= jpath.getString("body");
		Assert.assertEquals(body,"This comment is added from eclips - updated");
	
	   Assert.assertEquals(resp.statusCode(),200);
		           
 }
	

	@Test
	public void deletComment2() 
	{
	Response resp=RestAssured.given()
			       .headers("Cookie","JSESSIONID="+getSessionID())
		           .headers("Content-Type","application/json")
		           
		           .when()
		           .delete("http://localhost:8080/rest/api/2/issue/DEMO-4/comment/10110");
		
	
		JsonPath jpath= new JsonPath(resp.body().asPrettyString());
		
       Assert.assertEquals(resp.statusCode(),204);
		           
    }
}
