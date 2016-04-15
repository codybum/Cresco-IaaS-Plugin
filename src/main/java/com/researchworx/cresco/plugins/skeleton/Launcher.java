package com.researchworx.cresco.plugins.skeleton;

import com.researchworx.cresco.library.plugin.core.CPlugin;

public class Launcher extends CPlugin {
    public void setExecutor() {
        setExec(new Executor(this));
    }

    public void start() {
        System.out.println("Executing Skeleton Plugin");
    }

    @Override
    public void cleanUp() {

    }
}
