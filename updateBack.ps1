docker build -t springboot-rcpmgr:latest .
docker tag springboot-rcpmgr:latest therdeancontainerregistry.azurecr.io/springboot-rcpmgr:latest
docker push therdeancontainerregistry.azurecr.io/springboot-rcpmgr:latest
kubectl rollout restart deployment springboot-rcpmgr