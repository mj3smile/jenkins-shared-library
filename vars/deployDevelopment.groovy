def call() {
	sh 'echo $ENV_GPG_PASSPHRASE'
	sh 'ssh mj@127.0.0.1 \'cd /home/mj/jenkins/workspace/shared-library-tr && export ENV_GPG_PASSPHRASE=$(echo $ENV_GPG_PASSPHRASE) && forstok deploy --cluster development\''
}