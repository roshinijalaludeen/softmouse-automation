package softmouse.tests;

import softmouse.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import softmouse.pages.CagePage;
import softmouse.pages.LoginPage;

    public class VerifyCageTest extends BaseTest {
        @Test
        public void testCageAppearsInList() {
            new LoginPage(driver).login("roshiniseehear", "SoftMouse@07");
            CagePage cagePage = new CagePage(driver);
            Assert.assertTrue(cagePage.isCagePresent("Cage_A1"));
        }
    }
