package fst.sir.stage_back.dao;

import fst.sir.stage_back.bean.Congres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongresDao extends JpaRepository<Congres,Long> {
}
