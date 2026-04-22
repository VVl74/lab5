package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Deserializer {
    ObjectMapper mapper;
    public Deserializer() {
        mapper = new ObjectMapper();
    }

    public String[] deserialize(InputPack pack) {
        String input = null;

        Wrapper prvvod = null;

        try {
            prvvod = mapper.readValue(pack.data, Wrapper.class);
        } catch (IOException e) {
            return null;
        }

        input  = prvvod.getZapr();

        if (input == null) {
            return null;
        }

        String[] parts = input.split(" ");

        return parts;
    }
}
