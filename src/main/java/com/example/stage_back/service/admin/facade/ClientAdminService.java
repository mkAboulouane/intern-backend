package com.example.stage_back.service.admin.facade;

import com.example.stage_back.bean.Client;

public interface ClientAdminService {

    Client findByUsername(String username);

    Client findByNumeroMatricule(String numeroMatricule);

    int deleteByNumeroMatricule(String numeroMatricule);

}
