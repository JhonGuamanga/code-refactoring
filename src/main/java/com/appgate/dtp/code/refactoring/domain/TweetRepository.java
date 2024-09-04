package com.appgate.dtp.code.refactoring.domain;

public interface TweetRepository {
    SocialMention insertTweet(TwitterMention mention);
}
