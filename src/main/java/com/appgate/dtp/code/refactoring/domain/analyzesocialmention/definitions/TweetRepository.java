package com.appgate.dtp.code.refactoring.domain.analyzesocialmention.definitions;

import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.TwitterMention;

public interface TweetRepository {
    SocialMention insertTweet(TwitterMention mention);
}
