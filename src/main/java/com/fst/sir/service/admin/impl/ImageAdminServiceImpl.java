package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Image;
import com.fst.sir.dao.ImageDao;
import com.fst.sir.service.admin.facade.ImageAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageAdminServiceImpl implements ImageAdminService {
   @Autowired
   private ImageDao imageDao;

    @Override
    public List<Image> findAll() {
        return imageDao.findAll();
    }

    @Override
    public int save(Image image) {
        if(findByName(image.getName())!=null) return -1;
        else {
            imageDao.save(image);
            return 1;
        }
    }

    @Override
    public int update(Image image) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public Image findByName(String name) {
        return imageDao.findByName(name);
    }
}
