package product;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws Exception{
        System.out.println("test`s begin");
        this.base = new URL("htts://localhost" + port + "/");
    }

    @Test
    public void getProduct() throws Exception{
        System.out.println("test`s begin 2");
        ResponseEntity<String> responceEntity = testRestTemplate.getForEntity(base.toString(), String.class);
        assertThat(responceEntity.getBody(), equalTo("Lets` inspect spring"));
    }
}
