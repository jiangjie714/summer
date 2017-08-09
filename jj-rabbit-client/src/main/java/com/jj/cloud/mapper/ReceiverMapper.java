package com.jj.cloud.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.jj.cloud.domain.Receiver;

@Mapper
public interface ReceiverMapper {
   

    int insert(Receiver record);

    int insertSelective(Receiver record);


}