package com.libi.controller;

import com.libi.base.BaseController;
import com.libi.commons.ResponseTemplate;
import com.libi.entity.Assets;
import com.libi.entity.SysUser;
import com.libi.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.libi.constant.ErrorCodeConst.*;
import static com.libi.constant.SecurityConst.*;
/**
 * @author libi
 */
@Controller
@RequestMapping(ASSETS_URL)
public class AssetsController extends BaseController {
    @Autowired
    private AssetsService assetsService;

    /**
     * 为当前用户创建新的Assets
     * @param assets
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public ResponseTemplate<Assets> createAssets(Assets assets) {
        SysUser user = getLoginUser();
        assets.setOwner(user.getId());
        assets.setCreateTime(System.currentTimeMillis());
        assetsService.createNewAssets(assets);
        ResponseTemplate<Assets> responseTemplate = new ResponseTemplate<Assets>();
        responseTemplate.setMessage("创建成功");
        responseTemplate.setData(assets);
        return responseTemplate;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseTemplate getAllAssets() {
        SysUser user = getLoginUser();
        List<Assets> assetsList = assetsService.getUserAllAssets(user.getId());
        ResponseTemplate<List<Assets>> responseTemplate = new ResponseTemplate<List<Assets>>();
        responseTemplate.setMessage("获取成功");
        responseTemplate.setData(assetsList);
        return responseTemplate;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseTemplate updateAssets(HttpServletRequest request) {
        ResponseTemplate<Assets> responseTemplate = new ResponseTemplate<Assets>();
        Long assetsId = null;
        try {
            assetsId = Long.parseLong(request.getParameter("assetsId"));
        } catch (Exception e) {
            e.printStackTrace();
            responseTemplate.setCode(PARAMETER_ERROR);
            responseTemplate.setMessage("找不到assetsId参数或参数有误");
            return responseTemplate;
        }
        String assetsName = request.getParameter("assetsName");
        String note = request.getParameter("note");
        String changeOneWay = request.getParameter("changeOneWay");
        try {
            assetsService.updateAssets(assetsName, note, assetsId);
        } catch (NullPointerException e) {
            e.printStackTrace();
            responseTemplate.setCode(PARAMETER_ERROR);
            responseTemplate.setMessage("AssetsID有误");
        }

        if (changeOneWay != null) {
            assetsService.changeAssetsOneWay(assetsId);
        }
        Assets assets = assetsService.selectById(assetsId);
        responseTemplate.setData(assets);
        responseTemplate.setMessage("更新成功");
        return responseTemplate;
    }

}
