def call(String type) {
	def configs = readYaml file: 'config.yml'
	def services = configs.services
	def arch = [x86: false, arm: false]
	def cluster = [polling: false, development: false, api: false]

    services.each { s ->
        def serviceArch = s.getAt('arch')
        if (serviceArch == 'arm' && !arch.arm) {
            arch.arm = true
        } else if (serviceArch == 'x86' && !arch.x86) {
            arch.x86 = true
        }

        def serviceCluster = s.getAt('cluster')
        if (serviceCluster == 'development' && !cluster.development) {
            cluster.development = true
        } else if (serviceCluster == 'polling' && !cluster.polling) {
            cluster.polling = true
        } else if (serviceCluster == 'api' && !cluster.api) {
            cluster.api = true
        }
    }
	
	switch(type) {
		case 'build':
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
			clusters = [:]
			cluster.each { name, state ->
				if (state) {
					clusters["${name}"] = {
						echo "do deploy to ${name} cluster"
					}
				}
			}
			return {
				parallel clusters
			}
			break
	}
}