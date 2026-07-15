package dev.brunohm.pulsinguptimemonitoring.check;

import dev.brunohm.pulsinguptimemonitoring.monitor.Monitor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "check_results")
@Getter
@Setter
@NoArgsConstructor
public class CheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "monitor_id", nullable = false)
    private Monitor monitor;

    @Column(nullable = false)
    private Instant checkedAt;

    @Column(nullable = false)
    private Boolean success;

    private Integer httpStatus;      // nullable — null em timeout
    private Integer responseTimeMs;  // nullable — null em timeout
    private String errorMessage;     // nullable — null quando success = true
}
