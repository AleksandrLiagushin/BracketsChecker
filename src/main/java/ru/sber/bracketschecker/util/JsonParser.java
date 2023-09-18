package ru.sber.bracketschecker.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.sber.bracketschecker.exception.JsonFieldException;

public class JsonParser {

    public static String getText(String json) throws JsonProcessingException, JsonFieldException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);
        if (jsonNode.size() > 1) {
            throw new JsonFieldException("Json has more then one field");
        }
        String text = jsonNode.get("text").asText();
        if (text.isEmpty() || text.isBlank()) {
            throw new JsonFieldException("Json \"text\" field is empty");
        }
        return text;
    }
}
