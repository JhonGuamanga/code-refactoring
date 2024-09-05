package com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest;

import com.appgate.dtp.code.refactoring.adapters.in.shared.FacebookMentionRequest;
import com.appgate.dtp.code.refactoring.adapters.in.shared.TwitterMentionRequest;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.shared.utils.SelfValidating;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "socialMention")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FacebookMentionRequest.class, name = "facebook"),
    @JsonSubTypes.Type(value = TwitterMentionRequest.class, name = "tweeter")
})
public abstract class AnalyzeSocialMentionRequest implements SelfValidating {
    public static final String MESSAGE_NULL_MESSAGE = "'message' field must not be null";
    public static final String CREATION_DATE_NULL_MESSAGE = "'creationDate' field must not be null";

    @NotNull(message = MESSAGE_NULL_MESSAGE)
    @NotEmpty
    private String message;

    @NotNull(message = CREATION_DATE_NULL_MESSAGE)
    @NotEmpty
    private String creationDate;

    public void validateSelf() {
        this.validateSelf(this);
    }

    protected abstract SocialMention toSocialMention();
}
