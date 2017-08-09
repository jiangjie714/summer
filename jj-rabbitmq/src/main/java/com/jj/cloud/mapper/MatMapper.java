package com.jj.cloud.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.jj.cloud.domain.Mat;

@Mapper
public interface MatMapper {

    int insert(Mat record);

    int insertSelective(Mat record);
    
    public ArrayList<Mat> getList() ;

}