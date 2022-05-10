package fst.sir.com.dao;

import fst.sir.com.bean.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormationDao extends JpaRepository<Formation,Long> {

}
