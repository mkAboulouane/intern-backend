package com.fst.sir.dao;

import com.fst.sir.bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {

    Notification findByReference(String reference);

    int deleteByReference(String reference);

    void deleteById(Long id);

    List<Notification> findByUserId(Long id);

    List<Notification> findByStatus(String status);

    List<Notification> findByStatusAndUserId(String status, Long id);


    List<Notification> findByUserIdAndSeen(Long id, boolean seen);

}