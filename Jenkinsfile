pipeline{
agent any
stages{
	stage('checkout'){
		steps{
			git(url: 'https://github.com/thaleshXor/SeleniumDocker3', branch: 'master')
		}

	}
	stage('execution'){
		
		steps{
			echo '>>>>>>>>>>>>>>>>>>>>>>>'
			echo pwd
			sh 'docker-compose up -d'
			sh 'mvn test -DvarTestng="testng.xml"'
			sh 'docker-compose down'
		}

	}
}
}
