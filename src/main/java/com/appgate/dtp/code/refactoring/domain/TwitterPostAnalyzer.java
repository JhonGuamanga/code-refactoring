package com.appgate.dtp.code.refactoring.domain;

public class TwitterPostAnalyzer {

    /**
     * Analyze a tweet and return a score.
     *
     * @param tweet The content of the tweet to analyze.
     * @param twitterAccount The Twitter account from which the tweet was made.
     * @param twitterUrl The URL of the tweet.
     * @return A score representing the quality or risk associated with the tweet.
     */
    public static double analyzeTweet(String tweet, String twitterAccount, String twitterUrl) {
        return tweet.length() + twitterAccount.length() + twitterUrl.length();
    }
}
