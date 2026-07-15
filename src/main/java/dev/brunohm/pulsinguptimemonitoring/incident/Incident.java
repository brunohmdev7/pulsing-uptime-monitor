package dev.brunohm.pulsinguptimemonitoring.incident;

import dev.brunohm.pulsinguptimemonitoring.monitor.Monitor;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Monitor monitor;

    private Instant startedAt;
    private Instant resolvedAt = null; // enquanto nao for resolvido, valor = null
}
