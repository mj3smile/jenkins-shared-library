def call() {
	node('host') {
		sh 'forstok build --arch x86'
	}
}