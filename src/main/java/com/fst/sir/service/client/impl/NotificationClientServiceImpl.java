package com.fst.sir.service.client.impl;

import com.fst.sir.bean.Notification;
import com.fst.sir.dao.NotificationDao;
import com.fst.sir.security.bean.User;
import com.fst.sir.security.service.facade.UserService;
import com.fst.sir.service.client.facade.NotificationClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NotificationClientServiceImpl implements NotificationClientService {
    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public int deleteById(Long id) {
        notificationDao.deleteById(id);
        return 1;
    }

    @Override
    public Notification findByReference(String reference) {
        return notificationDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return notificationDao.deleteByReference(reference);
    }

    @Override
    public List<Notification> findByUserId(Long id) {
        return notificationDao.findByUserId(id);
    }

    @Override
    public List<Notification> findAll() {
        return notificationDao.findAll();
    }

    @Override
    public int save(String message, Long id, String status) {
        User user = userService.findById(id);
        if (user == null) return -1;
        else {
            Notification notification = prepare(user, message, status);
            notificationDao.save(notification);
            return 1;
        }
    }

    private Notification prepare(User user, String message, String status) {
        return new Notification(
                status, false, message, new Date(), user
        );
    }


    @Override
    public int update(Notification notification) {
        Notification foundedById = findById(notification.getId());
        if (foundedById == null || notification.getUser() == null) {
            return -1;
        } else {
            foundedById.setId(notification.getId());
            foundedById.setUser(notification.getUser());
            foundedById.setSeen(true);
            foundedById.setSeenAt(new Date());
            notificationDao.save(foundedById);
            return 1;
        }
    }

    // Not needed yet
    @Override
    public int save(Notification notification) {
        User user = userService.findById(notification.getUser().getId());
        if (user == null) return -1;
        else{
            Notification entity = prepare(user, notification.getMessage(), notification.getStatus());
            notificationDao.save(entity);
            return 1;
        }
    }

    @Override
    public Notification findById(Long id) {
        return notificationDao.findById(id).orElse(null);
    }

    @Override
    public List<Notification> findByUserIdAndSeen(Long id, boolean seen) {
        return notificationDao.findByUserIdAndSeen(id, seen);
    }

    // Not needed yet
    @Override
    public int save(Notification[] notifications) {
        for (Notification notification : notifications) {
            save(notification);
        }
        return 1;
    }

    @Override
    public List<Notification> findByStatus(String status) {
        return notificationDao.findByStatus(status);
    }

    @Override
    public List<Notification> findByStatusAndUserId(String status, Long id) {
        return notificationDao.findByStatusAndUserId(status, id);
    }
}
