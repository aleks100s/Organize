//
//  iosAppUITests.swift
//  iosAppUITests
//
//  Created by Alexander on 24.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import XCTest

final class iosAppUITests: XCTestCase {
	private let app = XCUIApplication()

    override func setUp() {
        continueAfterFailure = false
		app.launch()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testExample() throws {
		XCTAssert(app.buttons["aboutButton"].exists)
    }
	
	func testOpeninAndClosingAboutPage() {
		
		let app = XCUIApplication()
		app.toolbars["Toolbar"]/*@START_MENU_TOKEN@*/.buttons["aboutButton"]/*[[".otherElements[\"About\"]",".buttons[\"About\"]",".buttons[\"aboutButton\"]",".otherElements[\"aboutButton\"]"],[[[-1,2],[-1,1],[-1,3,1],[-1,0,1]],[[-1,2],[-1,1]]],[0]]@END_MENU_TOKEN@*/.tap()
		app.navigationBars["About Device"]/*@START_MENU_TOKEN@*/.buttons["Done"]/*[[".otherElements[\"Done\"].buttons[\"Done\"]",".buttons[\"Done\"]"],[[[-1,1],[-1,0]]],[0]]@END_MENU_TOKEN@*/.tap()
		
	}

    func testLaunchPerformance() throws {
        if #available(macOS 10.15, iOS 13.0, tvOS 13.0, watchOS 7.0, *) {
            // This measures how long it takes to launch your application.
            measure(metrics: [XCTApplicationLaunchMetric()]) {
                XCUIApplication().launch()
            }
        }
    }
}
