package Dao;

import model.DictionaryTag;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DormDao {

    public static List<DictionaryTag> query(int id) {
        List<DictionaryTag> list = new ArrayList<>();
        Connection c =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select d.id," +
                    "       d.dorm_no" +
                    " from building b" +
                    "         join dorm d on b.id = d.building_id" +
                    " where b.id = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                DictionaryTag tag = new DictionaryTag();
                tag.setDictionaryTagKey(rs.getString("id"));
                tag.setDictionaryTagValue(rs.getString("dorm_no"));
                list.add(tag);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询寝室数据字典标签出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
        return list;
    }
}
