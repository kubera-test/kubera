package io.github.kuberatest.e2e.action.screenshot;

import com.codeborne.selenide.WebDriverRunner;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.TestCaseAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TakeScreenshot extends TestCaseAction implements Action {

    private String imageFilePath;
    private String imageFileName;

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Override
    public void execute() {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(200))
                .takeScreenshot(WebDriverRunner.getWebDriver());
        try {
            System.out.println(imageFileName);
            ImageIO.write(screenshot.getImage(), "PNG", new File(imageFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setTestCaseActionDataFromExcel(excelActionData);
        setImageFileName(excelActionData.getTestCase());
    }
}
