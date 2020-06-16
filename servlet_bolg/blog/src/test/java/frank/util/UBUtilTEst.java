package frank.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class UBUtilTEst {
    @Test
    public void t1() throws SQLException {
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
