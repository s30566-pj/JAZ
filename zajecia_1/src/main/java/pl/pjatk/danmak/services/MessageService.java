package pl.pjatk.danmak.services;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public ResponseEntity<String> responseEntity(String wartosc){
        if (wartosc != null){
            return ResponseEntity.ok(wartosc);
        } else {
            return ResponseEntity.ok("Hello world");
        }
    }
}
