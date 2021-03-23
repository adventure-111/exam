package cn.cuit.exam.dao;

import cn.cuit.exam.domain.Admin;
import cn.cuit.exam.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());

    /**
     * 实现用户的登录
     * @param loginUser
     * @return
     */
    public Admin login(Admin loginUser) {
        try {
            String sql = "select * from admin_t where username = ? and password = ?";
            Admin user = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public Admin findByUsername(String username) {
        String sql = "select * from admin_t where username = ?";
        try {
            Admin user = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), username);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 更新密码
     * @param user
     * @param newPwd
     * @return
     */
    public Admin updatePwd(Admin user, String newPwd) {
        Admin local_user = findByUsername(user.getUsername());
        if (local_user == null || !Admin.isPwdLegal(newPwd)) {
            return null;
        } else {
            try {
                String sql = "update admin_t set password = ? where username = ?";
                template.update(sql, newPwd, user.getUsername());
                local_user.setPassword(newPwd);
                return local_user;
            } catch (DataAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
