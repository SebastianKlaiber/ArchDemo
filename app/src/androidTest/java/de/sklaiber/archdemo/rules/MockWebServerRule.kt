package de.sklaiber.archdemo.rules

import io.appflate.restmock.JVMFileParser
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.RESTMockServerStarter
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class MockWebServerRule : TestRule {

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                // Start the mock server before running a test
                RESTMockServerStarter.startSync(JVMFileParser())

                // Evaluate the current running test
                base?.evaluate()

                // After the test reset the mock server
                RESTMockServer.reset()
            }
        }
    }
}