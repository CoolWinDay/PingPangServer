package com.pingpang.grade.mapper;

import com.pingpang.grade.model.ImageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageMapper {

    @Insert({"<script> ",
            "insert into pp_image (kid, module, pid, type, name, path) ",
            "values ",
            "<foreach collection =\"beans\" item=\"bean\" index= \"index\" separator =\",\"> ",
            "(#{bean.kid}, #{bean.module}, #{bean.pid}, #{bean.type}, #{bean.name}, #{bean.path}) ",
            "</foreach > ",
            "</script>"})
    int insertImages(@Param("beans") List<ImageBean> beans);

    @Select("SELECT * FROM pp_image WHERE module = #{module} and pid = #{pid} and type = #{type}")
    List<ImageBean> imageList(@Param("module") int module, @Param("pid") int pid, @Param("type") int type);

}
