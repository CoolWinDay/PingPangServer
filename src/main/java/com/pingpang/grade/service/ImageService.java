package com.pingpang.grade.service;

import com.pingpang.grade.mapper.ImageMapper;
import com.pingpang.grade.mapper.VenueMapper;
import com.pingpang.grade.model.ImageBean;
import com.pingpang.grade.model.VenueBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    ImageMapper mapper;

    public void insertImages(List<ImageBean> beans) {
        mapper.insertImages(beans);
    }

}
