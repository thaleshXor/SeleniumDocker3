pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/thaleshXor/seleniumDocker2', branch: 'master')
      }
    }

    stage('execution') {
      agent {
        docker {
          image '87619f0977fc'
        }

      }
      steps {
        sh 'mvn test -DvarTestng="testng1.xml" -DBROWSER="chrome"'
      }
    }

  }
}