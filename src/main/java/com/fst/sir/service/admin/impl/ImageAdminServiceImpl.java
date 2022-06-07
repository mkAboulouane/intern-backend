package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Image;
import com.fst.sir.config.FileUtils;
import com.fst.sir.dao.ImageDao;
import com.fst.sir.service.admin.facade.ImageAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageAdminServiceImpl implements ImageAdminService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public Image findById(long id) {
        return imageDao.findById(id).get();
    }

    @Override
    public int save(Image[] images) {
        Arrays.stream(images).forEach(this::save);
        return 1;
    }

    @Override
    public List<Image> findAll() {
        return imageDao.findAll();
    }

    @Override
    public long  save(Image image) {
        if (findByName(image.getName()) != null) return -1;
        else {
            image.setPicByte(FileUtils.compressBytes(image.getPicByte()));
            Image entity = imageDao.save(image);
            return entity.getId();
        }
    }



    @Override
    public int update(Image image) {
        return 0;
    }

    @Override
    @Transactional
    public int delete(Long id) {
        if(id != null)
         imageDao.deleteById(id);

        return 1;
    }

    @Override
    public Image findByName(String name) {
        Image byName = imageDao.findByName(name);
//        byName.setPicByte( FileUtils.decompressBytes(byName.getPicByte()));
        return byName;

    }
}
