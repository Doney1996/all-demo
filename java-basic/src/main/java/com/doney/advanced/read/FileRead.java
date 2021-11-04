package com.doney.advanced.read;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRead {

    public static void main(String[] args) throws Exception {
        Integer[] integers = new Integer[]{
                331100,331101,331102,331121,331122,331123,331124,331125,331126,331127,331181
        };

        String sql ="INSERT INTO `sjzs_sx_cs`.`hot_word`( `djsj`, `word`, `count`, `xmqxdm`) VALUES ( ?, ?, ?, ?);\n";
        String date ="2020-11-01";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        List<String> list = getStringList("C:\\Users\\86185\\Desktop\\1.txt");
        list.stream().parallel().forEach(one->{
            String[] split = one.split(",");
            Assert.isTrue(split.length == 22,"长度错误"+Arrays.toString(split));
            for (int i = 0; i <split.length; i=i+2) {
                Integer areaCode = integers[i/2];
                String word = split[i];
                String count = split[i+1];
                if (org.apache.commons.lang3.StringUtils.isBlank(count)) {
                    count="0";
                }
                if (org.apache.commons.lang3.StringUtils.isBlank(word)) {
                    word="null";
                }
                Assert.isTrue(Integer.parseInt(count) > -100,"次数错误"+count +"======" + Arrays.toString(split));
                Assert.isTrue(!StringUtils.isEmpty(word),"热词不能为空 "+word +"======"+ Arrays.toString(split));
                jdbcTemplate.update(sql,date,word,count,areaCode);
            }
        });
    }

    private static List<String> getStringList(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            list.add(tempStr);
        }
        reader.close();
        return list;
    }

    public static DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://59.202.48.65:3314/sjzs_sx_cs?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=false");
        config.setUsername("sjzssx_cs");
        config.setPassword("sjzssx_cs");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);

        return ds;
    }

}
