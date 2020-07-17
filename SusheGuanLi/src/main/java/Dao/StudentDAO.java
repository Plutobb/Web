package Dao;

import model.Student;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDAO {

    public static List<Student> query() {
        List<Student> list = new ArrayList<>();
        Connection c =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select s.id," +
                    "       s.student_name," +
                    "       s.student_graduate_year," +
                    "       s.student_major," +
                    "       s.student_email," +
                    "       s.dorm_id," +
                    "       s.create_time," +
                    "       d.dorm_no," +
                    "       b.id building_id," +
                    "       b.building_name" +
                    "   from student s" +
                    "         join dorm d on s.dorm_id = d.id" +
                    "         join building b on d.building_id = b.id";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentGraduateYear(rs.getString("student_graduate_year"));
                student.setStudentMajor(rs.getString("student_major"));
                student.setStudentEmail(rs.getString("student_email"));
                student.setDormId(rs.getInt("dorm_id"));
                student.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                student.setDormNo(rs.getString("dorm_no"));
                student.setBuildingId(rs.getString("building_id"));
                student.setBuildingName(rs.getString("building_name"));
                list.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询学生列表出错",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
        return list;
    }

    public static Student queryById(int id) {
        Student student = new Student();
        Connection c =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select s.id," +
                    "       s.student_name," +
                    "       s.student_graduate_year," +
                    "       s.student_major," +
                    "       s.student_email," +
                    "       s.dorm_id," +
                    "       s.create_time," +
                    "       d.dorm_no," +
                    "       b.id building_id," +
                    "       b.building_name" +
                    "   from student s" +
                    "         join dorm d on s.dorm_id = d.id" +
                    "         join building b on d.building_id = b.id"+
                    " where s.id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                student.setId(rs.getInt("id"));
                student.setStudentName(rs.getString("student_name"));
                student.setStudentGraduateYear(rs.getString("student_graduate_year"));
                student.setStudentMajor(rs.getString("student_major"));
                student.setStudentEmail(rs.getString("student_email"));
                student.setDormId(rs.getInt("dorm_id"));
                student.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                student.setDormNo(rs.getString("dorm_no"));
                student.setBuildingId(rs.getString("building_id"));
                student.setBuildingName(rs.getString("building_name"));
            }
        } catch (Exception e) {
            throw new RuntimeException("查询学生详情出错",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
        return student;
    }
}
