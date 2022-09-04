def call() {
	node('host') {
		sh 'forstok build --arch arm'
	}
}