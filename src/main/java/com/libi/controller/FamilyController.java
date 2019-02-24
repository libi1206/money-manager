package com.libi.controller;

import com.libi.base.BaseController;
import com.libi.commons.ResponseTemplate;
import com.libi.entity.Family;
import com.libi.entity.SysUser;
import com.libi.service.FamilyService;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author libi
 */
@Controller
@RequestMapping("/family")
public class FamilyController extends BaseController {
    @Autowired
    private FamilyService familyService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseTemplate createFamilyForUser(Family family) {
        family.setCreateTime(System.currentTimeMillis());
        familyService.createFamily(family, getLoginUser().getId());
        ResponseTemplate<Family> responseTemplate = new ResponseTemplate<Family>();
        responseTemplate.setMessage("创建成功");
        responseTemplate.setData(family);
        return responseTemplate;
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    @ResponseBody
    public ResponseTemplate joinFamily(HttpServletRequest request) {
        Long familyId = Long.parseLong(request.getParameter("familyId"));
        System.out.println(familyId);
        familyService.joinFamily(familyId, getLoginUser().getId());
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setMessage("加入成功");
        return responseTemplate;
    }

    @RequestMapping(value = "/quit", method = RequestMethod.GET)
    @ResponseBody
    public ResponseTemplate quitFamily(HttpServletRequest request) {
        Long familyId = Long.parseLong(request.getParameter("familyId"));
        familyService.quitFamily(familyId, getLoginUser().getId());
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setMessage("退出成功");
        return responseTemplate;
    }

    @RequestMapping(value = "/getAllFamily", method = RequestMethod.GET)
    @ResponseBody
    public ResponseTemplate selectAllFamilyInUser() {
        ResponseTemplate<List<Family>> responseTemplate = new ResponseTemplate<List<Family>>();
        responseTemplate.setData(familyService.getAllFamilies(getLoginUser().getId()));
        responseTemplate.setMessage("查询成功");
        return responseTemplate;
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseTemplate selectAllUserInFamily(HttpServletRequest request) {
        Long familyId = Long.parseLong(request.getParameter("familyId"));
        ResponseTemplate<List<SysUser>> responseTemplate = new ResponseTemplate<List<SysUser>>();
        List<SysUser> userList = familyService.getAllMembers(familyId);
        for (SysUser user : userList) {
            user.setPassword("嘻嘻，不告诉你");
        }
        responseTemplate.setData(userList);
        responseTemplate.setMessage("查询成功");
        return responseTemplate;
    }
}
