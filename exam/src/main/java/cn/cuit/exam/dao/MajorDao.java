package cn.cuit.exam.dao;

import cn.cuit.exam.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MajorDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());
    public List<String> getMajors(String school) {
        String sql = "select major from major_t where school = '"+school+"'";
        List<String> majorList = template.queryForList(sql, String.class);
        return majorList;
    }
}
