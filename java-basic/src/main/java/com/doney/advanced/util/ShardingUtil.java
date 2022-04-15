package com.doney.advanced.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShardingUtil {
    public static void main(String[] args) throws IOException {
        String path = "/Users/fin-10497/Desktop/databus_house_keeping/";
        Map<String, List<String>> sqlMap = new HashMap<>();
        sqlMap.put("bus_flood_data_idx_",new ArrayList<>());
        sqlMap.put("bus_flood_data_dlq_idx_",new ArrayList<>());
        sqlMap.put("bus_flood_data_storage_",new ArrayList<>());
        File file = new File(path);
        if (!file.exists()) {
            boolean mkdir = file.mkdir();
        }
        int dbEcsIndex = 0;
        String EcsName = "fcdatabus-";

        int index = 0;
        int stepSize = 200;
        int dbSize= 10;
        int dbIndex= 0;
        String db ="fcdatabus";

        String sql = "truncate table ";

        for (int j = 0; j < 5; j++) {

            sqlMap.forEach((k,v)->{
                v.clear();
            });

            String dbEcsName = EcsName + String.format("%02d", j);
            //加上步长
            for (int i = 0; i < stepSize; i++) {
                int finalI = i + index;
                if (i % dbSize == 0) {
                    dbIndex++;
                }
                int finalDbIndex = dbIndex -1;
                sqlMap.forEach((key, list)->{
                    String tableName = key+ String.format("%04d", finalI) + "_t";
                    String dbName = db+String.format("%02d", finalDbIndex);
                    String resultSql = sql+ dbName +"." + tableName + ";";
                    list.add(resultSql);
                });
            }
            File f = new File(path + dbEcsName + ".sql");
            if (!f.exists()) {
                boolean newFile = f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            //保存到sql文件
            sqlMap.forEach((k,v)->{
                v.forEach(e->{
                    try {
                        fos.write((e+"\n").getBytes(StandardCharsets.UTF_8));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
                try {
                    fos.write("\n".getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fos.close();

            index  = index + stepSize;
        }


    }

}
