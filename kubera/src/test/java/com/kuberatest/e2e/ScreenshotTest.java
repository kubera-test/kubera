package com.kuberatest.e2e;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotTest {
    @Test
    public void takeScreenshot() {
        Selenide.open("https://www.selenium.dev/ja/");
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(200))
                .takeScreenshot(WebDriverRunner.getWebDriver());
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File("C:\\tmp\\a.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Selenide.closeWebDriver();
        }
    }
}
