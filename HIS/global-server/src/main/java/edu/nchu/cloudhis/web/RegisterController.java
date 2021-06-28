package edu.nchu.cloudhis.web;

import com.alibaba.fastjson.JSON;
import com.nimbusds.jose.JOSEException;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.model.UserInfo;
import edu.nchu.cloudhis.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class RegisterController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public Result<UserInfo> register(@RequestBody UserInfo userInfo, HttpServletResponse response)throws JOSEException {
        log.info("注册信息:{}", JSON.toJSONString(userInfo));
        userInfoService.save(userInfo);
        //再次访问，判断是否注册成功
        UserInfo ans = userInfoService.find(userInfo);
        if(ans.getId()!= null){
            //返回结果集
            return new Result<>(true, Result.StatusCode.OK,"register success", ans);
        }
        //注册失败,设置状态码为403
        response.setStatus(403);
        return new Result<>(false, Result.StatusCode.REGISTERERROR,"register failed",null);
    }
}
