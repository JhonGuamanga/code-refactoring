package com.appgate.dtp.code.refactoring.domain;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.Account;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.TwitterMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.Comment;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.Url;

import java.util.List;

public class SocialMentionMother {

    public static SocialMention newFacebookMention() {
        return FacebookMention.builder()
            .withFacebookComments(List.of(new Comment("comments")))
            .withFacebookAccount(new Account("account"))
            .withCreationDate("2022-01-01")
            .withMessage("message")
            .build();
    }

    public static SocialMention newTwitterMention(String url) {
        return TwitterMention.builder()
            .withTwitterAccount(new Account("account"))
            .withTwitterUrl(new Url(url))
            .withCreationDate("2022-01-01")
            .withMessage("message")
            .build();
    }
}
