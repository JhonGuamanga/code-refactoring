package com.appgate.dtp.code.refactoring.application.analyzesocialmention;


import com.appgate.dtp.code.refactoring.domain.SocialMention;

public interface AnalyzeSocialMentionUseCase {

    SocialMention execute(AnalyzeSocialMentionCommand any);
}
