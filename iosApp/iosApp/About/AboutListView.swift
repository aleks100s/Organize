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
	private let items: [RowItem] = {
		let platform = Platform()
		var result: [RowItem] = [
			.init(title: "Operating System", subtitle: "\(platform.osName) \(platform.osVersion)"),
			.init(title: "Device", subtitle: platform.deviceModel),
			.init(title: "CPU", subtitle: platform.cpuType)
		]
		
		if let screen = platform.screen {
			let width = min(screen.width, screen.height)
			let height = max(screen.width, screen.height)
			result.append(.init(title: "Display", subtitle: "\(width)x\(height) @\(screen.density)x"))
		}
		
		return result
	}()
	
    var body: some View {
		List {
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

extension AboutListView {
	private struct RowItem: Hashable {
		let title: String
		let subtitle: String
	}
}

struct AboutListView_Previews: PreviewProvider {
    static var previews: some View {
        AboutListView()
    }
}
