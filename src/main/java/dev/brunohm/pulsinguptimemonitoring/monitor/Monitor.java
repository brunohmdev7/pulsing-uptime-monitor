package dev.brunohm.pulsinguptimemonitoring.monitor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "monitors")
@Getter
@Setter
@NoArgsConstructor
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonitorHttpMethod httpMethod;

    @Column(nullable = false)
    private Integer expectedStatusCode = 200;

    @Column(nullable = false)
    private Double intervalSeconds;

    @Column(nullable = false)
    private Integer timeoutMs;

    @Column(nullable = false)
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MonitorStatus currentStatus;

    private Instant lastCheckedAt;   // nullable — null até o 1º check

    @Column(nullable = false)
    private Instant nextCheckAt;

    @Column(nullable = false)
    private Instant createdAt;
}
