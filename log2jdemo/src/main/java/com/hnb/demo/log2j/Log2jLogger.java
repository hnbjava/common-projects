package com.hnb.demo.log2j;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hnbcao
 */
@Slf4j
public class Log2jLogger {
    public static void main(String[] args) {
        log.info("hello info");
        log.debug("hello debug");
        log.warn("hello warn");
        log.error("hello error");
        log.trace("hello trace");
    }
}
