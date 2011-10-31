package example

import org.junit.runner.RunWith
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProductXSpec extends FeatureSpec with GivenWhenThen {

  feature("Pricing Summary screen") {
    info("As a Sales User")
    info("I want to see pricing information for Product X")
    info("So that I know what I will pay before I order it")
    info("STORY-ID: XYZ-1234")

    scenario("""Product X has been configured and added to quote,
                it should display relevant pricing summary for Product X in Quote Summary Page""") {

        given("Product X has been configured and added to Quote")
        new CustomerFixture(browser).searchCustomer7789()
        var projects = new CustomerProjectsFixture(browser)
        projects.createProjectGlobalInc()
        projects.selectProjectGlobalInc()
        // Add products X Global Inc.
        var project = new ProjectFixture(browser)
        project.addProductX()
        // Configure product X
        project.selectProductXForConfiguration()
        new ProductXConfigurationFixture(browser).configure()
        project.browseToProjectGlobalInc()

        when("Pricing Summary is produced")
        var projectItems = new QuoteProductFixture(browser)
        projectItems.selectProductsForQuote(RSQE_PRODUCT_X, RSQE_PRODUCT_Q)

        then("""I should see the pricing information for Product X
                on the pricing sheet and show a status of 'QUOTED'""")
        pending
    }
  }
}