package fst.sir.com.dao;

import fst.sir.com.bean.Congres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongresDao extends JpaRepository<Congres,Long> {
}
