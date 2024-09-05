package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.domain.SocialMention;
import com.appgate.dtp.shared.utils.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = false)
@Builder(setterPrefix = "with")
@Getter
public record AnalyzeSocialMentionCommand(SocialMention socialMention) implements SelfValidating {

    public AnalyzeSocialMentionCommand(SocialMention socialMention) {
        this.socialMention = socialMention;
        this.validateSelf(this);
    }
}
