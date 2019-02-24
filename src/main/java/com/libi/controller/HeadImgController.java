package com.libi.controller;

import com.libi.base.BaseController;
import com.libi.commons.ResponseTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import static com.libi.constant.ErrorCodeConst.*;

@Controller
@RequestMapping("/user")
public class HeadImgController extends BaseController {
    @RequestMapping(value = "/head",method = RequestMethod.POST)
    @ResponseBody
    public ResponseTemplate uploadHeadImage(HttpServletRequest request, MultipartFile file) throws IOException {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        if (file != null) {
            String path = null;
            String type = null;
            String fileName = file.getOriginalFilename();
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath +/*System.getProperty("file.separator")+*/trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                } else {
                    responseTemplate.setCode(PARAMETER_ERROR);
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return responseTemplate;
                }
            } else {
                responseTemplate.setCode(PARAMETER_ERROR);
                responseTemplate.setMessage("文件类型为空");
                return null;
            }
        } else {
            responseTemplate.setCode(PARAMETER_ERROR);
            responseTemplate.setMessage("没有找到相对应的文件");
            return null;
        }
        responseTemplate.setMessage("上传成功");
        return responseTemplate;
    }
}
