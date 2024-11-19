package com.naruto.mybatis.filter;

import cn.hutool.core.io.IoUtil;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 缓存body参数的请求对象，即可重复调用request.getInputStream()，解决流只能读取一次的问题。
 * @author Naruto
 */
public class CacheBodyRequest extends HttpServletRequestWrapper {

    //请求体
    private final byte[] requestBody;

    public CacheBodyRequest(HttpServletRequest request) throws IOException {
        super(request);
        this.requestBody = IoUtil.readBytes(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(requestBody);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return inputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }

            @Override
            public int read() {
                return inputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}