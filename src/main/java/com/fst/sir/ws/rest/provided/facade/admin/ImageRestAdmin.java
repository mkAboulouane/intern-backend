package com.fst.sir.ws.rest.provided.facade.admin;

import com.fst.sir.bean.Image;
import com.fst.sir.service.admin.facade.ImageAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/admin/upload")
public class ImageRestAdmin {
    @Autowired
    private ImageAdminService imageAdminService;


    @PostMapping("/")
//    public ResponseEntity.BodyBuilder save(@RequestParam("file") MultipartFile file) throws IOException {
    public int save(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Image image = new Image(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));
       return imageAdminService.save(image);
//        return ResponseEntity.status(HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public Image findByName(@PathVariable String name) throws IOException {
        Image retrievedImage = imageAdminService.findByName(name);
        Image image = new Image(retrievedImage.getName(), retrievedImage.getType(),
                decompressBytes(retrievedImage.getPicByte()));
        return image;
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException | DataFormatException ioe) {
        }
        return outputStream.toByteArray();
    }

    /*
    *     @GetMapping(path = { "/get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
        ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
    * */

    public int update(Image image) {
        return imageAdminService.update(image);
    }

    public int delete(Long id) {
        return imageAdminService.delete(id);
    }
}
