package com.appgate.dtp.code.refactoring.adapters.out.shared.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Entity
@Table(name = "facebook_post")
public class FacebookPostEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "facebook_post_id_seq")
    @SequenceGenerator(
        name = "facebook_post_id_seq",
        allocationSize = 1
    )
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "facebookAccount", nullable = false)
    private String facebookAccount;

    @Column(name = "facebookComments", nullable = false)
    private String facebookComments;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "riskLevel")
    private String riskLevel;
}
