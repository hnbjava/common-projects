package com.hnb.demo.logback;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hnbcao
 */
@Slf4j
public class LogbackLogger {
    public static void main(String[] args) {
        while (true) {
            System.out.println("write log");
            log.info("hello info");
            log.debug("hello debug");
            log.warn("hello warn");
            log.error("hello error");
            log.trace("hello trace");
        }
    }
}
