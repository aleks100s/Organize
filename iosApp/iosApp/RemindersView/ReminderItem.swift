//
//  ReminderItem.swift
//  iosApp
//
//  Created by Alexander on 24.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

import SwiftUI

struct ReminderItem: View {
	let title: String
	let isCompleted: Bool
	
	var body: some View {
		HStack {
			Image(systemName: isCompleted ? "largecircle.fill.circle" : "circle")
				.imageScale(.large)
				.foregroundColor(isCompleted ? .accentColor : .secondary)
			Text(title)
				.font(.body)
				.strikethrough(isCompleted, color: nil)
				.foregroundColor(isCompleted ? .secondary : .primary)
			Spacer()
		}
		.contentShape(Rectangle())
	}
}

struct ReminderItem_Previews: PreviewProvider {
	static var previews: some View {
		Group {
			ReminderItem(title: "New Item", isCompleted: false)
			ReminderItem(title: "Done Item", isCompleted: true)
		}
		.previewLayout(.sizeThatFits)
	}
}
