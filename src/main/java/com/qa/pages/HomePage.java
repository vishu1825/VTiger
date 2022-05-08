package com.qa.pages;

import com.qa.enums.WaitStrategy;
import org.openqa.selenium.By;

public class HomePage extends BasePage {


    private By lead_link = By.xpath("//a[text()='Leads']");

    public LeadPage clickOnLeadLink() throws Exception {
        click(lead_link , WaitStrategy.CLICKABLE ,"LeadLink");
        return new LeadPage();

    }

}
