package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    public boolean upload(MultipartFile file) {
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        try {
            ObjectMetadata o1=new ObjectMetadata();
            o1.setContentLength(file.getSize());
o1.setContentType(file.getContentType());




            s3.putObject("backend-spring222",file.getOriginalFilename(),file.getInputStream(),o1);

            return true;
        }

catch(AmazonServiceException | IOException e)
{

    return false;
}



    }
}
