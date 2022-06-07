package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.Image;

import java.util.List;

public interface ImageAdminService {

    long save(Image image);
    
    int save(Image[] images);

    int update(Image image);

    int delete(Long id);

    Image findByName(String name);

    List<Image> findAll();

    Image findById(long id);

}
