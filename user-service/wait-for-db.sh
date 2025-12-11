#!/usr/bin/env bash
set -e

# WAIT_FOR example: "postgres-db:5432,mongo:27017"
IFS=',' read -r -a hosts <<< "${WAIT_FOR:-}"

for host in "${hosts[@]}"; do
  if [[ -z "$host" ]]; then continue; fi
  hostname=$(echo "$host" | cut -d: -f1)
  port=$(echo "$host" | cut -d: -f2)
  echo "Waiting for $hostname:$port ..."
  until nc -z "$hostname" "$port"; do
    sleep 1
  done
  echo "$hostname:$port reachable"
done

exec "$@"
