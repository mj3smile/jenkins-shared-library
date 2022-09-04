def call() {
	node('host') {
		sh 'forstok deploy --cluster development'
	}
}