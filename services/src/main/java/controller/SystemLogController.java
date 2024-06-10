package services/src/main/java/controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/systemlog")
public class JobAdvertisementController {

    @GetMapping(path = "/api/admin/logs",produces = "application/json")
    public ResponseEntity<List<SystemLog>> getAllSystemLogs() {
        List<SystemLog> systemLogs = systemLogRepository.findAll();
        return ResponseEntity.ok(systemLogs);
    }
}