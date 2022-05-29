package com.fst.sir.service.admin.facade;

import com.fst.sir.bean.Image;

public interface ImageAdminService {

    int save(Image image);

    int update(Image image);

    int delete(Long id);

    Image findByName(String name);

}
