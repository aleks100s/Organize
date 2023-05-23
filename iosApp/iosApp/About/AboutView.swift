//
//  AboutView.swift
//  iosApp
//
//  Created by Alexander on 22.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutView: View {
	@StateObject private var viewModel = AboutViewModel()
	@Environment(\.dismiss) private var dismiss
	
	var body: some View {
		NavigationView {
			AboutListView(items: viewModel.items)
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

extension AboutViewModel: ObservableObject {}

struct AboutView_Previews: PreviewProvider {
	static var previews: some View {
		AboutView()
	}
}
