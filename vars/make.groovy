def call(String type) {
	switch(type) {
		case 'build':
			parallel (
				'stage 1 build': {
					echo 'stage 1 build'
				},
				'stage 2 build': {
					echo 'stage 2 build'
				}
			).call()
			break
		case 'deploy':
			parallel (
				'stage 1 deploy': {
					echo 'stage 1 deploy'
				},
				'stage 2 deploy': {
					echo 'stage 2 deploy'
				}
			).call()
			break
	}
}