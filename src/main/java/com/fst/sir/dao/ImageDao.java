package com.fst.sir.dao;

import com.fst.sir.bean.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao extends JpaRepository<Image,Long> {

    Image findByName(String name);
    int deleteByName(String name);


}
