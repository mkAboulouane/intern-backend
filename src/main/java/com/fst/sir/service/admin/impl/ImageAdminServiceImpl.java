package com.fst.sir.service.admin.impl;

import com.fst.sir.bean.Image;
import com.fst.sir.dao.ImageDao;
import com.fst.sir.service.admin.facade.ImageAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int save(Image[] images) {
        Arrays.stream(images).forEach(this::save);
        return 1;
    }

    @Override
    public List<Image> findAll() {
        return imageDao.findAll();
    }

//    @Override
//    public static byte[] decompressBytes(byte[] data) {
//        Inflater inflater = new Inflater();
//        inflater.setInput(data);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] buffer = new byte[1024];
//        try {
//            while (!inflater.finished()) {
//                int count = inflater.inflate(buffer);
//                outputStream.write(buffer, 0, count);
//            }
//            outputStream.close();
//        } catch (IOException | DataFormatException ioe) {
//        }
//        return outputStream.toByteArray();
//    }
//
//    @Override
//    public  byte[] compressBytes(byte[] data) {
//        Deflater deflater = new Deflater();
//        deflater.setInput(data);
//        deflater.finish();
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] buffer = new byte[1024];
//        while (!deflater.finished()) {
//            int count = deflater.deflate(buffer);
//            outputStream.write(buffer, 0, count);
//        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//        }
//        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//        return outputStream.toByteArray();
//    }

    @Override
    public String save(Image image) {
        if (findByName(image.getName()) != null) return "ce nom deja existe";
        else {
           Image entity = imageDao.save(image);
            return entity.getName();
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
