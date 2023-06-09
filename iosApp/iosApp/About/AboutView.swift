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
	@StateObject private var viewModel: AboutViewModel = Koin.instance.get()
	@Environment(\.dismiss) private var dismiss
	
	var body: some View {
		NavigationView {
			AboutListView(
				items: viewModel.items,
				footer: "This page was first opened on \(viewModel.firstOpening)"
			)
				.navigationTitle(viewModel.title)
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
