package Dao;

import model.Dictionary;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DictionTagDao {

    public static List<Dictionary> query(String key) {
        List<Dictionary> list = new ArrayList<>();
        Connection c =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = DBUtil.getConnection();
            String sql = "select concat(d.dictionary_key, dt.dictionary_tag_key) dictionary_tag_key," +
                    "       dt.dictionary_tag_value" +
                    "   from dictionary d" +
                    "         join dictionary_tag dt on d.id = dt.dictionary_id" +
                    "   where d.dictionary_key = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1,key);
            rs = ps.executeQuery();
            while (rs.next()){
                Dictionary tag = new Dictionary();
                tag.setDictionaryKey(rs.getString("dictionary_tag_key"));
                tag.setDictionaryValue(rs.getString("dictionary_tag_value"));
                list.add(tag);
            }
        } catch (Exception e) {
            throw new RuntimeException("查询数据字典标签出错!",e);
        } finally {
            DBUtil.Close(c,ps,rs);
        }
        return list;
    }
}
