package com.appgate.dtp.code.refactoring.adapters.in.analyzesocialmention.rest;

import com.appgate.dtp.code.refactoring.adapters.in.shared.TestUtil;
import com.appgate.dtp.code.refactoring.application.analyzesocialmention.AnalyzeSocialMentionUseCase;
import com.appgate.dtp.code.refactoring.domain.analyzesocialmention.valueobjects.RiskLevel;
import com.appgate.dtp.shared.config.IntegrationTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AnalyzeAnalyzeSocialMentionController.class)
@AutoConfigureMockMvc(addFilters = false)
@DisplayName("Tests for analyze social mention controller")
@Tag(IntegrationTest.TAG)
class AnalyzeAnalyzeSocialMentionControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private RiskLevel mockedRiskLevel;
    @MockBean
    private AnalyzeSocialMentionUseCase useCase;

    private String urlRequest;
    private String requestBody;
    private int responseStatus;

    @BeforeEach
    void setup() {
        this.mockedRiskLevel = RiskLevel.HIGH_RISK;
    }

    @ParameterizedTest
    @DisplayName("""
        Given a valid event request for analyzing social mention,
        When the user call the rest endpoint with POST
        Should retrieve 201 Ok with the risk level
        """)
    @CsvSource({
        "account, comment, message, 2021-01-01",
        "account2, comment2, message2, 2022-01-01",
        "account3, comment3, message3, 2023-01-01",
        "account4, comment4, message4, 2024-01-01",
    })
    void shouldAnalyzingSocialMentionWhenHasAValidRequest(String facebookAccount,
                                                     String facebookComments,
                                                     String message,
                                                     String creationDate) throws Exception {
        givenUrlRequestParams();
        givenAValidRequestBody(facebookAccount, List.of(facebookComments), message, creationDate);
        givenUseCaseExecuteIsOk();
        whenRestEndpointIsCalled();
        thenStatusIs(HttpStatus.CREATED);
    }

    @ParameterizedTest
    @DisplayName("""
        Given a valid event request for analyzing social mention,
        When the user call the rest endpoint with POST
        Should retrieve 404 Bad Request
        """)
    @CsvSource({
        "'', comment, message, 2021-01-01",
        "account2, '', message2, 2022-01-01",
        "account3, comment3, '', 2023-01-01",
        "account4, comment4, message4, ''",
        " , comment, message, 2021-01-01",
        "account2,  , message2, 2022-01-01",
        "account3, comment3,  , 2023-01-01",
        "account4, comment4, message4,  ",
    })
    void shouldReturnABadRequestWhenHasAInvalidRequest(String facebookAccount,
                                                            String facebookComments,
                                                            String message,
                                                            String creationDate) throws Exception {
        givenUrlRequestParams();
        givenAValidRequestBody(facebookAccount, facebookComments  != null ? facebookComments.isEmpty() ? null: List.of(facebookComments) : null, message, creationDate);
        whenRestEndpointIsCalled();
        thenStatusIs(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("""
        Given a valid event request for analyzing social mention,
        When the user call the rest endpoint with POST
        Should retrieve 500 Internal Error if something fail
        """)
    void shouldReturnAInternalErrorWhenSomethingFail() throws Exception {
        givenUrlRequestParams();
        givenAValidRequestBody("account", List.of("example.com"), "message", "2020-01-01");
        givenUseCaseExecuteIsFailed();
        whenRestEndpointIsCalled();
        thenStatusIs(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void givenUrlRequestParams() {
        this.urlRequest = "/api/v1/analyze-social-mention";
    }

    private void givenAValidRequestBody(String facebookAccount,
                                        List<String> facebookComments,
                                        String message,
                                        String creationDate) {
        this.requestBody = TestUtil.buildRequestBodyAsJSON(facebookAccount, facebookComments, message, creationDate);
    }

    private void whenRestEndpointIsCalled() throws Exception {

        var result = mockMvc
            .perform(post(urlRequest)
                .content(this.requestBody)
                .header(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON_VALUE))
            .andReturn();
        responseStatus = result.getResponse().getStatus();
    }

    private void givenUseCaseExecuteIsOk() {
        Mockito.when(this.useCase.execute(any()))
            .thenReturn(this.mockedRiskLevel);
    }

    private void givenUseCaseExecuteIsFailed() {
        Mockito.when(this.useCase.execute(any()))
            .thenThrow(new RuntimeException("Launching exception"));
    }

    private void thenStatusIs(HttpStatus httpStatus) {
        Assertions.assertEquals(httpStatus.value(), this.responseStatus);
    }
}
