# Spring Boot Shell Tutorial

## Késako ?
This project allows you to explore the [`Spring Shell`][spring-shell-ref] module and experiment with its integration with Kubernetes [`Job`][k8s-job-doc].

## Prerequisites
- Install **Java 21** (GraalVM would be ideal)
  ```bash
  sdk env install
  ```
- Installing **Minikube** and starting a cluster
  ```bash
  minikube start
  ```
- Installing **Docker**

## Testing outside Kubernetes

### JVM mode

```bash
## Build and Package
./mvnw package 

## Run Help Command
java -jar target/spring-boot-shell-tutorial-0.0.1-SNAPSHOT.jar hello --help

## Run Command
java -jar target/spring-boot-shell-tutorial-0.0.1-SNAPSHOT.jar hello --name "Ulrich"
```
### Native Mode

```bash
## Build DYNAMIC Native Image
./mvnw native:compile -Pnative

## Run Help Command
./target/spring-boot-shell-tutorial hello --help

## Run Command
./target/spring-boot-shell-tutorial hello --name "Ulrich"
```

## Testing inside Kubernetes

```bash
## Export Fulling IMAGE_NAME -> Using Ephemeral Container Registry "https://ttl.sh"
export IMAGE_NAME="ttl.sh/$(uuidgen | tr '[:upper:]' '[:lower:]'):1h"

## Build Container Image
docker build --push -t $IMAGE_NAME .

## Create Job
envsubst '$IMAGE_NAME' < k8s/job.yml | kubectl apply -f -

## Display Log
kubectl logs job/sb-shell

## Create Job in Script Mode
envsubst '$IMAGE_NAME' < k8s/job-script.yml | kubectl apply -f -
kubectl apply -f k8s/job-script.cm.yml

## Display Log
kubectl logs job/sb-shell-script
```

## Clean

```bash
## Delete all Objects
kubectl delete job/sb-shell job/sb-shell-script

## Stop Minikube
minikube stop
```

<!-- Links -->
[spring-shell-ref]: https://docs.spring.io/spring-shell/reference/
[k8s-job-doc]: https://kubernetes.io/docs/concepts/workloads/controllers/job/