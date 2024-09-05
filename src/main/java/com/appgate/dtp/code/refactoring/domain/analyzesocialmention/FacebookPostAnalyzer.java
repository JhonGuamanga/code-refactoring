package com.appgate.dtp.code.refactoring.domain.analyzesocialmention;

public class FacebookPostAnalyzer {

    /**
     * Analyzes a Facebook post and returns a score.
     *
     * @param message The message of the Facebook post to analyze.
     * @param facebookAccount The Facebook account from which the post was made.
     * @return A score representing the quality or risk associated with the publication.
     */
    public static double analyzePost(String message, String facebookAccount) {
        //To implement
        return message.length() + facebookAccount.length();
    }
}
