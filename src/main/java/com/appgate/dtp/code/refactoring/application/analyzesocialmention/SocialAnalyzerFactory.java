package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.application.analyzesocialmention.services.FacebookAnalyzerService;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.services.SocialAnalyzerService;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.services.TwitterAnalyzerService;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.FacebookMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.TwitterMention;

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
