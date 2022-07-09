package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.Notification;
import com.fst.sir.service.client.facade.NotificationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/notification")
public class NotificationRestAdmin {
    @Autowired
    private NotificationClientService notificationClientService;

    @PostMapping("/to-all/message/{message}/status/{status}")
    public int toAll(@PathVariable String message,@PathVariable String status) {
        return notificationClientService.toAll(message, status);
    }

    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return notificationClientService.deleteById(id);
    }

    @GetMapping("/reference/{reference}")
    public Notification findByReference(@PathVariable String reference) {
        return notificationClientService.findByReference(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public int deleteByReference(@PathVariable String reference) {
        return notificationClientService.deleteByReference(reference);
    }

    @GetMapping("/user-id/{id}")
    public List<Notification> findByUserId(@PathVariable Long id) {
        return notificationClientService.findByUserId(id);
    }

    @GetMapping("/")
    public List<Notification> findAll() {
        return notificationClientService.findAll();
    }

    @PutMapping("/")
    public int update(@RequestBody Notification notification) {
        return notificationClientService.update(notification);
    }

    @PostMapping("/")
    public int save(@RequestBody Notification notification) {
        return notificationClientService.save(notification);
    }

    @GetMapping("/id/{id}")
    public Notification findById(@PathVariable Long id) {
        return notificationClientService.findById(id);
    }
    @GetMapping("/seen/id/{id}/seen/{seen}")
    public List<Notification> findByUserIdAndSeen(@PathVariable Long id,@PathVariable boolean seen) {
        return notificationClientService.findByUserIdAndSeen(id, seen);
    }

    // Deprecated
    public int save(Notification[] notifications) {
        return notificationClientService.save(notifications);
    }

    // Origin
    @PostMapping("/save/{message}/user-id/{id}/status/{status}")
    public int save(@PathVariable String message,@PathVariable Long id,@PathVariable String status) {
        return notificationClientService.save(message, id, status);
    }

    @GetMapping("/status/{status}")
    public List<Notification> findByStatus(@PathVariable String status) {
        return notificationClientService.findByStatus(status);
    }

    @GetMapping("/status/{status}/user-id/{id}")
    public List<Notification> findByStatusAndUserId(@PathVariable String status,@PathVariable Long id) {
        return notificationClientService.findByStatusAndUserId(status, id);
    }
}
