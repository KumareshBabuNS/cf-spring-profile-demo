#!/usr/bin/env bash
cf create-service p-mysql 100mb-dev db
cf create-user-provided-service my-service -p '{"somekey":"somevalue","anotherkey":"anothervalue"}'
