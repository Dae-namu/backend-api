# 🎬 Daenamu MSA Backend API

- MSA를 기반으로 설계된 스트리밍 백엔드 시스템
- 각 서비스는 독립적으로 배포되고 Istio 기반 서비스 메시를 통해 트래픽 추적 및 관찰 가능
---
## 📦 서비스 구조
![image](https://github.com/user-attachments/assets/99195221-740c-4c86-b54c-b53767d3cc8e)

- `drama-service`: 드라마 목록, 상세 조회
- `episode-service`: 특정 드라마의 에피소드 목록 제공
- `stream-service`: 특정 에피소드의 영상 스트리밍 URL(Presigned S3 URL) 제공

---
## 🛠 기술 스택

| 기술 | 설명 |
|------|------|
| Spring Boot 3.2.5 | 마이크로서비스 개발 및 presigned URL 제공 |
| Spring Cloud OpenFeign | 서비스 간 통신 |
| MySQL (RDS) | 영상 메타 데이터 저장 |
| AWS S3 | 영상 파일 저장 |
| Kubernetes (Minikube) | 로컬 개발 환경 |
| Istio | 서비스 메시 및 트래픽 관측 |
| Jaeger | 분산 추적 시각화 도구 |
| Docker | 컨테이너 이미지 생성 |
| Helm | Kubernetes 배포 관리 |

---
## 📁 서비스별 API

### 🎭 drama-service

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/dramas` | 전체 드라마 목록 조회 |
| GET | `/dramas/{id}` | 드라마 상세 정보 및 에피소드 목록 조회 |

### 🎞 episode-service

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/episodes/drama/{dramaId}` | 특정 드라마의 에피소드 전체 조회 |
| GET | `/episodes/{id}` | 특정 에피소드 단건 조회 |

### 📺 stream-service

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/streams/drama/{dramaId}/episode/{episodeId}` | 해당 에피소드의 S3 presigned URL 반환 |

---

