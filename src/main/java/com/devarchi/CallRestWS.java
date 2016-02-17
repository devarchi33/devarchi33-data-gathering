package com.devarchi;

import lombok.Data;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by donghoon on 2016. 2. 17..
 */
@Data
public class CallRestWS {

    private String endPoint;
    private String serviceKey;

    public CallRestWS(String endPoint, String serviceKey) {
        this.endPoint = endPoint;
        this.serviceKey = serviceKey;
    }

    public String restClient(List<String> params) throws Exception {
        StringBuilder parameter = new StringBuilder();
        String addr = endPoint + "?ServiceKey=";

        for (int i = 0; i < params.size(); i++) {
            parameter.append(params.get(i));
        }

        addr = addr + serviceKey + parameter.toString();

        System.out.println("Addr: " + addr);
        URL url = new URL(addr);
        InputStream in = url.openStream();
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        return bos.getOut().toString();
    }
}
