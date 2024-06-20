package org.example.projectspringfalling._core.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class FileUtil {

    // 파일을 Base64로 디코딩하여 저장하고 UUID 파일명을 반환하는 메서드
    public static String decodeAsUUID(String fileData, String extension) throws IOException {
        byte[] data = Base64.getDecoder().decode(fileData);
        String fileUUID = UUID.randomUUID() + "." + extension;
        String filePath = "./upload/" + fileUUID;

        // 파일로 저장
        File file = new File(filePath);
        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(data);
        }

        return fileUUID;
    }

    // 파일을 저장하고 UUID 파일명을 반환하는 메서드
    public static String storeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("파일이 비어있습니다.");
        }

        String originalFileName = file.getOriginalFilename();
        String fileUUID = UUID.randomUUID() + "_" + originalFileName;
        Path filePath = Paths.get("./upload/" + fileUUID);

        // 디렉토리가 없으면 생성
        File uploadDir = new File("./upload/");
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();
            if (!created) {
                throw new IOException("업로드 디렉토리를 생성할 수 없습니다.");
            }
        }

        // 파일 저장
        file.transferTo(filePath.toFile());

        return fileUUID;
    }

    // 파일을 Base64로 인코딩하는 메서드
    public static String encode(String fileName) throws IOException {
        String filePath = "./upload/" + fileName;
        File file = new File(filePath);

        // 파일이 존재하면 읽어들임
        if (file.exists()) {
            try (InputStream inputStream = new FileInputStream(file)) {
                byte[] fileData = IOUtils.toByteArray(inputStream);
                return Base64.getEncoder().encodeToString(fileData);
            }
        } else {
            throw new FileNotFoundException("파일을 찾을 수 없습니다: " + filePath);
        }
    }

    // 파일의 UUID를 생성하는 메서드
    public static String generateUUIDFileName(String fileName) {
        return UUID.randomUUID() + "_" + fileName;
    }
}
