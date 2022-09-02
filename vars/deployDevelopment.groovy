def call() {
	sh 'ssh mj@127.0.0.1 \'cd /home/mj/jenkins/workspace/shared-library-tr && export ENV_GPG_PASSPHRASE=$ENV_GPG_PASSPHRASE && forstok deploy --cluster development\''
}