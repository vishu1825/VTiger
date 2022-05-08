package com.qa.pages;

import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LeadPage extends BasePage{

    private By createlead = By.xpath("//img[contains(@title,'Create Lead')]");

    public CreateLeadPage clickOnCreateLeadLink() throws Exception {
        click(createlead , WaitStrategy.CLICKABLE ,"CreateLeadLink");
        return new CreateLeadPage();

    }
}
