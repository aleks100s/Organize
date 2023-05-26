//
//  AboutListView.swift
//  iosApp
//
//  Created by Alexander on 22.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutListView: View {	
	let items: [AboutViewModel.RowItem]
	let footer: String
	
    var body: some View {
		List {
			Section(
				footer: Text(footer)
					.font(.caption2)
					.foregroundColor(.secondary)
			) {
				ForEach(items, id: \.self) { item in
					VStack(alignment: .leading) {
						Text(item.title)
							.font(.footnote)
							.foregroundColor(.secondary)
						
						Text(item.subtitle)
							.font(.body)
							.foregroundColor(.primary)
					}
					.padding(.vertical, 4)
				}
			}
		}
    }
}

struct AboutListView_Previews: PreviewProvider {
    static var previews: some View {
		AboutListView(
			items: [AboutViewModel.RowItem(title: "Title", subtitle: "Subtitle")],
			footer: "Section Footer"
		)
    }
}
