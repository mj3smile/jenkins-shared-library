def call(String type) {
	switch(type) {
		case 'build':
			def arch = [x86: false, arm: false]
		    def configs = readYaml file: 'config.yml'
		    def services = configs.services

		    services.each { s ->
		        def serviceArch = s.getAt('arch')
		        if (serviceArch == 'arm' && !arch.arm) {
		            arch.arm = true
		        } else if (serviceArch == 'x86' && !arch.x86) {
		            arch.x86 = true
		        }
		    }

		    if (arch.arm && !arch.x86) {
		    	return {
					parallel (
						'arm': {
							echo 'do build arm'
						}
					)
				}
		    } else if (!arch.arm && arch.x86) {
		    	return {
					parallel (
						'x86': {
							echo 'do build x86'
						}
					)
				}
	    	} else {
	    		return {
					parallel (
						'arm': {
							echo 'do build arm'
						},
						'x86': {
							echo 'do build x86'
						}
					)
				}
	    	}
			break
		
		case 'deploy':
			return {
				parallel (
					'stage 1 deploy': {
						echo 'stage 1 deploy'
					},
					'stage 2 deploy': {
						echo 'stage 2 deploy'
					}
				)
			}
			break
	}
}