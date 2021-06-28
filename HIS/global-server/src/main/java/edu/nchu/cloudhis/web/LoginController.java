package edu.nchu.cloudhis.web;

import com.alibaba.fastjson.JSON;
import com.nimbusds.jose.JOSEException;
import edu.nchu.cloudhis.model.UserInfo;
import edu.nchu.cloudhis.model.Result;
import edu.nchu.cloudhis.service.UserInfoService;
import edu.nchu.cloudhis.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 根据前端传入的用户名和密码，判断是否登录成功
     * @param condition
     * @return
     */
    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody UserInfo condition, HttpServletResponse response) throws JOSEException {
        //根据用户名来查询
        UserInfo userInfo = userInfoService.find(condition);
        //判断密码是否正确
        boolean rs = condition.getPassword().equals(userInfo.getPassword());
        log.info("登录信息:{}", JSON.toJSONString(condition));

        if(rs){
            //登录成功，生成jwttoken，并且返回
            String token = JwtUtil.genToken(userInfo.getId(), userInfo.getUsername());
            //将token装入到响应头中
            response.addHeader("access-token",token);
            log.info("Token:{}", token);
            //返回结果集
            return new Result<>(true, Result.StatusCode.OK,"login success",userInfo);
        }
        //登录失败,设置状态码为403
        response.setStatus(403);
        return new Result<>(false, Result.StatusCode.LOGINERROR,"login failed",null);
    }
}
