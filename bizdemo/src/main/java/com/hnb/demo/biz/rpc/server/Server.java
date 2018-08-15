package com.hnb.demo.biz.rpc.server;

import java.io.IOException;

/**
 * @author xiaolu
 * @date 2018/8/14 上午10:57
 */
public interface Server {
    public void stop();

    public void start() throws IOException;

    public void register(Class service,Class impl);

    public boolean isRunning();

    public int getPort();
}
