package com.jbeli.securite.token;

import com.jbeli.securite.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class ConfirmationToken {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String token ;
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    @Column(nullable = false)
    private LocalDateTime validatedAt;
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user ;


    public ConfirmationToken(String token, LocalDateTime now, LocalDateTime localDateTime, User user) {
    }
}
