package main.java.concurrency;

public class ThreadRunner {
    private Thread flow;
    private Runnable runnable;

    public ThreadRunner(Runnable runnable) {
        this.runnable = runnable;
    }

    public ThreadRunner(Thread flow) {
        this.flow = flow;
    }

    public ThreadRunner() {
    }

    public void openTread() {
        flow = new Thread(runnable);
        flow.start();
    }

    public void openTread(Runnable runnable) {
        flow = new Thread(runnable);
        flow.start();
    }

    public void closeThread(Runnable runnable) {
        flow.interrupt();
    }

    public Thread.State getThreadStatus() {
        return flow.getState();
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public Thread getFlow() {
        return flow;
    }
}
