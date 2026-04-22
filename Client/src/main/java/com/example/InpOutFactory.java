package com.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.ByteBuffer;

public class InpOutFactory {
    ObjectMapper mapper;
    public InpOutFactory() {
        mapper = new ObjectMapper();
    }

    public ByteBuffer OutputFactory(String input) throws JsonProcessingException {
        input = input.trim();

        if (input.equals("exit")) {
            System.exit(0);
        }
        Wrapper outWrap = new Wrapper();

        outWrap.setZapr(input);

        byte[] jsonByte = mapper.writeValueAsBytes(outWrap);

        return ByteBuffer.wrap(jsonByte);
    }

    public String InputFactory(ByteBuffer buffer) throws IOException {
        if (buffer == null) {
            return "";
        }

        buffer.flip();
        byte[] data = new byte[buffer.limit()];

        buffer.get(data);

        Wrapper prvvod = mapper.readValue(data, Wrapper.class);

        String itog  = prvvod.getZapr();

        return itog;
    }
}
