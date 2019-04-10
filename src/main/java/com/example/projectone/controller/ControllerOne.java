package com.example.projectone.controller;

import com.example.projectone.model.BkTimeLogModel;
import com.example.projectone.services.ServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.projectone.Constants.*;

@RestController
@RequestMapping("bkdata")
@CrossOrigin(origins = "*")
public class ControllerOne {

    @Autowired
    ServiceOne serviceOne;

//    @Autowired
//    IBkTimeRepository iBkTimeRepository;

    @RequestMapping(method = RequestMethod.GET,value="/save")
    public String get(
            @RequestParam(value="RQSTTYPE", required=true) String reqstype,
            @RequestParam(value="PRODID", required=true) String prodid,
            @RequestParam(value="LINEID", required=true) String lineid,
            @RequestParam(value="PLANTID", required=true) String plantid,
            @RequestParam(value="BAKETIME", required=true) String baketime,
            @RequestParam(value="T1", required=true) String t1,
            @RequestParam(value="T2", required=true) String t2,
            @RequestParam(value="T3", required=true) String t3,
            @RequestParam(value="T4", required=true) String t4,
            @RequestParam(value="T5", required=true) String t5,
            @RequestParam(value="T6", required=true) String t6
    )
         {
             //ArrayList<HashMap> parameterHashMapArray = new ArrayList<>();
             HashMap<String,String> keyValuePair = new HashMap<>();
             keyValuePair.put(BK_TIME,baketime);
             keyValuePair.put(LINEID,lineid);
             keyValuePair.put(PLANTID,plantid );
             keyValuePair.put(PRODID,prodid );
             keyValuePair.put(REQST_TYPE,reqstype);
             keyValuePair.put(T1,t1);
             keyValuePair.put(T2,t2);
             keyValuePair.put(T3,t3);
             keyValuePair.put(T4,t4);
             keyValuePair.put(T5,t5);
             keyValuePair.put(T6,t6);
             serviceOne.saveBkTimeDataToDatabase(keyValuePair);

             return "Status : true";
         }

    @RequestMapping(method = RequestMethod.GET,value="/go")
    public void get(){
        String s = "s";
        s = s+"g";
        s= s+"d";
    }

    @RequestMapping(method = RequestMethod.GET,value="/getdata")
    public List<BkTimeLogModel> getbkdata(){
        return serviceOne.getbkData();
    }

    @RequestMapping(method = RequestMethod.GET,value="/createtablebkdata")
    public String  createBkTable() throws SQLException {
        String DB_DRIVER = "com.mysql.jdbc.Driver";
        String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:MKYONG";String DB_USER = "user";
        String DB_PASSWORD = "password";
        String TABLE_NAME = "bk_time_log";
        serviceOne.createBkTable(DB_DRIVER,DB_CONNECTION,DB_USER,DB_PASSWORD,TABLE_NAME);
        return "Status : true";
    }

    @RequestMapping(method = RequestMethod.GET,value="/connectiontest")
    public String  connectiontest(){
        return "connection working";
    }
}
