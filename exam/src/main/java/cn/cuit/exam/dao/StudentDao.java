package cn.cuit.exam.dao;

import cn.cuit.exam.domain.Student;
import cn.cuit.exam.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class StudentDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());

    /**
     * 添加学生
     * @param stu
     * @return
     */
    public boolean addStudent(Student stu) {
        Boolean success = true;
        String getSchoolSql = "select school from major_t where major = ? ";
        String school = template.queryForObject(getSchoolSql, String.class, stu.getMajor());

        try {
            try {
                // 判断表中是否有这个班，没有则添加
                String queryClassSql = "select classname from class_t where classname = ?";
                String classname = template.queryForObject(queryClassSql, String.class, stu.getClassName());
            } catch (EmptyResultDataAccessException e) {
                //e.printStackTrace();
                // 查询结果为空
                String addClassSql = "insert into class_t(className, major, school, grade, classnum) values(?, ?, ?, ?, 0)";
                template.update(addClassSql, stu.getClassName(), stu.getMajor(), school, stu.getGrade());
            }
            // 更新student，user，class表
            String addStuSql = "insert into student_t(sno, sname, classname) values(?, ?, ?)";
            template.update(addStuSql, stu.getUsername(), stu.getSname(), stu.getClassName());

            String addUserSql = "insert into user_t values(?, ?, ?)";
            template.update(addUserSql, stu.getUsername(), stu.getPassword(), "S");

            String updateClassSql = "update class_t set classNum = classNum+1 where classname = ? ";
            template.update(updateClassSql, stu.getClassName());

        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }

    /**
     * 删除学生
     * @param sno
     * @return
     */
    public boolean delete(String sno) {
        boolean success = true;

        //更新class表中的classnum字段
        String upgateClassSql = "update class_t set classnum = classnum - 1 where classname = " +
                "(select classname from student_t where sno = ?)";
        template.update(upgateClassSql, sno);
        //删除该学生
        String delStuSql = "delete from student_t where sno = ?";
        int del1 = template.update(delStuSql, sno);
        //删除该用户
        String delUserSql = "delete from user_t where username = ?";
        int del2 = template.update(delUserSql, sno);

        if ( del1 != 1 ) {
            System.out.println("student表中不存在该学生：" + sno);
            success = false;
        }
        if ( del2 != 1 ) {
            System.out.println("user表中不存在该用户：" + sno);
            success = false;
        }

        return success;
    }

    /**
     * 批量删除学生
     * @param snoList
     * @return
     */
    public boolean delete(List<String> snoList) {
        boolean success = true;
        List<String> errorSnoList = new ArrayList<>();

        for ( String sno : snoList) {
            try {
                //更新class表中的classnum字段
                String upgateClassSql = "update class_t set classnum = classnum - 1 where classname = " +
                        "(select classname from student_t where sno = ?)";
                template.update(upgateClassSql, sno);
                //删除该学生
                String delStuSql = "delete from student_t where sno = ?";
                template.update(delStuSql, sno);
                //删除该用户
                String delUserSql = "delete from user_t where username = ?";
                template.update(delUserSql, sno);
            } catch (DataAccessException e) {
                //e.printStackTrace();
                success = false;
                errorSnoList.add("sno");
            }
        }

        System.out.println("errorSnoList: " + errorSnoList);

        return success;
    }

    //修改信息
    public void update(Map<String, String[]> condition) {
        System.out.println(condition.toString());
        String sno = condition.get("username")[0];
        String sname = condition.get("sname")[0];
        String password = condition.get("password")[0];
        String classname = condition.get("classname")[0];
        String major = condition.get("major")[0];
        String school = condition.get("school")[0];
        System.out.println(school);
        System.out.println(classname);

        String sql1 = "update user_t set password = ? where username = ? ";
        template.update(sql1, password, sno);

        String sql2 = "update student_t set sname = ? where sno = ?";
        template.update(sql2, sname, sno);

        String sql3 = "select classname from student_t where sno = ?";
        String cname = template.queryForObject(sql3, String.class, sno);

        if ( !cname.equals(classname) ) {
            // 原班级中 classnum - 1
            String sql4 = "update class_t set classnum = classnum - 1 where classname = ? ";
            template.update(sql4, cname);
            // 新班级中的 classnum + 1
            String sql5 = "update class_t set classnum = classnum + 1 where classname = ? ";
            int res = template.update(sql5, classname);
            if ( res == 0 ) {
                String sql6 = "insert into class_t(className, major, school, grade, classnum) values(?, ?, ?, ?, 1)";
                template.update(sql6, classname, major, school, Student.getGrade(classname));                }
            // 学生表 classname 更新
            String sql7 = "update student_t set classname = ? where sno = ?";
            template.update(sql7, classname, sno);
        }
    }


    //查询信息
    // 通过学号
    public Student queryBySno(String school, String sno) {
        Student stu = null;
        try {
            String sql = "select * from student_t s, user_t, class_t c where sno = username " +
                    "and s.classname = c.classname and school = ? " +
                    "and sno = ?";

            stu = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), school, sno);
        } catch (DataAccessException e) {
            // e.printStackTrace();
        }

        return stu;
    }

    // 条件查询
    public List<Student> query(int start, int rows, String school, Map<String, String[]> condition) {
        StringBuilder sql = new StringBuilder("select * from student_t s, user_t u, class_t c " +
                "where sno = username and s.classname = c.classname " +
                "and school = ? ");
        // 遍历map 定义参数集合
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        params.add(school);
        for ( String key : keySet ) {
            // 排除分页条件参数
            if ( "currentPage".equals(key) || "rows".equals(key) ) continue;

            // 获取value
            String value = condition.get(key)[0];
            // 判断value是否有值
            if ( value != null && !"".equals(value) ) {
                if ( "className".equals(key) )
                    sql.append( " and c.classname like ? ");
                else
                    sql.append(" and " +key+ " like ? ");
                params.add("%"+value+"%");
            }
        }

        sql.append(" order by sno limit ? , ? ");
        params.add(start);
        params.add(rows);

        List<Student> stuList = template.query(sql.toString(), new BeanPropertyRowMapper<Student>(Student.class), params.toArray());

        return stuList;
    }

    // 获取查询记录总数
    public int count(String school, Map<String, String[]> condition) {
        StringBuilder sql = new StringBuilder("select count(*) from student_t s, user_t u, class_t c " +
                "where sno = username and s.classname = c.classname " +
                "and  school = ? ");
        // 遍历map 定义参数集合
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        params.add(school);
        for ( String key : keySet ) {
            // 排除分页条件参数
            if ( "currentPage".equals(key) || "rows".equals(key) ) continue;
            // 获取value
            String value = condition.get(key)[0];
            // 判断value是否有值
            if ( value != null && !"".equals(value) ) {
                if ( key.equals("className") ) {
                    sql.append(" and c.classname like ? ");
                }
                else {
                    sql.append(" and " +key+ " like ? ");
                }
                params.add("%"+value+"%");
            }
        }

        int count = template.queryForObject(sql.toString(), Integer.class, params.toArray());

        return count;
    }

    // 查询学院所有年级
    public List<String> getGrades(String school) {
        String sql = "select distinct grade from class_t c where school = '"+school+"'";
        List<String> grades = template.queryForList(sql, String.class);
        return grades;
    }
}
