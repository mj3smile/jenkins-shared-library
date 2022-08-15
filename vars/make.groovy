def call(String type) {
	switch(type) {
		case 'build':
			script {
				parallel (
					'stage 1 build': {
						echo 'stage 1'
					}
					'stage 2 build': {
						echo 'stage 2'
					}
				).call()
			}
			break
		case 'deploy':
			script {
				parallel (
					'stage 1 deploy': {
						echo 'stage 1'
					}
					'stage 2 deploy': {
						echo 'stage 2'
					}
				).call()
			}
			break
	}
}