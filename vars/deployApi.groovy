def call() {
	sh 'ssh mj@127.0.0.1 \'cd /home/mj/jenkins/workspace/shared-library-tr && forstok deploy --cluster api\''
}