package com.fst.sir.dao;

import com.fst.sir.bean.Paiment;
import com.fst.sir.enums.TypePaiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaimentDao extends JpaRepository<Paiment,Long> {



}
