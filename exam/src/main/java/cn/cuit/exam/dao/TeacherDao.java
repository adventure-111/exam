package cn.cuit.exam.dao;

import cn.cuit.exam.domain.Student;
import cn.cuit.exam.domain.Teacher;
import cn.cuit.exam.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());

    /**
     * 添加教师
     * @param t
     * @return
     */
    public boolean add(Teacher t) {
        boolean success = true;

        try {
            // 更新teacher，user表
            String addTeaSql = "insert into teacher_t(tno, tname, school, past, task) values(?, ?, ?, 0, 'F')";
            template.update(addTeaSql, t.getUsername(), t.getTname(), t.getSchool());

            String addUserSql = "insert into user_t values(?, ?, ?)";
            template.update(addUserSql, t.getUsername(), t.getPassword(), "T");
        } catch (Exception e) {
            e.printStackTrace();
            delete("tno");
            success = false;
        }

        return success;
    }

    /**
     * 删除教师
     * @param tno
     * @return
     */
    public boolean delete(String tno) {
        boolean success = true;


        //删除该教师
        String delTeaSql = "delete from teacher_t where tno = ?";
        int del1 = template.update(delTeaSql, tno);
        //删除该用户
        String delUserSql = "delete from user_t where username = ?";
        int del2 = template.update(delUserSql, tno);

        if ( del1 != 1 ) {
            System.out.println("teacher表中不存在该教师：" + tno);
            success = false;
        }
        if ( del2 != 1 ) {
            System.out.println("user表中不存在该用户：" + tno);
            success = false;
        }

        return success;
    }

    /**
     * 批量删除学生
     * @param tnoList
     * @return
     */
    public boolean deleteList(List<String> tnoList) {
        boolean success = true;
        List<String> errorTnoList = new ArrayList<>();

        for ( String tno : tnoList) {
            //删除该教师
            String delTeaSql = "delete from teacher_t where tno = ?";
            int del1 = template.update(delTeaSql, tno);
            //删除该用户
            String delUserSql = "delete from user_t where username = ?";
            int del2 = template.update(delUserSql, tno);

            if ( del1 != 1 ) System.out.println("teacher表中不存在该教师：" + tno);

            if ( del2 != 1 ) System.out.println("user表中不存在该用户：" + tno);

            if ( del1 != 1 || del2 != 1 ) {
                success = false;
                errorTnoList.add(tno);
            }
        }

        if ( !success )System.out.println("errorSnoList: " + errorTnoList);

        return success;
    }

    // 修改信息
    public void update(String tno, String tname, String password) {
        String sql1 = "update user_t set password = ? where username = ? ";
        template.update(sql1, password, tno);

        String sql2 = "update teacher_t set tname = ? where tno = ?";
        template.update(sql2, tname, tno);
    }


    //查询信息
    // 全部
    public List<Teacher> queryAll(String school) {
        String sql = "select * from teacher_t, user_t where tno = username and school = ? ";
        List<Teacher> teaList = template.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), school);

        return teaList;
    }


    // 通过工号
    public Teacher queryBySno(String school, String tno) {
        Teacher t = null;
        try {
            String sql = "select * from teacher_t, user_t where username = tno and tno = ? and school = ?";

            t = template.queryForObject(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class), tno, school);
        } catch (DataAccessException e) {
            // e.printStackTrace();
        }

        return t;
    }

    // 条件查询
    public List<Teacher> query(String school, String tname, String tno) {
        StringBuilder sql = new StringBuilder("select * from teacher_t, user_t" +
                " where tno = username and school = ? ");
        if ( tname != null ) sql.append(" and tname = '" + tname + "'");
        if ( tno != null ) sql.append(" and tno = '" + tno + "'");

        List<Teacher> teaList = template.query(sql.toString(), new BeanPropertyRowMapper<Teacher>(Teacher.class), school);

        return teaList;
    }
}
