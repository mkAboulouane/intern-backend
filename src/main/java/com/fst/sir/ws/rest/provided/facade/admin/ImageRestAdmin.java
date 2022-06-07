package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.Image;
import com.fst.sir.config.FileUtils;
import com.fst.sir.service.admin.facade.ImageAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/admin/image")
public class ImageRestAdmin {
    @Autowired
    private ImageAdminService imageAdminService;

    public int delete(Long id) {
        return imageAdminService.delete(id);
    }

    @GetMapping("/")
    public List<Image> findAll() {
        return imageAdminService.findAll();
    }

    @PostMapping("/")
    public long save(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Image image = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return imageAdminService.save(image);
    }

    @GetMapping("/{name}")
    public Image findByName(@PathVariable String name) throws IOException {
        Image retrievedImage = imageAdminService.findByName(name);
        Image image = new Image(retrievedImage.getId(),retrievedImage.getName(),
                retrievedImage.getType(),
                FileUtils.decompressBytes(retrievedImage.getPicByte()));
        return image;
    }


}
