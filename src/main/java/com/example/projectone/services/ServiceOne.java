package com.example.projectone.services;

import com.example.projectone.model.BkTimeLogModel;
import com.example.projectone.repositories.BkTimeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.example.projectone.Constants.*;

@Component
//@Scope("serviceone")

public class ServiceOne {

    @Autowired
    BkTimeLogRepository bkTimeLogRepository;

    public void saveBkTimeDataToDatabase(HashMap<String,String> keyValuePair){

        /**tod save*/
        BkTimeLogModel bkTimeLogModel = new BkTimeLogModel();

        String s = Long.toString(new Date().getTime());
        bkTimeLogModel.setId(s);
        bkTimeLogModel.setBk_time(keyValuePair.get(BK_TIME));
        bkTimeLogModel.setLineid(keyValuePair.get(LINEID));
        bkTimeLogModel.setPlantid(keyValuePair.get(PLANTID));
        bkTimeLogModel.setProdid(keyValuePair.get(PRODID));
        bkTimeLogModel.setReqst_type(keyValuePair.get(REQST_TYPE));
        bkTimeLogModel.setT1(keyValuePair.get(T1));
        bkTimeLogModel.setT2(keyValuePair.get(T2));
        bkTimeLogModel.setT3(keyValuePair.get(T3));
        bkTimeLogModel.setT4(keyValuePair.get(T4));
        bkTimeLogModel.setT5(keyValuePair.get(T5));
        bkTimeLogModel.setT6(keyValuePair.get(T6));

        //parameterHashMapArray.add(param1);
        //parameterHashMapArray
        //serviceOne.saveBkTimeDataToDatabase(bkTimeLogModel);
        bkTimeLogRepository.save(bkTimeLogModel);
        //bkTimeLogRepository.save(bkTimeLogModel);
    }

    public List<BkTimeLogModel> getbkData() {
        return bkTimeLogRepository.findAll();
    }

    public List<BkTimeLogModel> findByDateRange(String fromDateTimeStr,String toDateTimeStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        return bkTimeLogRepository.findByDateRange(format.parse(fromDateTimeStr),format.parse(toDateTimeStr));
    }


    /**
     * generate table dynamically. Only for Dev perpose.*/
    public   void createBkTable(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD, String TABLE_NAME) throws SQLException {

        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE "+TABLE_NAME+"("
                + "ID VARCHAR(45) NOT NULL, "
                + "REQST_TYPE VARCHAR(45) NOT NULL, "
                + "PLANTID VARCHAR(45) DEFAULT NULL, "
                + "LINEID VARCHAR(45) DEFAULT NULL, "
                + "PRODID VARCHAR(45) DEFAULT NULL, "
                + "BK_TIME VARCHAR(45) DEFAULT NULL, "
                + "T1 VARCHAR(45) DEFAULT NULL, "
                + "T2 VARCHAR(45) DEFAULT NULL, "
                + "T3 VARCHAR(45) DEFAULT NULL, "
                + "T4 VARCHAR(45) DEFAULT NULL, "
                + "T5 VARCHAR(45) DEFAULT NULL, "
                + "T6 VARCHAR(45) DEFAULT NULL, "
                + "PRIMARY KEY (ID) "
                + ")";
        /////////////
//        `ID` varchar(45) NOT NULL,
//        `REQST_TYPE` varchar(45) DEFAULT NULL,
//        `PLANTID` varchar(45) DEFAULT NULL,
//        `LINEID` varchar(45) DEFAULT NULL,
//        `PRODID` varchar(45) DEFAULT NULL,
//        `BK_TIME` varchar(45) DEFAULT NULL,
//        `T1` varchar(45) DEFAULT NULL,
//        `T2` varchar(45) DEFAULT NULL,
//        `T3` varchar(45) DEFAULT NULL,
//        `T4` varchar(45) DEFAULT NULL,
//        `T5` varchar(45) DEFAULT NULL,
//        `T6` varchar(45) DEFAULT NULL,
//        PRIMARY KEY (`ID`)
        /////////////

        try {
            dbConnection = getDBConnection( DB_DRIVER,  DB_CONNECTION,  DB_USER,  DB_PASSWORD);
            statement = dbConnection.createStatement();

            System.out.println(createTableSQL);
            // execute the SQL stetement
            statement.execute(createTableSQL);

            System.out.println("Table \"dbuser\" is created!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }

    private static Connection getDBConnection(String DB_DRIVER, String DB_CONNECTION, String DB_USER, String DB_PASSWORD) {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
