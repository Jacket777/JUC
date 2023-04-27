package com.msb.lab01;

import java.util.List;

public interface ExecutorService2 extends Executor2{

    
    void shutdown();
    List<Runnable> shutdownNow();

}
