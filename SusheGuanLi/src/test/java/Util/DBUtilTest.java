package Util;

import org.junit.Assert;
import org.junit.Test;
import util.DBUtil;

public class DBUtilTest {
    @Test
    public void test(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
