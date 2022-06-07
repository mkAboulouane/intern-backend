package com.fst.sir.service.client.facade;

import com.fst.sir.bean.Notification;

import java.util.List;

public interface NotificationClientService {

    Notification findByReference(String reference);

    int deleteByReference(String reference);

    List<Notification> findByUserId(Long id);


    List<Notification> findAll();

    int deleteById(Long id);

    int update(Notification notification);


    int save(Notification notification);

    Notification findById(Long id);

    List<Notification> findByUserIdAndSeen(Long id, boolean seen);

    int save(Notification[] notifications);

    int save(String message, Long id, String status);
    List<Notification> findByStatus(String status);

    List<Notification> findByStatusAndUserId(String status, Long id);




}
