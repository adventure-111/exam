package cn.cuit.exam.service;

import cn.cuit.exam.dao.StudentDao;
import cn.cuit.exam.domain.PageBean;
import cn.cuit.exam.domain.Student;
import org.springframework.aop.target.LazyInitTargetSource;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public class StudentService {

    public PageBean<Student> queryStudent(String _currentPage, String _rows, String school, Map<String, String[]> condition) {
        int currentPage = 1;
        int rows = 10;
        if ( _currentPage != null && _currentPage != "" )  {
            currentPage = Integer.parseInt(_currentPage);
            if ( currentPage <= 0 ) currentPage = 1;
        }
        if ( _rows != null && _rows != "" ) {
            rows = Integer.parseInt(_rows);
            if ( rows <= 0 ) rows = 10;
        }

        // 1.创建空的PageBean对象
        PageBean<Student> pageBean = new PageBean<>();

        // 2.设置页面属性
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        // 4.查询记录总条数
        StudentDao dao = new StudentDao();
        int totalCount = dao.count(school, condition);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage();

        // 3.查询list集合
        int start = (currentPage - 1) * rows;
        List<Student> list = dao.query(start, rows, school, condition);
        pageBean.setList(list);

        // 4.返回pageBean对象
        return pageBean;
    }

    public void updateStudent(Map<String, String[]> condition) {
        StudentDao dao = new StudentDao();
        dao.update(condition);
    }
}
