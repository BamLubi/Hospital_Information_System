package edu.nchu.cloudhis.service;

import edu.nchu.cloudhis.dao.UserInfoDao;
import edu.nchu.cloudhis.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService extends BaseService<UserInfoDao, UserInfo> {
}
