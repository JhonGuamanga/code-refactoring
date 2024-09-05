package com.appgate.dtp.code.refactoring.domain.analyzesocialmention;

public interface TweetRepository {
    SocialMention insertTweet(TwitterMention mention);
}
