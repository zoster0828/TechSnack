package test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DownloadService {
    ExecutorService es;
    List<Future> result;
    public DownloadService(int count) {
        es = Executors.newFixedThreadPool(count);
        result = new ArrayList<>();
    }

    public void download(int count) {
        for (int i = 0; i < count; i++) {
            Future<?> printResult = es.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        System.out.println("Print result");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            result.add(printResult);
        }
    }

    public void waitDownload() {
        for (int i = 0; i < result.size(); i++) {
            try {
                result.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
