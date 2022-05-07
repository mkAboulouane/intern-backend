package com.example.stage_back.service.admin.impl;

import com.example.stage_back.bean.Client;
import com.example.stage_back.service.admin.facade.ClientAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientAdminServiceImpl implements ClientAdminService {
    @Override
    public Client findByUsername(String username) {
        return null;
    }

    @Override
    public Client findByNumeroMatricule(String numeroMatricule) {
        return null;
    }

    @Override
    public int deleteByNumeroMatricule(String numeroMatricule) {
        return 0;
    }
}
