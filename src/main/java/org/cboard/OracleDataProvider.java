package org.cboard;

import org.cboard.dataprovider.DataProvider;
import org.cboard.dataprovider.annotation.ProviderName;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/15.
 */
@ProviderName(name = "Oracle")
public class OracleDataProvider extends DataProvider{

    static boolean flag;

    static double double1;

    static int a;

    @Override
    public String[][] getData(Map<String, String> dataSource, Map<String, String> query) throws Exception {
        return new String[0][];
    }

    @Override
    public int resultCount(Map<String, String> dataSource, Map<String, String> query) throws Exception {
        return 0;
    }

    public static void main(String... args) {
        System.out.println(flag + " " + a + " " + double1);
    }
}
