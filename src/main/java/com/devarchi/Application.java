package com.devarchi;

import com.devarchi.config.AppConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donghoon on 2016. 2. 17..
 */
public class Application {

    public static void main(String[] args) throws Exception {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CallRestWS cr = (CallRestWS) context.getBean("callRestWS");

        List<String> params = new ArrayList<String>();
        params.add("&numOfRows=1");
        params.add("&pageSize=1");
        params.add("&pageNo=1");
        params.add("&startPage=1");

        String returnVal = cr.restClient(params);
        System.out.println("        ");
        System.out.println("        ");
        System.out.println(returnVal);
    }
}
