package com.pingpang.grade.controller;

import com.alibaba.fastjson.JSONObject;
import com.pingpang.grade.model.*;
import com.pingpang.grade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class GradeController {

    public static final int VenueRole = 3;
    public static final int AuditorRole = 2;
    public static final int ExamRole = 1;

    @Autowired
    private UserService userService;

    @Autowired
    private VenueService venueService;

    @Autowired
    private AuditorService auditorService;

    @Autowired
    private ExamService examService;

    @Autowired
    private ImageService imageService;

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${image.path}")
    private String location;

    /**支持图片的类型**/
    private String [] types={".jpg",".bmp",".jpeg",".png"};

    private final String PATH = "img";

    @PostMapping("/grade/venue/insert")
    public ResponseBean buildVenue(MultipartFile[] images, String jsonData, String token) throws Exception {

        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        // 建档
        int kid = -1;
        VenueBean venue = JSONObject.parseObject(jsonData, VenueBean.class);
        if (venue == null) {
            response.setErrorCode(ResponseBean.ErrorDataCode);
            response.setErrorInfo(ResponseBean.ErrorDataInfo);
            return response;
        }
        else {
            venue.setUser_id(userBean.getUser_id());
            kid = venueService.insertVenue(venue);
        }

        // 保存图片
        List<ImageBean> beanList = new ArrayList<>();

        File fileSourcePath = new File(location + PATH);
        if (!fileSourcePath.exists()) {
            fileSourcePath.mkdirs();
        }

        for (MultipartFile file : images) {
            ImageBean imageBean = new ImageBean();
            imageBean.setModule(1);
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                if (Arrays.asList(types).contains(type.toLowerCase())){
                    BufferedOutputStream out = new BufferedOutputStream(
                            new FileOutputStream(new File(fileSourcePath, fileName)));
                    out.write(file.getBytes());
                    out.flush();

                    if (kid != -1) {
                        imageBean.setPid(kid);
                    }
                    imageBean.setType(1);
                    imageBean.setName(fileName);
                    imageBean.setPath(PATH);
                    beanList.add(imageBean);
                }
            }
        }

        imageService.insertImages(beanList);
        if (userBean.getRole() < VenueRole) {
            userService.updateUserRole(userBean.getUser_id(), VenueRole);
        }

        return response;
    }

    @PostMapping("/grade/auditor/insert")
    public ResponseBean buildAuditor(MultipartFile[] certificate, MultipartFile avatar, String jsonData, String token) throws Exception {

        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        // 建档
        int kid = -1;
        AuditorBean auditor = JSONObject.parseObject(jsonData, AuditorBean.class);
        if (auditor == null) {
            response.setErrorCode(ResponseBean.ErrorDataCode);
            response.setErrorInfo(ResponseBean.ErrorDataInfo);
            return response;
        }
        else {
            auditor.setUser_id(userBean.getUser_id());
            kid = auditorService.insertAuditor(auditor);
        }

        // 保存图片
        List<ImageBean> beanList = new ArrayList<>();

        File fileSourcePath = new File(location + PATH);
        if (!fileSourcePath.exists()) {
            fileSourcePath.mkdirs();
        }

        for (MultipartFile file : certificate) {
            ImageBean imageBean = new ImageBean();
            imageBean.setModule(2);
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                if (Arrays.asList(types).contains(type.toLowerCase())){
                    BufferedOutputStream out = new BufferedOutputStream(
                            new FileOutputStream(new File(fileSourcePath, fileName)));
                    out.write(file.getBytes());
                    out.flush();

                    if (kid != -1) {
                        imageBean.setPid(kid);
                    }
                    imageBean.setType(2);
                    imageBean.setName(fileName);
                    imageBean.setPath(PATH);
                    beanList.add(imageBean);
                }
            }
        }

        if (avatar != null) {
            // 头像
            ImageBean imageBean = new ImageBean();
            imageBean.setModule(2);
            if (!avatar.isEmpty()) {
                String fileName = avatar.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                if (Arrays.asList(types).contains(type.toLowerCase())) {
                    BufferedOutputStream out = new BufferedOutputStream(
                            new FileOutputStream(new File(fileSourcePath, fileName)));
                    out.write(avatar.getBytes());
                    out.flush();

                    if (kid != -1) {
                        imageBean.setPid(kid);
                    }
                    imageBean.setType(3);
                    imageBean.setName(fileName);
                    imageBean.setPath(PATH);
                    beanList.add(imageBean);
                }
            }
            imageService.insertImages(beanList);
        }

        if (userBean.getRole() < AuditorRole) {
            userService.updateUserRole(userBean.getUser_id(), AuditorRole);
        }

        return response;
    }

    @PostMapping("/grade/exam/insert")
    public ResponseBean buildExam(MultipartFile avatar, String jsonData, String token) throws Exception {

        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        // 建档
        int examId = -1;
        ExamBean exam = JSONObject.parseObject(jsonData, ExamBean.class);
        if (exam == null) {
            response.setErrorCode(ResponseBean.ErrorDataCode);
            response.setErrorInfo(ResponseBean.ErrorDataInfo);
            return response;
        }
        else {
            exam.setUser_id(userBean.getUser_id());
            examId = examService.insertExam(exam);
        }

        // 保存图片
        List<ImageBean> beanList = new ArrayList<>();

        File fileSourcePath = new File(location + PATH);
        if (!fileSourcePath.exists()) {
            fileSourcePath.mkdirs();
        }

        if (avatar != null) {
            // 头像
            ImageBean imageBean = new ImageBean();
            imageBean.setModule(3);
            if (!avatar.isEmpty()) {
                String fileName = avatar.getOriginalFilename();
                String type = fileName.substring(fileName.lastIndexOf("."));
                if (Arrays.asList(types).contains(type.toLowerCase())){
                    BufferedOutputStream out = new BufferedOutputStream(
                            new FileOutputStream(new File(fileSourcePath, fileName)));
                    out.write(avatar.getBytes());
                    out.flush();

                    if (examId != -1) {
                        imageBean.setPid(examId);
                    }
                    imageBean.setType(3);
                    imageBean.setName(fileName);
                    imageBean.setPath(PATH);
                    beanList.add(imageBean);
                }
            }
            imageService.insertImages(beanList);
        }

        if (userBean.getRole() < ExamRole) {
            userService.updateUserRole(userBean.getUser_id(), ExamRole);
        }

        return response;
    }

    @GetMapping("/grade/venue/list")
    public ResponseBean venueList(String province, String city, String county) {
        List<VenueBean> venues = venueService.venuesWithCity(province, city, county);

        ResponseBean response = new ResponseBean();
        if (venues != null) {
            response.setData(venues);
        }

        return response;
    }

    @GetMapping("/grade/venue/checkliststate")
    public ResponseBean checkVenueListWith(int state) {
        List<VenueBean> venues = venueService.checkVenueWithState(state);

        ResponseBean response = new ResponseBean();
        if (venues != null) {
            response.setData(venues);
        }

        return response;
    }

    @GetMapping("/grade/venue/docheck")
    public ResponseBean checkVenue(int kid, String token) {
        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        boolean isSuccess = venueService.checkVenue(kid, userBean.getUser_id());
        if (!isSuccess) {
            response.setErrorCode(ResponseBean.ErrorOperationCode);
            response.setErrorInfo(ResponseBean.ErrorOperationInfo);
        }

        return response;
    }

    @GetMapping("/grade/auditor/list")
    public ResponseBean auditorList(String venueid, String token) {
        List<AuditorBean> auditors = auditorService.auditorWithVenue(venueid);

        ResponseBean response = new ResponseBean();
        if (auditors != null) {
            response.setData(auditors);
        }

        return response;
    }

    @GetMapping("/grade/auditor/checkliststate")
    public ResponseBean checkAuditorListWith(int state) {
        List<AuditorBean> auditors = auditorService.checkAuditorWithState(state);

        ResponseBean response = new ResponseBean();
        if (auditors != null) {
            response.setData(auditors);
        }

        return response;
    }

    @GetMapping("/grade/auditor/docheck")
    public ResponseBean checkAuditor(int kid, String token) {
        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        boolean isSuccess = auditorService.checkAuditor(kid, userBean.getUser_id());
        if (!isSuccess) {
            response.setErrorCode(ResponseBean.ErrorOperationCode);
            response.setErrorInfo(ResponseBean.ErrorOperationInfo);
        }

        return response;
    }

    @GetMapping("/grade/venue/myvenue")
    public ResponseBean myVenueList(String token) {

        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        List<VenueBean> venues = venueService.myVenueList(userBean.getUser_id());

        if (venues != null) {
            response.setData(venues);
        }

        return response;
    }

    @GetMapping("/grade/auditor/myauditor")
    public ResponseBean myAuditorList(String token) {
        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        List<AuditorBean> auditors = auditorService.auditorWithUser(userBean.getUser_id());

        if (auditors != null) {
            response.setData(auditors);
        }

        return response;
    }

    @GetMapping("/grade/exam/myexam")
    public ResponseBean myExamList(boolean checked, String token) {
        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        List<ExamBean> exams = examService.myExamList(checked, userBean.getUser_id());

        if (exams != null) {
            response.setData(exams);
        }

        return response;
    }

    @GetMapping("/grade/exam/checkliststate")
    public ResponseBean checkExamListWith(int state) {
        List<ExamBean> auditors = examService.checkExamsWithState(state);

        ResponseBean response = new ResponseBean();
        if (auditors != null) {
            response.setData(auditors);
        }

        return response;
    }

    @GetMapping("/grade/exam/docheck")
    public ResponseBean checkExam(int state, int kid, String token) {
        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        boolean isSuccess = examService.checkExam(state, kid, userBean.getUser_id());
        if (!isSuccess) {
            response.setErrorCode(ResponseBean.ErrorOperationCode);
            response.setErrorInfo(ResponseBean.ErrorOperationInfo);
        }

        return response;
    }

    @GetMapping("/grade/statistics")
    public ResponseBean statisticsAll(String token) {
        ResponseBean response = new ResponseBean();

        // 登录校验
        UserBean userBean = userService.userWithToken(token);
        if (userBean == null) {
            response.setErrorCode(ResponseBean.ErrorTokenCode);
            response.setErrorInfo(ResponseBean.ErrorTokenInfo);
            return response;
        }

        int v0 = venueService.venueCount(-1);
        int v1 = venueService.venueCount(1);
        int v2 = venueService.venueCount(0);

        int a0 = auditorService.auditorCount(-1);
        int a1 = auditorService.auditorCount(1);
        int a2 = auditorService.auditorCount(0);

        int e0 = examService.examCount(-1);
        int e1 = examService.examCount(1);
        int e2 = examService.examCount(2);
        int e3 = examService.examCount(0);

        StatisticsBean statisticsBean = new StatisticsBean();
        statisticsBean.setVenueCountAll(v0);
        statisticsBean.setVenueCountChecked(v1);
        statisticsBean.setVenueCountUncheck(v2);

        statisticsBean.setAuditorCountAll(a0);
        statisticsBean.setAuditorCountChecked(a1);
        statisticsBean.setAuditorCountUncheck(a2);

        statisticsBean.setExamCountAll(e0);
        statisticsBean.setExamCountPassed(e1);
        statisticsBean.setExamCountUnpass(e2);
        statisticsBean.setExamCountWaiting(e3);

        response.setData(statisticsBean);

        return response;
    }
}
