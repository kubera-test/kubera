package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ClilckDownloadTest extends ActionTest {
    @Test
    public void ダウンロードリンクをクリックしてファイルをダウンロードできること() throws IOException, InterruptedException {

        Path downloadPath = Path.of(kubera.getProperties().getDownloadDirectory(), "Download.json");
        System.out.println(downloadPath);
        if (Files.exists(downloadPath)) {
            Files.delete(downloadPath);
        }

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"clickLink\", "
                + "\"actionJson\": { \"locator\": \"link_text\", \"searchExpression\": \"ダウンロードリンク\" } }");
        Thread.sleep(4000);
        assertTrue(Files.exists(downloadPath));
    }
}
