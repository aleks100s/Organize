//
//  RemindersView.swift
//  iosApp
//
//  Created by Alexander on 22.05.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct RemindersView: View {
	@StateObject private var viewModelWrapper = RemindersViewModelWrapper()
	@State private var textFieldValue = ""
	@FocusState private var shouldFocusOnTextField: Bool
	
	var body: some View {
		List {
			if !viewModelWrapper.reminders.isEmpty {
				Section {
					ForEach(viewModelWrapper.reminders, id: \.id) { item in
						ReminderItem(title: item.title, isCompleted: item.isCompleted)
							.onTapGesture {
								withAnimation {
									viewModelWrapper.viewModel.markReminder(
										id: item.id,
										isCompleted: !item.isCompleted
									)
									shouldFocusOnTextField = false
								}
							}
					}
				}
			}
			
			Section {
				NewReminderTextField(text: $textFieldValue) {
					withAnimation {
						viewModelWrapper.viewModel.createReminder(title: textFieldValue)
						shouldFocusOnTextField = true
						textFieldValue = ""
					}
				}
				.focused($shouldFocusOnTextField)
			}
		}
			.navigationTitle("Reminders")
			.toolbar {
				ToolbarItemGroup(placement: .keyboard) {
					Spacer()
					Button("Done") {
						shouldFocusOnTextField = false
					}
				}
			}
	}
}

struct RemindersView_Previews: PreviewProvider {
	static var previews: some View {
		RemindersView()
	}
}
