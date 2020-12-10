pipeline {
    agent any
    stages {
		stage('GitPull'){
			steps{
				echo "Cleaning Workspace is starting"
				cleanWs()
				echo "Cleaning Workspace is completed"
				echo "Git Pull is starting"
				git credentialsId: '95ad5ee0-7934-48a9-a302-72e083a9b98e', url: 'https://github.com/panagch/OSMIntegrated', branch: 'master'
				echo "Git Pull is completed"
            }
		}
        stage('REST request with Cucumber'){
            steps{
				echo "Suite execution is starting"
				bat "mvn test"
				echo "Suite execution is completed"
			}
        }
    }
}
