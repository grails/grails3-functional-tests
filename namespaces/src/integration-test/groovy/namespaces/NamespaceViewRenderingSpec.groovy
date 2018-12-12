package namespaces

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import spock.lang.*
import geb.spock.*

/**
 */
@Integration(applicationClass = Application)
@Rollback
class NamespaceViewRenderingSpec extends GebSpec {

    void "Test view rendering works as expected when namespaces are used"() {
        when:"When an implicit namespace is used"
            go '/myAppTest/test/implicitView'

        then:"The view is rendered"
        	$('body').text() == "Implicit View Rendered!"

        when:"When an explicit view with a namespace is used"
            go '/myAppTest/test/explicitView'

        then:"The view is rendered"
        	$('body').text() == "Foo View Rendered"
    }
}
