package com.devarchi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donghoon on 2016. 2. 17..
 */
public class Application {

    private static CallRestWS cr;

    public static void main(String[] args) throws Exception {

        List<String> params = new ArrayList<String>();
        params.add("&numOfRows=1");
        params.add("&pageSize=1");
        params.add("&pageNo=1");
        params.add("&startPage=1");

        String returnVal = cr.restClient(params);
        System.out.println(returnVal);
    }
}
