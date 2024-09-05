package com.appgate.dtp.code.refactoring.application.analyzesocialmention;

import com.appgate.dtp.code.refactoring.domain.AnalyzeSocialMentionCommandMother;
import com.appgate.dtp.code.refactoring.domain.SocialMentionMother;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.definitions.FacebookPostRepository;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.definitions.TweetRepository;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.entities.SocialMention;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.RiskLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests for analyzing social mention use case")
class AnalyzeSocialMentionUseCaseTest {

    private AnalyzeSocialMentionCommand command;
    private SocialMention mockedSocialMention;
    @Mock
    private TweetRepository tweetRepository;

    @Mock
    private FacebookPostRepository facebookPostRepository;

    private AnalyzeSocialMentionUseCase useCase;

    private RiskLevel response;
    private Exception exception;
    @BeforeEach
    void setup() {
        this.command = null;
        this.useCase = new AnalyzeSocialMentionUseCaseImpl(
            tweetRepository, facebookPostRepository);
        this.response = null;
        this.exception = null;
        this.mockedSocialMention = SocialMentionMother.newFacebookMention();
    }

    @Test
    @DisplayName("""
            Given a request with valid data
            when save use case is executed
            then must be saved the facebook social mention
            and return the risk level
        """)
    void shouldAnalyzeSocialMention_WhenHasAValidFacebookCommand() {
        givenThereIsValidAnalyzeFacebookSocialMentionCommand();
        givenFacebookRepositoryInsertIsOk();
        whenUseCaseIsExecuted();
        thenThereWasNoException();
        thenInsertFBPostIsInvoked();
        thenEntryResponseWasReturned();
    }

    @Test
    @DisplayName("""
            Given a request with valid data
            when save use case is executed
            then must be saved the social mention
            and return the social mention
        """)
    void shouldAnalyzeSocialMention_WhenHasAValidTweeterCommand() {
        givenThereIsValidAnalyzeTwitterMentionCommand();
        givenTweeterRepositoryInsertIsOk();
        whenUseCaseIsExecuted();
        thenThereWasNoException();
        thenInsertTweetIsInvoked();
        thenEntryResponseWasReturned();
    }

    private void givenThereIsValidAnalyzeFacebookSocialMentionCommand() {
        this.command = AnalyzeSocialMentionCommandMother.validCommandWithFacebook();
    }
    private void givenThereIsValidAnalyzeTwitterMentionCommand() {
        this.command = AnalyzeSocialMentionCommandMother.validCommandWithTwitter();
    }


    private void givenFacebookRepositoryInsertIsOk() {
        Mockito.when(this.facebookPostRepository.insertFBPost(any()))
            .thenReturn(this.mockedSocialMention);
    }

    private void givenTweeterRepositoryInsertIsOk() {
        Mockito.when(this.tweetRepository.insertTweet(any()))
            .thenReturn(this.mockedSocialMention);
    }

    private void whenUseCaseIsExecuted() {
        try {
            this.response = this.useCase.execute(this.command);
        } catch (Exception exception) {
            this.exception = exception;
        }
    }

    private void thenThereWasNoException() {
        if (this.exception != null) {
            exception.printStackTrace();
        }
        Assertions.assertNull(this.exception);
    }

    private void thenThereWasException() {
        if (this.exception != null) {
            exception.printStackTrace();
        }
        Assertions.assertNotNull(this.exception);
    }

    private void thenInsertFBPostIsInvoked() {
        verify(facebookPostRepository, times(1)).insertFBPost(any());
    }

    private void thenInsertTweetIsInvoked() {
        verify(tweetRepository, times(1)).insertTweet(any());
    }

    private void thenEntryResponseWasReturned() {
        Assertions.assertNotNull(response);
    }
}
