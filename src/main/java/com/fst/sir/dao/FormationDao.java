package com.fst.sir.dao;

import com.fst.sir.bean.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormationDao extends JpaRepository<Formation,Long> {

}
