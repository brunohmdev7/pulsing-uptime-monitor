package dev.brunohm.pulsinguptimemonitoring.monitor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monitors")
public class MonitorController {

    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @GetMapping
    public ResponseEntity<List<Monitor>> loadMonitors() {
        var monitors = monitorService.findAllMonitors();

        return ResponseEntity.ok(monitors);
    }

    @PostMapping
    public ResponseEntity<Monitor> registerMonitor(Monitor monitor) {
        var monitorToBeSaved = monitorService.registerMonitor(monitor);

        return ResponseEntity.ok(monitorToBeSaved);
    }
}
