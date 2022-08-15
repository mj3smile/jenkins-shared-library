def call(String type) {
	switch(type) {
		case 'build':
			return {
				stages {
					stage('stage 1 build') {
						steps {
							echo 'stage 1'
						}
					}
					stage('stage 2 build') {
						steps {
							echo 'stage 2'
						}
					}
				}
			}
			break
		case 'deploy':
			return {
				stages {
					stage('stage 1 deploy') {
						steps {
							echo 'stage 1'
						}
					}
					stage('stage 2 deploy') {
						steps {
							echo 'stage 2'
						}
					}
				}
			}
			break
	}
}