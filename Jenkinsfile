pipeline {
  agent any
  stages {
    stage('checkout') {
      steps {
        git(url: 'https://github.com/thaleshXor/seleniumDocker2', branch: 'master')
      }
    }

    stage('execution') {

      steps {
        sh 'docker run -it -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:latest
        sh 'mvn test -DvarTestng="testng1.xml" -DBROWSER="chrome"'
      }
    }

  }
}
