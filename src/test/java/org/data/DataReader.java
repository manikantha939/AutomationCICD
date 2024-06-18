package org.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DataReader {
    public void getJsonData() throws IOException {
        //read json to String
        String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//org//data//PurchaseOrder.json"));
        //String tpo HashMap Jackson Databind
        ObjectMapper objectMapper=new ObjectMapper();
    }
}
