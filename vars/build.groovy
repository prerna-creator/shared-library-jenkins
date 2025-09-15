def call(){
 echo 'building docker image from dockerfile'
 sh " docker build -t order-service:latest ."
}
