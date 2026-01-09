#!/usr/bin/env sh

echo "Injecting API_URL into Angular build..."

sed -i "s|\${API_URL}|${API_URL}|g" src/environments/environment.prod.ts
