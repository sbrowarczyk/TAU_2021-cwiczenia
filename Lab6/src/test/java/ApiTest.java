import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ApiTest {


    //Niepoprawny request
    @Test
    public void
    givenInvalidQuery_thenRetrievedBadRequestStatusCode() throws IOException {

        HttpUriRequest request = new HttpGet("https://cat-fact.herokuapp.com/facts/invalid?animal_type=cat");

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatusLine().getStatusCode());
    }

    //Sprawdzenie odpowiedzi
    @Test
    public void
    givenValidQuery_thenRetrievedOkStatusCode() throws IOException {

        HttpUriRequest request = new HttpGet("https://cat-fact.herokuapp.com/facts/random?animal_type=cat");

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }

    //Sprawdzenie kluczy
    @Test
    public void
    givenValidQuery_thenCheckKeys() throws IOException {

        HttpUriRequest request = new HttpGet("https://cat-fact.herokuapp.com/facts/random?animal_type=cat");

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);
        Set<String> keySet = Stream.of("status", "type", "deleted", "_id", "used", "source", "user", "text", "createdAt", "updatedAt", "__v").collect(Collectors.toSet());


        assertEquals(keySet, new JSONObject(EntityUtils.toString(response.getEntity())).keySet());
    }


    //Sprawdzenie wartości
    @Test
    public void
    givenValidQuery_thenCheckValue() throws IOException {

        HttpUriRequest request = new HttpGet("https://cat-fact.herokuapp.com/facts/random?animal_type=cat");

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertEquals("cat", new JSONObject(EntityUtils.toString(response.getEntity())).get("type"));
    }



}
