pipeline {
  agent any

  tools {
    maven "MAVEN_363"
    jdk "JDK_8"
  }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'master', poll: false, url: 'https://github.com/aabarmin/epam-microservices-training-2020.git'
      }
    }
    stage('Build') {
      steps {
        sh "mvn -Dmaven.test.skip=true clean package -P !contract-test,!integration-tests"
      }
    }
    stage('Test') {
      steps {
        sh "mvn test -P !contract-test,!integration-tests"
      }
    }
    stage('Publish test results') {
      steps {
        junit '**/target/surefire-reports/*.xml'
      }
    }
    stage('Publish test coverage report') {
      steps {
        jacoco execPattern: 'coverage-report/target/**/**.exec'
      }
    }
  }
}
