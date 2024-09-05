package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.SocialMention;
import com.appgate.dtp.shared.utils.SelfValidating;
import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class AnalyzeSocialMentionCommand implements SelfValidating {

    private SocialMention socialMention;
    public AnalyzeSocialMentionCommand(SocialMention socialMention) {
        this.socialMention = socialMention;
        this.validateSelf(this);
    }
}
