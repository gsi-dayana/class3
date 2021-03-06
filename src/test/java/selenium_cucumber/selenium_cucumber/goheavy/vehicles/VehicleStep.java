package selenium_cucumber.selenium_cucumber.goheavy.vehicles;

import javafx.scene.control.TabPane;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import selenium_cucumber.selenium_cucumber.general.Setup;
import selenium_cucumber.selenium_cucumber.general.Steps;
import selenium_cucumber.selenium_cucumber.goheavy.driver.pages.DriverPage;
import selenium_cucumber.selenium_cucumber.goheavy.vehicles.page.*;
import selenium_cucumber.selenium_cucumber.google.invalidDataMessages;

@SuppressWarnings("unused")
public class VehicleStep extends Steps {
    public VehiclePage vehiclePage;
    public VehiculeInfoPage vehicleInfo;
    public VehiculeFeaturesPage vehicleFeture;
    public DrivingRequirementsPage drivingRequirements;
    private TabsPage tp;

    public VehicleStep() {
        vehiclePage = new VehiclePage();
        vehicleInfo = new VehiculeInfoPage();
        vehicleFeture = new VehiculeFeaturesPage();
        drivingRequirements = new DrivingRequirementsPage();

    }

    public void checkPage() {
        String path = vehiclePage.getPagePath().toLowerCase();
        Assert.assertTrue(" The path provided is not correct in the url. path: " + path,
                vehiclePage.getCurrentUrl().toLowerCase().contains(path));
    }

    public void goToAccountSettingsView() {
        try {
            Setup.getWait().thread(2500);
            Assert.assertTrue(vehiclePage.goToVehiclesAndInsuranceListView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userClicksOnAddVehicleButton() {
        try {
            Assert.assertTrue(vehiclePage.clickOnAddVehicleButton());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void theSystemOpensTheAddVehicleView() {
        try {
            Assert.assertTrue(vehiclePage.systemOpensAddVehicleView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void hoverOverImageComponent() {
        try {
            Assert.assertTrue(vehiclePage.hoverOverImageComponent());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userInsertsValidDataAndClicksDone() {

        try {
            TabsPage tp = new VehiculeInfoPage();
            tp.insertValidData();
            tp = new VehiculeFeaturesPage();
            tp.insertValidData();
            tp = new DrivingRequirementsPage();
            tp.insertValidData();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userIntroduceInvalidData() {
        try {
            TabsPage tp = new VehiculeInfoPage();
            tp.insertInvalidData();
//            tp = new VehiculeFeaturesPage();
//            tp.insertInvalidData();
//            tp = new DrivingRequirementsPage();
//            tp.insertInvalidData();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void systemCreatesVehicleOnStatus(String status) {
        try {
            Assert.assertNotNull(vehiclePage.systemCreatesVehicleOnStatus(status));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void systemRegistersCreationDate() {
        try {
            Assert.assertNotNull(vehiclePage.systemsRegistersCreationDate());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void returnToMainView() {
        checkPage();
    }

    public void systemDisplaysAssignView() {
        try {
            Assert.assertTrue(vehiclePage.systemDisplaysAssignView());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void userAssignsTheVehicle() {
        try {
            Assert.assertTrue(vehiclePage.userAssignsTheVehicle());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public void clicks_button_done() {

        vehiclePage.clicks_button_done();
    }

    public void systemDisplaysMessage(String message) {
        vehiclePage.systemDisplaysMessage(message);
    }

    public void verifyErrorSMS() {
        try {
            TabsPage tp = new VehiculeInfoPage();
            tp.checkErrorSMS();
//            tp = new VehiculeFeaturesPage();
//            tp.checkErrorSMS();
//            tp = new DrivingRequirementsPage();
//            tp.checkErrorSMS();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
