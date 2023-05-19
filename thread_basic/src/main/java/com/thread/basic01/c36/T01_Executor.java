package com.thread.basic01.c36;

import java.util.concurrent.Callable;

public class T01_Executor {

    public static void main(String[] args) {
           // 1.定义执行器
           MyExecutor executor = new MyExecutor();
           //2. 定义子任务
           Callable<Integer>subTask = new Callable<Integer>() {
               @Override
               public Integer call() throws Exception {
                   int millis = (int)(Math.random()*1000);
                   Thread.sleep(millis);
                   Thread.sleep(10000);
                   return  millis;
               }
           };


           //异步调用，返回一个MyFuture对象
        MyFuture<Integer>future = executor.execute(subTask);
        try{
            Integer result = future.get();
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
