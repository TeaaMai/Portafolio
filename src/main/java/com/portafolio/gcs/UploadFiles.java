package com.portafolio.gcs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;


@Service
public class UploadFiles {
	
	@Autowired
	private Credentials credentials;
    
    public String uploadToFileSystem(UploadObj uploadObj) throws IOException {
    	
        Date date = new Date();
        String fileName = StringUtils.cleanPath(uploadObj.getFile().getOriginalFilename());
        String[] split =fileName.split("\\.");
        String name = "";
        for(int i = 0;i < (split.length - 1);i++){
            if(i == 0){
                name = split[i];
            }else{
                name = name + "." + split[i];
            }
        }
        fileName = name + date.getTime() + "." + split[split.length-1];
        Path path = Paths.get(uploadObj.getPath()+ "/" + fileName);
        Files.copy(uploadObj.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        Storage storage = StorageOptions.newBuilder().setProjectId(credentials.getProjectId()).build().getService();
        BlobId blobId = BlobId.of(credentials.getBucketName(), uploadObj.getDirectory()+"/"+fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        byte[] data = Files.readAllBytes(path);
        storage.create(blobInfo, data);
        Blob blob = storage.get(BlobId.of(credentials.getBucketName(), uploadObj.getDirectory() +"/"+ fileName));

        Path pathAlt = Paths.get(uploadObj.getPath()+ "/" + name + "." + split[split.length-1]);
        Files.copy(uploadObj.getFile().getInputStream(), pathAlt, StandardCopyOption.REPLACE_EXISTING);

        return blob.getMediaLink();
    }

}
