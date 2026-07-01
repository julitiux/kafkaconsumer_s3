# consumer_s3


# Start service Minio 

```terminal
docker run -d \
  --name minio \
  -p 9000:9000 \
  -p 9001:9001 \
  -e MINIO_ROOT_USER=minio \
  -e MINIO_ROOT_PASSWORD=minio123 \
  quay.io/minio/minio server /data --console-address ":9001"
```

# url minio
> http://localhost:9001/

user: minio
password: minio123