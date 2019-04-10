package com.pavelkovachev.sportsinfo;

import java.util.concurrent.Executor;

public class AppExecutor implements Executor {

    private Executor executor;

    public AppExecutor(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(Runnable command) {
        executor.execute(command);
    }
}