package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.Paiment;
import com.fst.sir.enums.TypePaiment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaimentAdminService {
    List<Paiment> findAll();


    List<Paiment> findByTypePaiment(TypePaiment typePaiment);

    List<Paiment> findByPanierUserUsername(String username);

    Paiment findByReference(String reference);
    int deleteByReference(String reference);

    Paiment save(Paiment paiment);

    Paiment update(Paiment paiment);





}
