def call() {
	sh 'ssh mj@127.0.0.1 \'cd /home/mj/jenkins/workspace/shared-library-tr && export ENV_GPG_PASSPHRASE=$(echo $ENV_FILE) && forstok deploy --cluster api\''
}