package test.thread;

public class ThreadTest {
    public static void main(String[] args) {
        DownloadService downloadService = new DownloadService(10);
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 3; i++) {
                downloadService.download(5);
            }
            System.out.println("complete : "+j);
        }
        downloadService.waitDownload();

        System.exit(0);
    }
}
