package com.pingpang.grade.controller;

import com.pingpang.grade.model.VenueBean;
import com.pingpang.grade.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

@RestController
public class GradeController {

    @Autowired
    private VenueService mService;

    @PostMapping("/grade/venue/insert")
    public String insertVenue(VenueBean bean) {
        mService.insertVenue(bean);
        return "helloworld";
    }

//    private static final Logger LOGGER = LoggerFactory.getLogger(GradeController.class);

    /**支持图片的类型**/
    private String [] types={".jpg",".bmp",".jpeg",".png"};

    private final String PATH = "img";
    /**
     * 上传文件
     * @param files
     * @return
     * @throws Exception
     */
    @PostMapping("/image")
    public String upload(@RequestParam(value = "file",required = false) MultipartFile[] files) throws Exception {
//        RespInfo respInfo = new RespInfo();

        for (MultipartFile file : files) {
            String fileName = "";
            if (!file.isEmpty()) {
                fileName = file.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                if (Arrays.asList(types).contains(type)){

                    BufferedOutputStream out = null;
                    File fileSourcePath = new File(PATH);
                    if (!fileSourcePath.exists()) {
                        fileSourcePath.mkdirs();
                    }
                    fileName = file.getOriginalFilename();
//                LOGGER.info("上传的文件名为：" + fileName);
                    out = new BufferedOutputStream(
                            new FileOutputStream(new File(fileSourcePath, fileName)));
                    out.write(file.getBytes());
                    out.flush();
                    System.out.println(fileName.toString());
//                respInfo.setStatus(InfoCode.SUCCESS);
//                respInfo.setMesssage("上传成功！");
//                return JSON.toJSONString(respInfo);
                }
//            respInfo.setMesssage("此格式不支持！");
//            respInfo.setStatus(InfoCode.FAIL);
//            return JSON.toJSONString(respInfo);
            }
//        respInfo.setMesssage("文件不能为空！");
//        respInfo.setStatus(InfoCode.FAIL);
//        return JSON.toJSONString(respInfo);
        }

        return "";
    }

}
