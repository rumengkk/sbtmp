package cn.bdqn.mybatisplusdemo.service.impl;

import cn.bdqn.mybatisplusdemo.entity.User;
import cn.bdqn.mybatisplusdemo.mapper.UserMapper;
import cn.bdqn.mybatisplusdemo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rumeng
 * @since 2019-12-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
