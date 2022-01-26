package net.airene.questionnaire.common.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorUtils {

    private static Executor executor = Executors.newCachedThreadPool();

    public static void async(Runnable runnable){
        executor.execute(runnable);
    }
}
