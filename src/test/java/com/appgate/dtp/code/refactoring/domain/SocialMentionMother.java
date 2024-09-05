package com.appgate.dtp.code.refactoring.domain;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.TwitterMention;

import java.util.Arrays;

public class SocialMentionMother {

    public static SocialMention newFacebookMention() {
        return FacebookMention.builder()
            .withFacebookComments(Arrays.asList("comments"))
            .withFacebookAccount("account")
            .withCreationDate("2022-01-01")
            .withMessage("message")
            .build();
    }

    public static SocialMention newTwitterMention() {
        return TwitterMention.builder()
            .withTwitterAccount("account")
            .withTwitterUrl("url")
            .withCreationDate("2022-01-01")
            .withMessage("message")
            .build();
    }
}
