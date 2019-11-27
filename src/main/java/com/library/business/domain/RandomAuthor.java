package com.library.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties
public class RandomAuthor {

    private static Gson g = new Gson();
    private Name name;
    private String email;
    private Dob dob;

    public static RandomAuthor getAuthor() {
        try {
//            RestTemplate restTemplate = new RestTemplate();
//            RandomAuthor randomAuthor = restTemplate.getForObject("https://randomuser.me/api/?inc=name,email,dob", RandomAuthor.class);
//            return randomAuthor;
            String randomAuthor = Unirest.get("https://randomuser.me/api/?inc=name,email,dob").asJson()
                    .getBody().getObject().getJSONArray("results")
                    .getJSONObject(0).toString();
            return g.fromJson(randomAuthor, RandomAuthor.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @NoArgsConstructor
    public static class Name {
        String title;
        String first;
        String last;

        @Override
        public String toString() {
            g.toJson(this);
            return (title + " " + first + " " + last);
        }
    }

    @NoArgsConstructor
    public static class Dob {
        String date;

        @Override
        public String toString() {
            g.toJson(this);
            return date;
        }
    }
}