package kr.co.kku.ByeonHyeonWoo.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    @PostMapping("/session")
    public ResponseEntity<?> create() throws URISyntaxException {
        String url = "/session";
        return ResponseEntity.created(new URI(url)).body("{\"accessToken\":\"ACCESSTOKEN\"}");
    }
}
