package com.appgate.dtp.code.refactoring.domain;

import com.appgate.dtp.code.refactoring.application.analyzesocialmention.FacebookAnalyzerService;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.SocialAnalyzerService;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.TwitterAnalyzerService;

public class SocialAnalyzerFactory {

    public static SocialAnalyzerService getAnalyzer(SocialMention mention) {
        if (mention instanceof FacebookMention) {
            return new FacebookAnalyzerService();
        } else if (mention instanceof TwitterMention) {
            return new TwitterAnalyzerService();
        }
        throw new IllegalArgumentException("Unsupported mention type");
    }
}
