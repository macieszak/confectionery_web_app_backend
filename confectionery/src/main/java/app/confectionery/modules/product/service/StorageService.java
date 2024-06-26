package app.confectionery.modules.product.service;

import app.confectionery.modules.product.model.FileData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {

    FileData uploadImageToFileSystemAndReturnFileData(MultipartFile file) throws IOException;

    FileData uploadImageToFileSystemAndReturnFileData(MultipartFile file, Long productId) throws IOException;

    byte[] downloadImageFromFileSystem(String fileName) throws IOException;

}
