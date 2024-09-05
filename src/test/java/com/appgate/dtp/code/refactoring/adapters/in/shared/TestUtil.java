package com.appgate.dtp.code.refactoring.adapters.in.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public final class TestUtil {

    private TestUtil() {
    }

    public static String buildObjectAsJSON(Object request) {
        try {
            return new ObjectMapper().writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }

    public static String buildRequestBodyAsJSON(
        String facebookAccount,
        List<String> facebookComments,
        String message,
        String creationDate) {

        final var request = new FacebookMentionRequest();
        request.setFacebookAccount(facebookAccount);
        request.setFacebookComments(facebookComments);
        request.setMessage(message);
        request.setCreationDate(creationDate);

        return buildObjectAsJSON(request);
    }
}
