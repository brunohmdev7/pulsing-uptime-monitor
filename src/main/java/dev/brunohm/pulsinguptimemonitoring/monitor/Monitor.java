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

    private String name;
    private String url;

    @Enumerated(EnumType.STRING)
    private MonitorHttpMethod httpMethod;

    private Integer expectedStatusCode = 200;
    private Double intervalSeconds;
    private Integer timeoutMs;
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    private MonitorStatus currentStatus;

    private Instant lastCheckedAt;
    private Instant nextCheckAt;
    private Instant createdAt;
}
