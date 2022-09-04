def call() {
	node('host') {
		sh 'pwd'
		sh 'forstok build --arch x86'
	}
}