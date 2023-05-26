import shared

final class Koin {
	static let instance = Koin()
	
	private var core: Koin_coreKoin?
	
	static func start() {
		if instance.core == nil {
			let app = KoinIOS.shared.initialize(
				userDefaults: UserDefaults.standard
			)
			instance.core = app.koin
		}
		if instance.core == nil {
			fatalError("Can't initialize Koin")
		}
	}
	
	private init() {}
	
	func get<T: AnyObject>() -> T {
		guard let core = core else {
			fatalError("You should call `start()` before using \(#function)")
		}
		
		guard let result = core.get(objCClass: T.self) as? T else {
			fatalError("Koin can't provide an instance of type \(T.self)")
		}
		
		return result
	}
}
