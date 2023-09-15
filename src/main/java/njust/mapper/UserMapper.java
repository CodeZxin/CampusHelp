package njust.mapper;

import njust.pojo.User;

public interface UserMapper {
    User selectUser(String stuNumber);
    int insertUser(User user);

}
