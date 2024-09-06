package com.appgate.dtp.code.refactoring.domain;


import com.appgate.dtp.code.refactoring.application.analyzesocialmention.AnalyzeSocialMentionCommand;

public class AnalyzeSocialMentionCommandMother {
    public static AnalyzeSocialMentionCommand validCommandWithFacebook() {
        return new AnalyzeSocialMentionCommand(
            SocialMentionMother.newFacebookMention()
        );
    }

    public static AnalyzeSocialMentionCommand validCommandWithTwitter(String url) {
        return new AnalyzeSocialMentionCommand(
            SocialMentionMother.newTwitterMention(url)
        );
    }
}
