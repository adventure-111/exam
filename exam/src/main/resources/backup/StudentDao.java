package cn.cuit.exam.dao;

import cn.cuit.exam.domain.studentUser;
import cn.cuit.exam.domain.student_t;
import cn.cuit.exam.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StudentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());

    /**
     * 根据学号查找学生
     * @param sno
     * @return
     */
    public student_t queryBSno(String sno) {
        String sql = "select * from student_t where sno = ?";
        try {
            student_t stu = template.queryForObject(sql, new BeanPropertyRowMapper<student_t>(student_t.class), sno);
            return stu;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询功能
     * @param major
     * @param grade
     * @param className
     * @param sname
     * @param sno
     * @return
     */
    public List<student_t> queryForStudent(String major, int grade, String className, String sname, String sno) {
        List<Map<String, Object>> list[] = new List[5];
        StringBuilder sql = new StringBuilder("select * from class_t, student_t where class_t.classname = student_t.classname ");
        int cnt = 0;

        if (major != null) {
            sql.append("and class_t.major = ?");
            list[0] = template.queryForList(sql.toString(), major);
            cnt++;
        }

        if (grade != 0) {
            sql.append("and class_t.grade = ?");
            list[1] = template.queryForList(sql.toString(), grade);
            cnt++;
        }

        if (className != null) {
            sql.append("and class_t.classname = ?");
            list[2] = template.queryForList(sql.toString(), className);
            cnt++;
        }

        if (sname != null) {
            sql.append("and student_t.sname = ?");
            list[3] = template.queryForList(sql.toString(), sname);
            cnt++;
        }

        if (sno != null) {
            sql.append("and student_t.sno = ?");
            list[4] = template.queryForList(sql.toString(), sno);
            cnt++;
        }

        Map<student_t, Integer> map = new HashMap<>();
        List<student_t> res = new LinkedList<>();

        if (cnt != 0) {
            for (List i : list) {
                if (i != null) {
                    for (Object j : i) {
                        Map<String, Object> k = (Map<String, Object>)j;
                        student_t temp = new student_t();
                        temp.setClassName(k.get("classname").toString());
                        temp.setSname(k.get("sname").toString());
                        temp.setSno(k.get("sno").toString());
                        if (map.containsKey(temp)) {
                            map.put(temp, map.get(temp) + 1);
                        } else {
                            map.put(temp, 1);
                        }
                    }
                }
            }
            for (student_t k : map.keySet()) {
                if (map.get(k) == cnt) res.add(k);
            }
        } else {
            List<Map<String, Object>> list_t = template.queryForList(sql.toString());
            for (Map<String, Object> i : list_t) {
                res.add(new student_t(i.get("Sno").toString(), i.get("Sname").toString(), i.get("classname").toString()));
            }
        }

        return res;
    }

}
