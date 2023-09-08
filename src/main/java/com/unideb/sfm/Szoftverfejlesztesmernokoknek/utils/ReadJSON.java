package com.unideb.sfm.Szoftverfejlesztesmernokoknek.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unideb.sfm.Szoftverfejlesztesmernokoknek.model.Movie;

import java.io.*;
import java.util.List;

public class ReadJSON {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static List<Movie> getItemFromJson() throws IOException {
        InputStream inputStream = new FileInputStream(new File("src/main/resources/data.json"));
        TypeReference<List<Movie>> typeReference = new TypeReference<List<Movie>>() {};
        return objectMapper.readValue(inputStream, typeReference);
    }
}
