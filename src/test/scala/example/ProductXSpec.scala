package example

import org.junit.runner.RunWith
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProductXSpec extends FeatureSpec with GivenWhenThen {
  scenario("""Product X has been configured and added to quote,
    it should display relevant pricing summary for Product X in Quote Summary Page""")

        given("Product X has been configured and added to Quote")
 
        new CustomerFixture(browser).searchCustomer7789()
        CustomerProjectsFixture projects = new CustomerProjectsFixture(browser)
        projects.createProjectGlobalInc()
        projects.selectProjectGlobalInc()
        // Add products X Global Inc.
        ProjectFixture project = new ProjectFixture(browser)
        project.addProductX()
        // Configure product X
        project.selectProductXForConfiguration()
        new ProductXConfigurationFixture(browser).configure()
        project.browseToProjectGlobalInc()

        when("Pricing Summary is produced")
        QuoteProductFixture projectItems = new QuoteProductFixture(browser)
        projectItems.selectProductsForQuote(RSQE_PRODUCT_X, RSQE_PRODUCT_Q)

        then("""I should see the pricing information for Product X
                on the pricing sheet and show a status of 'QUOTED'""")
                // Assertions to be made
        pending
}