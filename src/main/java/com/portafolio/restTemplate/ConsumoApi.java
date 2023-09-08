package com.portafolio.restTemplate;

import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumoApi {

    public ResponseEntity<?> consumoApi(String pokemon){
        JSONObject response = new JSONObject();

        try{
            String url = "https://pokeapi.co/api/v2/pokemon/"+pokemon;
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_JSON);

            //HttpEntity<>(body, headers)
            HttpEntity<String> entity = new HttpEntity<>("", headers);

            //ResponseEntity(url, HttpMethod.GET, entity, String.class)
            ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            JSONObject body = new JSONObject(result.getBody());

            response.put("data", body);

            return new ResponseEntity<>(response.toString(), HttpStatus.OK);

        }catch (Exception e){
            response.put("message", e.getMessage());

            return new ResponseEntity<>(response.toString(), HttpStatus.OK);
        }
    }
}
