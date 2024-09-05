package com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.Comment;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@EqualsAndHashCode
@SuperBuilder(setterPrefix = "with")
public class FacebookMention extends SocialMention {
    private Account facebookAccount;
    private List<Comment> facebookComments;

}
