//
//  AboutView.swift
//  iosApp
//
//  Created by Alexander on 22.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct AboutView: View {
	@Environment(\.dismiss) private var dismiss
	
	var body: some View {
		NavigationView {
			AboutListView()
				.navigationTitle("About Device")
				.toolbar {
					ToolbarItem(placement: .primaryAction) {
						Button {
							dismiss()
						} label: {
							Text("Done")
								.bold()
						}
					}
				}
		}
	}
}

struct AboutView_Previews: PreviewProvider {
	static var previews: some View {
		AboutView()
	}
}
