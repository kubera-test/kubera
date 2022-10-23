package io.github.kuberatest.e2e.action.screenshot;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.fullscreenshot.FullSizePhotographer;
import io.github.kuberatest.e2e.Kubera;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.TestCaseAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import org.openqa.selenium.OutputType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        if(Kubera.getProperties().isSuppressSaveScreenshot()) {
            System.out.println("画像の保存をスキップしました");

        } else {
            FullSizePhotographer photographer = new FullSizePhotographer();
            Path imagePath = Paths.get(imageFileName);
            try {
                Files.write(imagePath, photographer.takeScreenshot(WebDriverRunner.driver(), OutputType.BYTES).get());
            } catch (IOException e) {
                // TODO: 例外処理
                throw new RuntimeException(e);
            }
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
