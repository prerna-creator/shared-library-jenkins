def call() {
  echo 'pushing docker image to dockerhub'
  withCredentials([usernamePassword(
      credentialsId: 'dockerhub',
      usernameVariable: 'DOCKERHUB_USER',
      passwordVariable: 'DOCKERHUB_PASS'
  )]) {
    // Use a single shell block so env is shared; avoid logging the password
    sh '''
      set -e
      echo "$DOCKERHUB_PASS" | docker login -u "$DOCKERHUB_USER" --password-stdin
      docker image tag order-service:latest prernasingh111/my-image:v1
      docker push prernasingh111/my-image:v1
      docker logout
    '''
  }
}
