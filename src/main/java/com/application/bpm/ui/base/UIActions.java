package com.application.bpm.ui.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UIActions extends DBUtils {

    public static WebDriver driver;
    public static String parentWindowName;

    public static void openChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void closeChromeBrowser() {
        driver.quit();
    }

    public static void openURL(String url) {
        driver.get(url);
    }

    /* Method enterText: To enter any text into input type text field
     * @param locator  : By : Locator of the text field
     * @param inputText: String : Text that you want to enter
     */
    public static void enterText(By locator, String inputText) {
        if (waitForElementIsVisible(locator)) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(inputText);
        } else
            Assert.fail("\n Enter text into locator : " + locator + " ************* Failed");
    }


    /* Method enterTextCharByChar: To enter any text into input type text field character by character
     * @param locator  : By : Locator of the text field
     * @param inputText: String : Text that you want to enter
     */
    public static void enterTextCharByChar(By locator, String inputText) {
        if (waitForElementIsVisible(locator)) {
            char[] convertedCharArray = inputText.toCharArray();
            driver.findElement(locator).clear();
            for (int iCount = 0; iCount < convertedCharArray.length; iCount++) {
                driver.findElement(locator).sendKeys(String.valueOf(convertedCharArray[iCount]));
            }
        } else
            Assert.fail("\n Enter text char by char into locator : " + locator + " ************* Failed");
    }

    /* Method enterTextAndPressEnterKey: To enter any text into input type text field and press <Enter> key
     * @param locator  : By : Locator of the text field
     * @param inputText: String : Text that you want to enter
     */
    public static void enterTextAndPressEnterKey(By locator, String inputText) {
        Actions action = new Actions(driver);
        if (waitForElementIsVisible(locator)) {
            driver.findElement(locator).sendKeys(inputText);
            action.sendKeys(Keys.ENTER).build().perform();
        } else
            Assert.fail("\n Enter text and press <Enter> Key with locator : : " + locator + " ************* Failed");
    }

    /* Method clickOnElement: To click on button or option or menu
     * @param locator  : By : Locator of the element that you want to click
     */
    public static void clickOnElement(By locator) {
        if (driver.findElement(locator).isDisplayed())
            driver.findElement(locator).click();
        else
            Assert.fail("\n Click on element with locator : " + locator + " ************* Failed");
    }

    /* Method doubleClickOnElement: To double click on button or option or menu
     * @param locator  : By : Locator of the element that you want to click
     */
    public static void doubleClickOnElement(By locator) {
        Actions action = new Actions(driver);
        if (driver.findElement(locator).isDisplayed())
            action.doubleClick(driver.findElement(locator)).build().perform();
        else
            Assert.fail("\n Double click on element with locator : " + locator + " ************* Failed");
    }

    /* Method contextClick: Focus and right click on element
     * @param locator  : By : Locator of the element that you want to double click
     */
    public static void contextClick(By locator) {
        Actions action = new Actions(driver);
        if (waitForElementIsVisible(locator))
            action.contextClick(driver.findElement(locator)).build().perform();
        else
            Assert.fail("\n Context click on element with locator : " + locator + " ************* Not Found");
    }

    /* Method waitAndDoubleClickOnElement: To wait for the element before double click
     * @param locator  : By : Locator of the element that you want to double click
     * @param waitTimeInSeconds  : integer : wait time in second
     */
    public static void waitAndDoubleClickOnElement(By locator) {
        Actions action = new Actions(driver);
        if (waitForElementIsClickable(locator))
            action.doubleClick(driver.findElement(locator)).build().perform();
        else
            Assert.fail("\n Double click on element with locator : " + locator + " ************* Failed");
    }

    /* Method selectOrUnselectCheckBox: To select and unselect the check box
     * @param locator  : By : Locator of the check box that you want to select or unselect
     */
    public static void selectOrUnselectCheckBox(By locator) {
        if (driver.findElement((locator)).isDisplayed())
            driver.findElement(locator).click();
        else
            Assert.fail("\n Select on check box with locator : " + locator + " ************* Failed");
    }

    /* Method selectRadioButton: To select radio button
     * @param locator  : By : Locator of the radio button that you want to select
     */
    public static void selectRadioButton(By locator) {
        if (driver.findElement(locator).isDisplayed())
            driver.findElement(locator).click();
        else
            Assert.fail("\n Select radio button with locator : " + locator + " ************* Failed");
    }

    /* Method selectDropDownByValue: To select the dropdown value
     * @param dropdownLocator  : By : Locator of the dropdown
     * @param value  : String :Value that you want to select from the dropdown
     */
    public static void selectDropDownByValue(By dropdownLocator, String value) {
        try {
            Select select = new Select(driver.findElement(dropdownLocator));
            select.selectByValue(value);
        } catch (Exception e) {
            Assert.fail("\n Unable to select value :" + value + " from dropdown :" + dropdownLocator);
        }
    }

    /* Method selectDropDownByText: To select the dropdown value
     * @param dropdownLocator  : By : Locator of the dropdown
     * @param text  : String :Text that you want to select from the dropdown
     */
    public static void selectDropDownByText(By dropdownLocator, String text) {
        try {
            Select select = new Select(driver.findElement(dropdownLocator));
            select.selectByVisibleText(text);
        } catch (Exception e) {
            Assert.fail("\n Unable to select text :" + text + " from dropdown :" + dropdownLocator);
        }
    }

    /* Method selectDropDownByIndex: To select the dropdown value
     * @param dropdownLocator  : By : Locator of the dropdown
     * @param index  : String :Index that you want to select from the dropdown
     */
    public static void selectDropDownByIndex(By dropdownLocator, int index) {
        try {
            Select select = new Select(driver.findElement(dropdownLocator));
            select.deselectByIndex(index);
        } catch (Exception e) {
            Assert.fail("\n Unable to select index :" + index + " from dropdown :" + dropdownLocator);
        }
    }

    /* Method getSelectedDropdownValue: To get selected value from dropdown
     * @param locator  : By : Locator of the dropdown
     */
    public static String getSelectedDropdownValue(By locator) {
        try {
            Select select = new Select(driver.findElement(locator));
            String selectedValue = select.getFirstSelectedOption().getText();
            return selectedValue;
        } catch (Exception e) {
            return null;
        }
    }

    /* Method getAllOptionsFromDropDown: To get all options from dropdown
     * @param locator  : By : Locator of the dropdown
     */
    public static List<String> getAllOptionsFromDropDown(By locator) {
        List<String> allValue = new ArrayList<String>();
        try {
            Select select = new Select(driver.findElement(locator));
            List<WebElement> allElements = select.getOptions();
            for (WebElement webElement : allElements) {
                allValue.add(webElement.getText());
            }
            return allValue;
        } catch (Exception e) {
            return null;
        }
    }

    /* Method getWebElement: To get required web element from the locator
     * @param locator  : By : Locator of the element
     */
    public static WebElement getWebElement(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element;
        } catch (Exception e) {
            return null;
        }
    }

    /* Method getWebElements: To get all web elements which matches the locator
     * @param locator  : By : Locator of the element
     */
    public static List<WebElement> getWebElements(By locator) {
        try {
            return driver.findElements(locator);
        } catch (Exception e) {
            return null;
        }
    }

    /* Method getElementText: To get text from the element
     * @param locator  : By : Locator of the element
     */
    public static String getElementText(By locator) {
        String text = null;
        if (driver.findElement(locator).isDisplayed())
            text = driver.findElement(locator).getText();
        else
            Assert.fail("\n Get text from  : " + locator + " ************* Failed");
        return text;
    }

    /* Method getElementTextByAttribute: To get text from the attribute of the element
     * @param locator  : By : Locator of the element
     * @param attributeName  : String : attribute name for given locator
     */
    public static String getElementTextByAttribute(By locator, String attributeName) {
        String value = null;
        if (driver.findElement(locator).isDisplayed())
            value = driver.findElement(locator).getAttribute(attributeName);
        else
            Assert.fail("\n Get attribute text from : " + locator + " ************* Failed");
        return value;
    }

    /* Method moveToElement: Move to Element
     * @param locator  : By : Locator of the element that you want move
     */
    public static void moveToElement(By locator) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(locator)).build().perform();
        } catch (Exception e) {
            Assert.fail("\n Unable to move to locator " + locator + " ************* Failed");
        }
    }

    /* Method moveToElementAndClick: Move to Element and click on it
     * @param locator  : By : Locator of the element that you want move and click on it
     */
    public static void moveToElementAndClick(By locator) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(locator)).click().build().perform();
        } catch (Exception e) {
            Assert.fail("\n Click on element with locator : " + locator + " ************* Failed");
        }
    }

    /* Method moveToElementAndDoubleClick: Move to Element and  double click on it
     * @param locator  : By : Locator of the element that you want move and double click on it
     */
    public static void moveToElementAndDoubleClick(By locator) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(locator)).doubleClick().build().perform();
        } catch (Exception e) {
            Assert.fail("\n Double click on element with locator : " + locator + " ************* Failed");
        }
    }

    /* Method switchToNextWindow: Switch to immediate child window
     */
    public static void switchToNextWindow() {
        try {
            parentWindowName = null;
            parentWindowName = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();
            for (String curWindow : allWindows) {
                driver.switchTo().window(curWindow);
            }
        } catch (Exception e) {
            Assert.fail("\n Switch to window ************* Failed");
        }
    }

    /* Method switchToParentWindow: Switch to immediate Parent window
     */
    public static void switchToParentWindow() {
        try {
            driver.switchTo().window(parentWindowName);
            parentWindowName = null;
        } catch (Exception e) {
            Assert.fail("\n Switch to parent window ************* Failed");
        }
    }

    /* Method switchToFrameByIndex: Switch to frame by index
     *@param index  : int : Index of the frame
     */
    public static void switchToFrameByIndex(int index) {

        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            Assert.fail("\n Switch to frame with index " + index + " ************* Failed");
        }
    }

    /* Method switchToFrameByNameOrID: Switch to frame by index
     *@param nameOrId  : String : nameOrId of the frame
     */
    public static void switchToFrameByNameOrID(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (Exception e) {
            Assert.fail("\n Switch to frame with name Or Id " + nameOrId + " ************* Failed");
        }
    }

    /* Method switchToParentFrame: Switch to immediate parent frame
     */
    public static void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            Assert.fail("\n Switch to parent frame ************* Failed");
        }
    }

    /* Method switchToDefaultContent: Switch to super parent frame
     */
    public static void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail("\n Switch to default content ************* Failed");
        }
    }

    /* Method getCurrentURL: To get current URL
     */
    public static String getCurrentURL() {
        try {
            String currentUrl = driver.getCurrentUrl();
            return currentUrl;
        } catch (Exception e) {
            return null;
        }
    }

    /* Method getPageTitle: To get page title of URL
     */
    public static String getPageTitle() {
        try {
            String title = driver.getTitle();
            return title;
        } catch (Exception e) {
            return null;
        }
    }

    /* Method refreshPage: To refresh the current page
     */
    public static void refreshPage() {
        driver.navigate().refresh();
        implicityWaitForPageLoad();
    }

    /* Method switchToAlertAndEnterText: To switch to alert and enter text to the alert
     * @Param :timeInSeconds : int : Wait time in seconds
     * @Param :text : String :Text you want to enter
     */
    public static void switchToAlertAndEnterText(String text) {
        try {
            implicityWaitForPageLoad();
            driver.switchTo().alert().sendKeys(text);
        } catch (Exception e) {
            Assert.fail("\n SendKeys into Alert popup failed");
        }
    }

    /* Method switchToAlertAndGetText: To switch to alert and get text from the alert
     * @Param :timeInSeconds : int : Wait time in seconds
     */
    public static String switchToAlertAndGetText() {
        try {
            implicityWaitForPageLoad();
            String alertText = driver.switchTo().alert().getText();
            return alertText;
        } catch (Exception e) {
            return null;
        }
    }

    /* Method switchToAlertAndAccept: To switch to alert and accept the alert
     * @Param :timeInSeconds : int : Wait time in seconds
     */
    public static void switchToAlertAndAccept() {
        try {
            implicityWaitForPageLoad();
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assert.fail("\n Accept of Alert failed");
        }
    }

    /* Method switchToAlertAndDismiss: To switch to alert and dismiss the alert
     * @Param :timeInSeconds : int : Wait time in seconds
     */
    public static void switchToAlertAndDismiss() {
        try {
            implicityWaitForPageLoad();
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            Assert.fail("\n Dismiss of Alert failed");
        }
    }

    /* Method dragAndDropElements: To drag and drop an element
     * @Param :fromLocator : String : From locator
     * @Param :toLocator : String : To locator
     */
    public static void dragAndDropElements(By fromLocator, By toLocator) {
        try {
            WebElement from = driver.findElement(fromLocator);
            WebElement to = driver.findElement(toLocator);
            Actions action = new Actions(driver);
            action.dragAndDrop(from, to).build().perform();
        } catch (Exception e) {
            Assert.fail("\n Drag and drop element failed");
        }
    }


    public static void waitForPageLoad(int timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds * 1000);
    }

    public static void implicityWaitForPageLoad() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static boolean waitForElementIsClickable(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitForElementIsVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementIsInvisible(By locator) {

        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForFrameAndSwitchToIt(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
