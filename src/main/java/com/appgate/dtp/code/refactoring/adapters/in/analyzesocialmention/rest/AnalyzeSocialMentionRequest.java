package com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest;

import com.appgate.dtp.code.refactoring.domain.SocialMention;
import com.appgate.dtp.shared.utils.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AnalyzeSocialMentionRequest implements SelfValidating {
    public static final String MESSAGE_NULL_MESSAGE = "'message' field must not be null";
    public static final String CREATION_DATE_NULL_MESSAGE = "'creationDate' field must not be null";

    @NotNull(message = MESSAGE_NULL_MESSAGE)
    private String message;

    @NotNull(message = CREATION_DATE_NULL_MESSAGE)
    private String creationDate;

    public void validateSelf() {
        this.validateSelf(this);
    }

    protected abstract SocialMention toSocialMention();
}
