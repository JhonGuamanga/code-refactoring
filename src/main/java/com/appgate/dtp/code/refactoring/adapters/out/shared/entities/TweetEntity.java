package com.appgate.dtp.code.refactoring.adapters.out.shared.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Entity
@Table(name = "tweet")
public class TweetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tweet_id_seq")
    @SequenceGenerator(
        name = "tweet_id_seq",
        allocationSize = 1
    )
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "tweeterAccount", nullable = false)
    private String tweeterAccount;

    @Column(name = "tweeterUrl", nullable = false)
    private String tweeterUrl;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "riskLevel")
    private String riskLevel;
}
