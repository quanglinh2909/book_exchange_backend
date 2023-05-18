package com.erp.backend.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {
    public Resource loadByUrl(String url, String directory) {
        Path root = Paths.get(directory);
        Path file = root.resolve(url);
        try {
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new Exception("Could not read the file!");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
