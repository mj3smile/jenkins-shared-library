def call() {
	echo "do deploy to polling cluster."
	withCredentials([string(credentialsId: 'ENV_GPG_PASSPHRASE', variable: 'ENV_GPG_PASSPHRASE')]) {
      sh 'python3 env.py'
    }
}