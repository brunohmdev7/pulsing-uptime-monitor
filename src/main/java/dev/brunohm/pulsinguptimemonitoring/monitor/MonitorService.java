package dev.brunohm.pulsinguptimemonitoring.monitor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public List<Monitor> findAllMonitors() {
        return monitorRepository.findAll();
    }

    public Monitor registerMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }
}
