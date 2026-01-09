FROM node:18-alpine AS build
WORKDIR /app
ARG API_URL
ENV API_URL=${API_URL}
COPY package*.json ./
RUN npm ci --silent
COPY . .

# Create environment.prod.ts at build time so the compiled app points to the correct API URL
RUN mkdir -p src/environments && \
	echo "export const environment = { production: true, apiUrl: '${API_URL:-http://localhost:8080}' };" > src/environments/environment.prod.ts

RUN npm run build -- --output-path=dist --configuration=production

FROM nginx:stable-alpine
COPY --from=build /app/dist/ /usr/share/nginx/html/
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
