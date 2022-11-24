package cleane.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cleane.core.People;
import cleane.core.Tasks;
import cleane.json.LocalJsonParser;

public class ValuesService {

  People people;
  Tasks tasks;
  LocalJsonParser parser;

  public People getPeople() throws IOException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet httpGet = new HttpGet("http://localhost:3000/people");
      try (CloseableHttpResponse response1 = httpClient.execute(httpGet)) {
        HttpEntity entity1 = response1.getEntity();
        String text = new BufferedReader(new InputStreamReader(entity1.getContent())).lines().collect(Collectors.joining("\n"));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(text);
        People people = mapper.treeToValue(rootNode, People.class);
        EntityUtils.consume(entity1);
        System.out.println(people);
        return people;    
      } catch (Exception e) {
        return null;
      }
    } catch (Exception e) {
      return null;
    }
  }

  public static Tasks getTasks() throws IOException {
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      HttpGet httpGet = new HttpGet("http://localhost:3000/tasks");
        try (CloseableHttpResponse response1 = httpClient.execute(httpGet)) {
          HttpEntity entity1 = response1.getEntity();
          String text = new BufferedReader(new InputStreamReader(entity1.getContent())).lines().collect(Collectors.joining("\n"));
          ObjectMapper mapper = new ObjectMapper();
          JsonNode rootNode = mapper.readTree(text);
          Tasks tasks = mapper.treeToValue(rootNode, Tasks.class); //Funker ikke for en eller annen grunn.
          EntityUtils.consume(entity1);
          System.out.println(tasks);
          return tasks;
        } catch (Exception e) {
          return null;
        }
      } catch (Exception e) {
        return null;
    }
  }

  public void postPeople(People people) throws IOException {
    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost post = new HttpPost("http://localhost:3000/people");
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(people);
    StringEntity entity = new StringEntity(json);
    post.setEntity(entity);
    post.setHeader("Accept", "application/json");
    post.setHeader("Content-Type", "application/json");
    CloseableHttpResponse response = client.execute(post);
    System.out.println(response);
    client.close();
  }

  public  void postTasks(Tasks tasks) throws IOException {
    try (final CloseableHttpClient client = HttpClients.createDefault()) {
      HttpPost post = new HttpPost("http://localhost:3000/tasks");
      final List<NameValuePair> nvps = new ArrayList<>();
      for (int i = 0; i < tasks.size(); i++) {
        nvps.add(new BasicNameValuePair("description", tasks.getTask(i).getDescription()));
        nvps.add(new BasicNameValuePair("deadline", tasks.getTask(i).getDeadline().toString()));
        nvps.add(new BasicNameValuePair("person", tasks.getTask(i).getPerson().getName()));
      }
      post.setEntity(new UrlEncodedFormEntity(nvps));
      try (final CloseableHttpResponse response = client.execute(post)) {
        final HttpEntity entity = response.getEntity();
        String text = new BufferedReader(new InputStreamReader(entity.getContent())).lines().collect(Collectors.joining("\n"));
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(text);
        System.out.println(rootNode);
        EntityUtils.consume(entity);
      }
    }
  }
}
