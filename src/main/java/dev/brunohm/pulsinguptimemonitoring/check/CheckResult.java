package dev.brunohm.pulsinguptimemonitoring.check;

import dev.brunohm.pulsinguptimemonitoring.monitor.Monitor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.Instant;
import java.util.UUID;

public class CheckResult {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Monitor monitor;

    private Instant checkedAt;
    private Boolean sucess;
    private Integer httpStatus;
    private Integer responseTimeMs;
    private String errorMessage;
}
