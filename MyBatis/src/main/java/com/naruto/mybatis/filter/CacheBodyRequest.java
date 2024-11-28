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
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存body参数的请求对象，即可重复调用request.getInputStream()，解决流只能读取一次的问题。
 * @author Naruto
 */
public class CacheBodyRequest extends HttpServletRequestWrapper {

    private final byte[] requestBody;
    private final Map<String, String[]> parameterMap;

    public CacheBodyRequest(HttpServletRequest request) throws IOException {
        super(request);
        // 直接使用原始请求的参数映射
        this.parameterMap = new HashMap<>(request.getParameterMap());
        // 缓存请求体
        this.requestBody = IoUtil.readBytes(request.getInputStream(), false);

    }

    @Override
    public String getParameter(String name) {
        String[] values = parameterMap.get(name);
        return (values == null || values.length == 0) ? null : values[0];
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return Collections.unmodifiableMap(parameterMap);
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameterMap.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return parameterMap.get(name);
    }

    @Override
    public ServletInputStream getInputStream() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);
        return new DelegatingServletInputStream(byteArrayInputStream);
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    public void addParameter(String name, String value) {
        String[] existingValues = parameterMap.get(name);
        if (existingValues == null) {
            parameterMap.put(name, new String[]{value});
        } else {
            String[] newValues = new String[existingValues.length + 1];
            System.arraycopy(existingValues, 0, newValues, 0, existingValues.length);
            newValues[existingValues.length] = value;
            parameterMap.put(name, newValues);
        }
    }

    public void replaceParameter(String name, String value) {
        parameterMap.put(name, new String[]{value});
    }

    private static class DelegatingServletInputStream extends ServletInputStream {
        private final ByteArrayInputStream inputStream;

        public DelegatingServletInputStream(ByteArrayInputStream inputStream) {
            this.inputStream = inputStream;
        }

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
            throw new UnsupportedOperationException("Async I/O not supported");
        }

        @Override
        public int read() throws IOException {
            return inputStream.read();
        }
    }
}