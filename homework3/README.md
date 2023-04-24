Домашнее задание
Инфраструктурные паттерны

Цель:
В этом ДЗ вы создадите простейший RESTful CRUD.


Описание/Пошаговая инструкция выполнения домашнего задания:
Сделать простейший RESTful CRUD по созданию, удалению, просмотру и обновлению пользователей.
Пример API - https://app.swaggerhub.com/apis/otus55/users/1.0.0
Добавить базу данных для приложения.
Конфигурация приложения должна хранится в Configmaps.
Доступы к БД должны храниться в Secrets.
Первоначальные миграции должны быть оформлены в качестве Job-ы, если это требуется.
Ingress-ы должны также вести на url arch.homework/ (как и в прошлом задании)
На выходе должны быть предоставлена

1. ссылка на директорию в github, где находится директория с манифестами кубернетеса
2. инструкция по запуску приложения. 
   1. команда установки БД из helm, вместе с файлом values.yaml. 
   2. команда применения первоначальных миграций
   3. команда kubectl apply -f, которая запускает в правильном порядке манифесты кубернетеса 
3. Postman коллекция, в которой будут представлены примеры запросов к сервису на создание, получение, изменение и удаление пользователя. Важно: в postman коллекции использовать базовый url - arch.homework.

Задание со звездочкой:
+5 балла за шаблонизацию приложения в helm чартах

Выполнение
1. https://github.com/Rintaar/otus-microservices/tree/master/homework3
2. helm install postgres bitnami/postgresql -f ./scripts/values.yaml
3. kubectl apply -f ./scripts/config.yaml -f ./scripts/deployment.yaml -f ./scripts/service.yaml -f ./scripts/ingress.yaml
4. Postman: https://github.com/Rintaar/otus-microservices/blob/master/homework3/postman/homework3.postman_collection.json

Удаление:
* helm delete postgres
* kubectl delete deployment otus-homework3-deployment  
* kubectl delete service otus-homework3-service  
* kubectl delete secrets otus-homework3-secret
* kubectl delete configmap otus-homework3-config
* kubectl delete ingress otus-homework3-ingress


