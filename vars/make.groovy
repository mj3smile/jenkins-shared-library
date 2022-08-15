def call(String type) {
	switch(type) {
		case 'build':
			parallel (
				'stage 1 build': {
					steps {
						echo 'stage 1'
					}
				}
				'stage 2 build': {
					steps {
						echo 'stage 2'
					}
				}
			).call()
			break
		case 'deploy':
			parallel (
				'stage 1 deploy': {
					steps {
						echo 'stage 1'
					}
				}
				'stage 2 deploy': {
					steps {
						echo 'stage 2'
					}
				}
			).call()
			break
	}
}