package dao;

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

    public static int insert(Student s) {
        Connection c =null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "insert into student(student_name,student_graduate_year,student_major,student_email,dorm_id) values(?,?,?,?,?)";
            ps = c.prepareStatement(sql);
            ps.setString(1,s.getStudentName());
            ps.setString(2,s.getStudentGraduateYear());
            ps.setString(3,s.getStudentMajor());
            ps.setString(4,s.getStudentEmail());
            ps.setInt(5,s.getDormId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("插入学生信息出错",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }

    public static int update(Student s) {
        Connection c =null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            String sql = "update student set student_name=?,student_graduate_year=?,student_major=?,student_email=?,dorm_id=? where id=?";
            ps = c.prepareStatement(sql);
            ps.setString(1,s.getStudentName());
            ps.setString(2,s.getStudentGraduateYear());
            ps.setString(3,s.getStudentMajor());
            ps.setString(4,s.getStudentEmail());
            ps.setInt(5,s.getDormId());
            ps.setInt(6,s.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("修改学生信息出错",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }

    public static int delete(String[] ids) {
        Connection c =null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            StringBuilder sql =new StringBuilder("delete from student where id in (") ;
            for (int i = 0; i < ids.length; i++) {
                if (i != 0)
                    sql.append(",");
                sql.append("?");
            }
            sql.append(")");
            ps = c.prepareStatement(sql.toString());
            for (int i = 0; i < ids.length; i++) {
                ps.setInt(i+1,Integer.parseInt(ids[i]));
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("删除学生信息出错",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }

    public static int apply(Student s) {
        List<Integer> ids = s.getIds();
        Connection c =null;
        PreparedStatement ps = null;
        try {
            c = DBUtil.getConnection();
            StringBuilder sql =new StringBuilder("update student set dorm_id=? where id in (");
            for (int i = 0; i < ids.size(); i++) {
                if (i != 0)
                    sql.append(",");
                sql.append("?");
            }
            sql.append(")");
            ps = c.prepareStatement(sql.toString());
            ps.setInt(1,s.getDormId());
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(i+2,ids.get(i));
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("分配学生宿舍出错",e);
        } finally {
            DBUtil.Close(c,ps);
        }
    }
}
