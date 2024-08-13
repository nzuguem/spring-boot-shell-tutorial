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
## Connect to the Minikube Runtime container
eval $(minikube -p minikube docker-env)

## Build Container Image
docker build -t sb-shell .

## Create Job
kubectl apply -f k8s/job.yml

## Display Log
kubectl logs job/sb-shell

## Create Job in Script Mode
kubectl apply -f k8s/job-script.yml -f k8s/job-script.cm.yml

## Display Log
kubectl logs job/sb-shell-script
```

## Clean

```bash
## Delete all Objects
kubectl delete -f k8s/

## Stop Minikube
minikube stop
```

<!-- Links -->
[spring-shell-ref]: https://docs.spring.io/spring-shell/reference/
[k8s-job-doc]: https://kubernetes.io/docs/concepts/workloads/controllers/job/