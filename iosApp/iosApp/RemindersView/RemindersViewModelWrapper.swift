//
//  RemindersViewModelWrapper.swift
//  iosApp
//
//  Created by Alexander on 24.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared
import Combine

final class RemindersViewModelWrapper: ObservableObject {
	let viewModel = RemindersViewModel()
	
	@Published private(set) var reminders: [Reminder] = []
	
	init() {
		viewModel.onRemindersUpdated = { [weak self] items in
			self?.reminders = items
		}
	}
}
